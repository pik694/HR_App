package pik.pw.recruitme.app.model.users

import base.IntegrationSpec
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.ResultActions
import pik.pw.recruitme.app.model.users.domain.SampleUsers
import pik.pw.recruitme.app.model.users.domain.UserFacade

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class UserControllerAcceptanceSpec extends IntegrationSpec implements SampleUsers {

    @Autowired
    UserFacade userFacade

//    @WithMockUser
//    def "Should get users"() {
//        given: "Repository has two users"
//        userFacade.add(smith)
//        userFacade.add(jones)
//
//        when: "I go to /users"
//        ResultActions getusers = mockMvc.perform(get("/users"))
//
//        then: "I see all users"
//        getusers
//                .andExpect(status().isOk())
//                .andExpect(content().json("""
//                    [
//                        {"id":$smith.id,"firstName":"$smith.firstName","lastName":"$smith.lastName","username":"$smith.username","email":"$smith.email"},
//                        {"id":$jones.id,"firstName":"$jones.firstName","lastName":"$jones.lastName","username":"$jones.username","email":"$jones.email"}
//                    ]"""))
//
//        when: "I go to /users/"
//        ResultActions getRecruiter = mockMvc.perform(get("/users/$jones.id"))
//
//        then: "I see details of a users"
//        getRecruiter
//                .andExpect(status().isOk())
//                .andExpect(content().json("""
//                   {"id":$jones.id,"firstName":"$jones.firstName","lastName":"$jones.lastName","username":"$jones.username","email":"$jones.email"}
//                """))
//
//    }


}
