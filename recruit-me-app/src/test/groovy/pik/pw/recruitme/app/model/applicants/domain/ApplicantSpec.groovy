package pik.pw.recruitme.app.model.applicants.domain

import org.junit.After
import pik.pw.recruitme.app.infrastructure.mvc.ObjectNotFoundException
import pik.pw.recruitme.app.model.applicants.dto.ApplicantDTO
import spock.lang.Specification

class ApplicantSpec extends Specification implements SampleApplicants {

    ApplicantFacade facade = new ApplicantConfiguration().applicantFacade()

    @After
    def "Remove applicants"() {

        facade.delete(smith.id, jones.id)
    }

    def "Should add an applicant"() {

        when: "We add an applicant"
        facade.add(smith)

        then: "System has that applicant"
        facade.show(smith.id) == smith
    }

    def "Should add applicants"() {

        when: "We add users"
        facade.add(smith)
        facade.add(jones)

        then: "We have applicants"
        facade.show(smith.id) == smith
        facade.show(jones.id) == jones
    }

    def "Should list applicants"() {

        given: "We have two applicants"
        facade.add(smith)
        facade.add(jones)

        when: "We request applicants' list"
        List<ApplicantDTO> foundApplicants = facade.findAll()

        then: "System returns both users"
        foundApplicants.contains(smith)
        foundApplicants.contains(jones)
    }


    def "Should throw not found exception"() {

        given: "Empty repository"

        when: "We try to find a nonexistent applicant"
        facade.show(smith.id)

        then: "An exception will be thrown"
        thrown ObjectNotFoundException
    }

    def "Should remove applicant"() {

        given: "We have one applicant"
        facade.add(smith)

        when: "We remove the applicant"
        facade.delete(smith.id)
        facade.show(smith.id)

        then: "There is no applicants"
        thrown ObjectNotFoundException

    }

    def "Should update applicant"() {

        given: "We have one user"
        facade.add(smith)

        when: "We update some data"
        smith.firstName = "James"
        facade.add(smith)

        then: "Applicant is updated"
        facade.show(smith.id) == smith
    }
}