package pik.pw.recruitme.app.model.process.domain

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.ResultActions
import pik.pw.recruitme.app.infrastructure.mvc.ObjectNotFoundException
import pik.pw.recruitme.app.model.process.JobPostingController
import spock.lang.Specification
import spock.mock.DetachedMockFactory

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest([JobPostingController, JobPostingTestConfig])
class JobPostingControllerSliceSpec extends Specification implements SampleJobPostings {

    @TestConfiguration
    static class JobPostingTestConfig {

        DetachedMockFactory detachedMockFactory = new DetachedMockFactory()

        @Bean
        JobPostingFacade jobPostingFacadeFacade() {

            return detachedMockFactory.Stub(JobPostingFacade)
        }
    }

    @Autowired
    JobPostingFacade jobPostingFacade

    @Autowired
    MockMvc mockMvc

//    def "asking for non existing job posting should return 404"() {
//
//        given: "there is no job posting with id I want"
//        int nonExistingId = 1
//        jobPostingFacade.show(nonExistingId) >> { throw new ObjectNotFoundException("Job posting with id 1") }
//
//        expect: "I get 404 and a message"
//        mockMvc.perform(get("/jobs/$nonExistingId"))
//                .andExpect(status().isNotFound())
//                .andExpect(content().json("""
//                    {
//                        "message": "Could not find an object in database: Job posting with id 1"
//                    } """))
//
//    }
//
//    def "should get job postings"() {
//        given: 'inventory has two job postings'
//        jobPostingFacade.findAll() >> [programmer, tester]
//
//        when: 'I go to /jobs'
//        ResultActions getJobPostings = mockMvc.perform(get("/jobs"))
//
//        then: 'I see list of those job postings'
//        getJobPostings.andExpect(status().isOk())
//                .andExpect(content().json("""
//                               [
//                                    {"id":$programmer.id, "title":"$programmer.title", "description":"$programmer.description"},
//                                    {"id":$tester.id, "title":"$tester.title", "description":"$tester.description"}
//                               ]""", false))
//    }
//
//    def "should get job posting"() {
//
//        given: 'inventory has the job posting with id 1 and the job posting with id 2'
//        jobPostingFacade.show(programmer.id) >> programmer
//
//        when: 'I go to /jobs'
//        ResultActions getJobPosting = mockMvc.perform(get("/jobs/$programmer.id"))
//
//        then: 'I see details of that job posting'
//        getJobPosting.andExpect(status().isOk())
//                .andExpect(content().json("""
//                                                {"id":$programmer.id, "title":"$programmer.title", "description":"$programmer.description"},
//                                                """, false))
//    }
//
//    def "Should add job posting"() {
//
//        given: "Clear database"
//        jobPostingFacade.add(programmer) >> programmer
//        jobPostingFacade.show(programmer.id) >> programmer
//
//        when: "I go add /jobs/{id} and add job posting"
//
//        ResultActions addJobPositng = mockMvc.perform(
//                post("/jobs")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(asJsonString(programmer)))
//                .andExpect(status().isOk())
//
//        then: "I have job posting"
//        jobPostingFacade.show(programmer.id) == programmer
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
