package pik.pw.recruitme.app.model.process.domain

import org.junit.After
import pik.pw.recruitme.app.infrastructure.mvc.ObjectNotFoundException
import pik.pw.recruitme.app.model.process.dto.JobPostingDTO
import spock.lang.Specification

class JobPostingSpec extends Specification implements SampleJobPostings {

    JobPostingFacade facade = new JobPostingConfiguration().jobPostingFacade()

    @After
    def "Remove job postings"() {

        facade.delete(programmer.id, tester.id)
    }

    def "Should add a job posting"() {

        when: "We add a job posting"
        facade.add(programmer)

        then: "System has that job posting"
        facade.show(programmer.id) == programmer
    }

    def "Should add job postings"() {

        when: "We add job postings"
        facade.add(programmer)
        facade.add(tester)

        then: "We have job postings"
        facade.show(programmer.id) == programmer
        facade.show(tester.id) == tester
    }

    def "Should list job postings"() {

        given: "We have two job postings"
        facade.add(programmer)
        facade.add(tester)

        when: "We request job postings' list"
        List<JobPostingDTO> foundJobPostings = facade.findAll()

        then: "System returns both job postings"
        foundJobPostings.contains(programmer)
        foundJobPostings.contains(tester)
    }


    def "Should throw not found exception"() {

        given: "Empty repository"

        when: "We try to find a nonexistent job posting"
        facade.show(programmer.id)

        then: "An exception will be thrown"
        thrown ObjectNotFoundException
    }

    def "Should remove job posting"() {

        given: "We have one job posting"
        facade.add(programmer)

        when: "We remove the job positng"
        facade.delete(programmer.id)
        facade.show(programmer.id)

        then: "There is no job postings"
        thrown ObjectNotFoundException

    }

    def "Should update job posting"() {

        given: "We have one job posting"
        facade.add(programmer)

        when: "We update some data"
        programmer.description = "full-stack"
        facade.add(programmer)

        then: "Job posting is updated"
        facade.show(programmer.id) == programmer
    }
}
