package pik.pw.recruitme.app.model.applicants

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import pik.pw.recruitme.app.infrastructure.mvc.ObjectNotFoundException
import pik.pw.recruitme.app.model.applicants.domain.SampleApplicants
import pik.pw.recruitme.app.model.applicants.domain.ApplicantFacade
import spock.lang.Specification
import spock.mock.DetachedMockFactory

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest([ApplicantController, ApplicantTestConfig])
class ApplicantControllerSliceSpec extends Specification implements SampleApplicants {

    @TestConfiguration
    static class ApplicantTestConfig {

        DetachedMockFactory detachedMockFactory = new DetachedMockFactory()

        @Bean
        ApplicantFacade applicantFacade() {

            return detachedMockFactory.Stub(ApplicantFacade)
        }
    }

    @Autowired
    ApplicantFacade applicantFacade

    @Autowired
    MockMvc mockMvc

//    def "asking for non existing applicant should return 404"() {
//
//        given: "there is no users with id I want"
//        int nonExistingId = 1
//        applicantFacade.show(nonExistingId) >> { throw new ObjectNotFoundException("Applicant with id 1") }
//
//        expect: "I get 404 and a message"
//        mockMvc.perform(get("/applicants/$nonExistingId"))
//                .andExpect(status().isNotFound())
//                .andExpect(content().json("""
//                    {
//                        "message": "Could not find an object in database: Applicant with id 1"
//                    } """))
//
//    }
//
//    def "should get applicants"() {
//        given: 'inventory has two applicants'
//        applicantFacade.findAll() >> [smith, jones]
//
//        when: 'I go to /applicants'
//        ResultActions getApplicants = mockMvc.perform(get("/applicants"))
//
//        then: 'I see list of those applicants'
//        getApplicants.andExpect(status().isOk())
//                        .andExpect(content().json("""
//                               [
//                                    {"id":$smith.id, "firstName":"$smith.firstName", "lastName":"$smith.lastName"},
//                                    {"id":$jones.id, "firstName":"$jones.firstName", "lastName":"$jones.lastName"}
//                               ]""", false))
//    }
//
//    def "should get applicant"() {
//
//        given: 'inventory has the applicant with id 1 and the applicant with id 2'
//        applicantFacade.show(smith.id) >> smith
//
//        when: 'I go to /users'
//        ResultActions getApplicant = mockMvc.perform(get("/applicants/$smith.id"))
//
//        then: 'I see details of that applicant'
//        getApplicant.andExpect(status().isOk())
//                    .andExpect(content().json("""
//                                                {"id":$smith.id, "firstName":"$smith.firstName", "lastName":"$smith.lastName"},
//                                                """, false))
//    }
//
//    def "Should add applicant"() {
//
//        given: "Clear database"
//        applicantFacade.add(smith) >> smith
//        applicantFacade.show(smith.id) >> smith
//
//        when: "I go add /applicants/{id} and add applicant"
//
//        ResultActions addApplicant = mockMvc.perform(
//                post("/applicants")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(smith)))
//                .andExpect(status().isOk())
//
//        then: "I have applicant"
//        applicantFacade.show(smith.id) == smith
//
//
//    }
//
//    static String asJsonString(final Object obj) {
//
//        try {
//
//            return new ObjectMapper().writeValueAsString(obj)
//        }
//        catch (Exception e) {
//
//            throw new RuntimeException(e)
//        }
//    }
}