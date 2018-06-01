package pik.pw.recruitme.app.model.applicants


import base.IntegrationSpec
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.ResultActions
import pik.pw.recruitme.app.model.applicants.domain.ApplicantFacade
import pik.pw.recruitme.app.model.applicants.domain.SampleApplicants

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class ApplicantControllerAcceptanceSpec extends IntegrationSpec implements SampleApplicants {

    @Autowired
    ApplicantFacade applicantFacade

//    @WithMockUser
//    def "Should get applicants"() {
//        given: "Repository has two applicants"
//        applicantFacade.add(smith)
//        applicantFacade.add(jones)
//
//        when: "I go to /applicants"
//        ResultActions getApplicants = mockMvc.perform(get("/applicants"))
//
//        then: "I see all applicants"
//        getApplicants
//                .andExpect(status().isOk())
//                .andExpect(content().json("""
//                    [
//                        {"id":$smith.id,"firstName":"$smith.firstName","lastName":"$smith.lastName","email":"$smith.email","phoneNumber":"$smith.phoneNumber"},
//                        {"id":$jones.id,"firstName":"$jones.firstName","lastName":"$jones.lastName","email":"$jones.email","phoneNumber":"$jones.phoneNumber"}
//                    ]"""))
//
//        when: "I go to /applicants/"
//        ResultActions getApplicant = mockMvc.perform(get("/applicants/$jones.id"))
//
//        then: "I see details of an applicant"
//        getApplicant
//                .andExpect(status().isOk())
//                .andExpect(content().json("""
//                   {"id":$jones.id,"firstName":"$jones.firstName","lastName":"$jones.lastName","email":"$jones.email","phoneNumber":"$jones.phoneNumber"}
//                """))
//
//    }
}