package pik.pw.recruitme.app.model.job_postings

import base.IntegrationSpec
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.test.context.support.WithMockUser
import org.springframework.test.web.servlet.ResultActions
import pik.pw.recruitme.app.model.job_postings.domain.JobPostingFacade
import pik.pw.recruitme.app.model.job_postings.domain.SampleJobPostings

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

class JobPostingControllerAcceptanceSpec extends IntegrationSpec implements SampleJobPostings {

    @Autowired
    JobPostingFacade jobPostingFacade

    @WithMockUser
    def "Should get job postings"() {
        given: "Repository has two job postings"
        jobPostingFacade.add(programmer)
        jobPostingFacade.add(tester)

        when: "I go to /jobs"
        ResultActions getJobPostings = mockMvc.perform(get("/jobs"))

        then: "I see all job postings"
        getJobPostings
                .andExpect(status().isOk())
                .andExpect(content().json("""
                    [
                        {"id":$programmer.id,"title":"$programmer.title","description":"$programmer.description","salaryInfo":"$programmer.salaryInfo"},
                        {"id":$tester.id,"title":"$tester.title","description":"$tester.description","salaryInfo":"$tester.salaryInfo"}
                    ]"""))

        when: "I go to /jobs/"
        ResultActions getJobPosting = mockMvc.perform(get("/jobs/$programmer.id"))

        then: "I see details of a job posting"
        getJobPosting
                .andExpect(status().isOk())
                .andExpect(content().json("""
                   {"id":$programmer.id,"title":"$programmer.title","description":"$programmer.description","salaryInfo":"$programmer.salaryInfo"}
                """))

    }
}
