package pik.pw.recruitme.app.model.recruiter

import base.IntegrationSpec
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.ResultActions
import pik.pw.recruitme.app.model.recruiter.domain.RecruiterFacade
import pik.pw.recruitme.app.model.recruiter.domain.SampleRecruiters

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class RecruiterControllerAcceptanceSpec extends IntegrationSpec implements SampleRecruiters {

    @Autowired
    RecruiterFacade recruiterFacade

    @WithMockUser
    def "Should get recruiters"() {
        given: "Repository has two recruiters"
        recruiterFacade.add(smith)
        recruiterFacade.add(jones)

        when: "I go to /recruiters"
        ResultActions getRecruiters = mockMvc.perform(get("/recruiters"))

        then: "I see all recruiters"
        getRecruiters
                .andExpect(status().isOk())
                .andExpect(content().json("""
                {
                    "content":[
                        {"id":$smith.id,"name":"$smith.name","surname":"$smith.surname"},
                        {"id":$jones.id,"name":"$jones.name","surname":"$jones.surname"}
                    ]
                }"""))

        when: "I go to /recruiter/"
        ResultActions getRecruiter = mockMvc.perform(get("/recruiter/$jones.id"))

        then: "I see details of a recruiter"
        getRecruiter
                .andExpect(status().isOk())
                .andExpect(content().json("""
                   {"id":$jones.id,"name":"$jones.name","surname":"$jones.surname"}
                """))

    }


}
