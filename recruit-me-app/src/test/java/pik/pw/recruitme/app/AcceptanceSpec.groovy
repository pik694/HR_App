package pik.pw.recruitme.app

import pik.pw.recruitme.app.base.IntegrationSpec
import pik.pw.recruitme.app.model.recruiter.domain.RecruiterFacade
import pik.pw.recruitme.app.model.recruiter.domain.SampleRecruiters

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.ResultActions

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class AcceptanceSpec extends IntegrationSpec implements SampleRecruiters {
    @Autowired
    RecruiterFacade recruiterFacade

    @WithMockUser
    def "positive renting scenario"() {
        given: 'inventory has a recruiter with id=1 and a recruiter with id=2'
        recruiterFacade.add(jkowalski)
        recruiterFacade.add(akwiatkowska)

        when: 'I go to /recruiters'
        ResultActions getRecruiters = mockMvc.perform(get("/recruiters"))
        then: 'I see both recruiters'
        getRecruiters.andExpect(status().isOk())
                .andExpect(content().json("""
                {
                    "content": [
                         {"id":"$jkowalski.id","name":"$jkowalski.name", "surname":"$jkowalski.surname"},
                        {"id":"$akwiatkowska.id","name":"$akwiatkowska.name", "surname":"$akwiatkowska.surname"}
                    ]
                }"""))

    }
}
