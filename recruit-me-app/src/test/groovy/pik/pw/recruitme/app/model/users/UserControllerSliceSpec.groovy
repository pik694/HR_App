package pik.pw.recruitme.app.model.users

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import pik.pw.recruitme.app.infrastructure.mvc.ObjectNotFoundException
import pik.pw.recruitme.app.model.users.domain.SampleUsers
import pik.pw.recruitme.app.model.users.domain.UserFacade
import spock.lang.Specification
import spock.mock.DetachedMockFactory

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest([UserController, UserTestConfig])
class UserControllerSliceSpec extends Specification implements SampleUsers {

    @TestConfiguration
    static class UserTestConfig {
        DetachedMockFactory detachedMockFactory = new DetachedMockFactory()

        @Bean
        UserFacade recruiterFacade() {
            return detachedMockFactory.Stub(UserFacade)
        }
    }

    @Autowired
    UserFacade userFacade

    @Autowired
    MockMvc mockMvc

    def "asking for non existing recruiter should return 404"() {
        given: "there is no users with id I want"
        int nonExistingId = 1
        userFacade.show(nonExistingId) >> { throw new ObjectNotFoundException("User with id 1") }

        expect: "I get 404 and a message"
        mockMvc.perform(get("/users/$nonExistingId"))
                .andExpect(status().isNotFound())
                .andExpect(content().json("""
                    {
                        "message": "Could not find an object in database: User with id 1"
                    } """))

    }

    def "should get recruiters"() {
        given: 'inventory has two recruiters'
        userFacade.findAll() >> [smith, jones]

        when: 'I go to /recruiters'
        ResultActions getRecruiters = mockMvc.perform(get("/users"))

        then: 'I see list of those recruiters'
        getRecruiters.andExpect(status().isOk())
                .andExpect(content().json("""
                               [
                                    {"id":$smith.id, "firstName":"$smith.firstName", "lastName":"$smith.lastName"},
                                    {"id":$jones.id, "firstName":"$jones.firstName", "lastName":"$jones.lastName"}
                               ]""", false))
    }

    def "should get recruiter"() {
        given: 'inventory has the users with id 1 and the users with id 2'
        userFacade.show(smith.id) >> smith

        when: 'I go to /users'
        ResultActions getRecruiter = mockMvc.perform(get("/users/$smith.id"))

        then: 'I see details of that users'
        getRecruiter.andExpect(status().isOk())
                .andExpect(content().json("""
                                    {"id":$smith.id, "firstName":"$smith.firstName", "lastName":"$smith.lastName"},
                            """, false))
    }

    def "Should add recruiter"() {

        given: "Clear database"

        userFacade.add(smith) >> smith
        userFacade.show(smith.id) >> smith

        when: "I go add /users/{id}  and add user"

        ResultActions addUser = mockMvc.perform(
                post("/users")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(smith)))
                .andExpect(status().isOk())

        then: "I have user"

        userFacade.show(smith.id) == smith


    }


    static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


}
