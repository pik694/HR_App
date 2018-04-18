package pik.pw.recruitme.app.model.recruiter

import pik.pw.recruitme.app.model.recruiter.domain.InMemoryRecruiterRepository
import pik.pw.recruitme.app.model.recruiter.domain.RecruiterFacade
import pik.pw.recruitme.app.model.recruiter.domain.SampleRecruiters

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.data.domain.PageImpl
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import spock.lang.Specification
import spock.mock.DetachedMockFactory

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

import java.awt.print.Pageable

@WebMvcTest([RecruiterController, RecruiterTestConfig])
class RecruiterControllerSliceSpec extends Specification implements SampleRecruiters {

    @TestConfiguration
    static class RecruiterTestConfig {
        DetachedMockFactory detachedMockFactory = new DetachedMockFactory();

        @Bean
        RecruiterFacade recruiterFacade() {
            return  detachedMockFactory.Stub(RecruiterFacade)
        }
    }

    @Autowired
    RecruiterFacade recruiterFacade

    @Autowired
    MockMvc mockMvc

    @WithMockUser
    def "asking for non existing recruiter should return 404"(){
        given: "there is no recruiter with id I want"
            int nonExistingId = 1
            recruiterFacade.show(nonExistingId) >> { throw new InMemoryRecruiterRepository.RecruiterNotFoundException(nonExistingId)}

        expect: "I get 404 and a message"
            mockMvc.perform(get("/recruiter/$nonExistingId"))
                .andExpect(status().isNotFound())
                .andExpect(content().json("""
                    {
                        "message": "Could not find a recruiter with id: 1"
                    } """))

    }

    @WithMockUser
    def "should get recruiters"() {
        given: 'inventory has two recruiters'
            recruiterFacade.findAll(_) >> { Pageable pageable -> new PageImpl([jkowalski, akwiatkowska], pageable, 2) }

        when: 'I go to /recruiters'
            ResultActions getRecruiters = mockMvc.perform(get("/recruiters"))

        then: 'I see list of those recruiters'
            getRecruiters.andExpect(status().isOk())
                            .andExpect(content().json("""
                            {
                                "content": [
                                    {"id":"$jkowalski.id", "name":"$jkowalski.name", "surname":"$jkowalski.surname"},
                                    {"id":"$akwiatkowska.id", "name":"$akwiatkowska.name", "surname":"$akwiatkowska.surname"}
                                ]
                            }""", false))
    }

    @WithMockUser
    def "should get recruiter"() {
        given: 'inventory has the recruiter with id 1 and the recruiter with id 2'
            recruiterFacade.show(jkowalski.id) >> jkowalski

        when: 'I go to /recruiter'
            ResultActions getRecruiter = mockMvc.perform(get("/recruiter/$jkowalski.id"))

        then: 'I see details of that recruiter'
            getRecruiter.andExpect(status().isOk())
                            .andExpect(content().json("""
                                    {"id":"$jkowalski.id", "name":"$jkowalski.name", "surname":"$jkowalski.surname"},
                            """, false))
    }
}
