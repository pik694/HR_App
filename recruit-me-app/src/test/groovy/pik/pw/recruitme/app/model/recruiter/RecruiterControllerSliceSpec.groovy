package pik.pw.recruitme.app.model.recruiter

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import pik.pw.recruitme.app.model.recruiter.domain.RecruiterFacade
import pik.pw.recruitme.app.model.recruiter.domain.RecruiterNotFoundException
import pik.pw.recruitme.app.model.recruiter.domain.SampleRecruiters
import spock.lang.Specification
import spock.mock.DetachedMockFactory

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest([RecruiterController, RecruiterTestConfig])
class RecruiterControllerSliceSpec extends Specification implements SampleRecruiters {

    @TestConfiguration
    static class RecruiterTestConfig {
        DetachedMockFactory detachedMockFactory = new DetachedMockFactory();

        @Bean
        RecruiterFacade recruiterFacade() {
            return detachedMockFactory.Stub(RecruiterFacade)
        }
    }

    @Autowired
    RecruiterFacade recruiterFacade

    @Autowired
    MockMvc mockMvc

    def "asking for non existing recruiter should return 404"() {
        given: "there is no recruiter with id I want"
        int nonExistingId = 1
        recruiterFacade.show(nonExistingId) >> { throw new RecruiterNotFoundException(nonExistingId) }

        expect: "I get 404 and a message"
        mockMvc.perform(get("/recruiter/$nonExistingId"))
                .andExpect(status().isNotFound())
                .andExpect(content().json("""
                    {
                        "message": "Could not find a recruiter with id: 1"
                    } """))

    }

    def "should get recruiters"() {
        given: 'inventory has two recruiters'
        recruiterFacade.findAll(_) >> { Pageable pageable -> new PageImpl([smith, jones], pageable, 2) }

        when: 'I go to /recruiters'
        ResultActions getRecruiters = mockMvc.perform(get("/recruiters"))

        then: 'I see list of those recruiters'
        getRecruiters.andExpect(status().isOk())
                .andExpect(content().json("""
                            {
                                "content": [
                                    {"id":$smith.id, "name":"$smith.name", "surname":"$smith.surname"},
                                    {"id":$jones.id, "name":"$jones.name", "surname":"$jones.surname"}
                                ]
                            }""", false))
    }

    def "should get recruiter"() {
        given: 'inventory has the recruiter with id 1 and the recruiter with id 2'
        recruiterFacade.show(smith.id) >> smith

        when: 'I go to /recruiter'
        ResultActions getRecruiter = mockMvc.perform(get("/recruiter/$smith.id"))

        then: 'I see details of that recruiter'
        getRecruiter.andExpect(status().isOk())
                .andExpect(content().json("""
                                    {"id":$smith.id, "name":"$smith.name", "surname":"$smith.surname"},
                            """, false))
    }
}
