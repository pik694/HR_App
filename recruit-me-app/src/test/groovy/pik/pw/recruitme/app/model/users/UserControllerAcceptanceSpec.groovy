package pik.pw.recruitme.app.model.users

import base.IntegrationSpec
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.ResultActions
import pik.pw.recruitme.app.model.users.domain.UserFacade
import pik.pw.recruitme.app.model.users.domain.SampleRecruiters

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class UserControllerAcceptanceSpec extends IntegrationSpec implements SampleRecruiters {

    @Autowired
    UserFacade userFacade

    @WithMockUser
    def "Should get recruiters"() {
        given: "Repository has two recruiters"
        userFacade.add(smith)
        userFacade.add(jones)

        when: "I go to /recruiters"
        ResultActions getRecruiters = mockMvc.perform(get("/recruiters"))

        then: "I see all recruiters"
        getRecruiters
                .andExpect(status().isOk())
                .andExpect(content().json("""
                {
                    "content":[
                        {"id":$smith.id,"firstName":"$smith.firstName","lastName":"$smith.lastName","username":"$smith.username","email":"$smith.email"},
                        {"id":$jones.id,"firstName":"$jones.firstName","lastName":"$jones.lastName","username":"$jones.username","email":"$jones.email"}
                    ]
                }"""))

        when: "I go to /users/"
        ResultActions getRecruiter = mockMvc.perform(get("/users/$jones.id"))

        then: "I see details of a users"
        getRecruiter
                .andExpect(status().isOk())
                .andExpect(content().json("""
                   {"id":$jones.id,"firstName":"$jones.firstName","lastName":"$jones.lastName","username":"$jones.username","email":"$jones.email"}
                """))

    }


}
