package pik.pw.recruitme.app.model.recruiter

import pik.pw.recruitme.app.model.recruiter.domain.RecruiterFacade
import pik.pw.recruitme.app.model.recruiter.domain.SampleRecruiters
import pik.pw.recruitme.app.base.IntegrationSpec

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.ResultActions

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class RecruiterControllerAcceptanceSpec extends IntegrationSpec implements SampleRecruiters {

    @Autowired
    RecruiterFacade recruiterFacade

    @WithMockUser
    def "should get recruiters"() {
        given: 'inventory has recruiter with id = 1'
            recruiterFacade.add(jkowalski)
            recruiterFacade.add(akwiatkowska)

        when: 'I go to /recruiters'
            ResultActions getRecruiters = mockMvc.perform(get("/recruiters"))

        then: 'I see all recruiters'
            getRecruiters.andExpect(status().isOk())
                    .andExpect(content().json("""
                {
                    "content": [
                        {"id":"$jkowalski.id","name":"$jkowalski.name", "surname":"$jkowalski.surname"},
                        {"id":"$akwiatkowska.id","name":"$akwiatkowska.name", "surname":"$akwiatkowska.surname"}
                    ]
                }"""))

        when: 'I go to /recruiter/'
        ResultActions getRecruiter = mockMvc.perform(get("/recruiter/$jkowalski.id"))

        then: 'I see details of the recruiter'
        getRecruiter.andExpect(status().isOk())
                .andExpect(content().json("""
                        {"id":"$jkowalski.id","name":"$jkowalski.name", "surname":"$jkowalski.surname"},
                """))
    }
}
