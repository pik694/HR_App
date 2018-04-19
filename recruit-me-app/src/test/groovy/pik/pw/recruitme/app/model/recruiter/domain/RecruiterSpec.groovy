package pik.pw.recruitme.app.model.recruiter.domain

import org.junit.After
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import pik.pw.recruitme.app.model.recruiter.dto.RecruiterDTO
import spock.lang.Specification

class RecruiterSpec extends Specification implements SampleRecruiters {

    RecruiterFacade facade = new RecruiterConfiguration().recruiterFacade()

    @After
    def "Remove recruiters"() {
        facade.delete(smith.id, jones.id)
    }

    def "Should add recruiter"() {
        when: "We add a recruiter"
        facade.add(smith)
        then: "System has this recruiter"
        facade.show(smith.id) == smith
    }

    def "Should add recruiters"() {
        when: "We add recruiters"
        facade.add(smith)
        facade.add(jones)
        then: "We have recruiters"
        facade.show(smith.id) == smith
        facade.show(jones.id) == jones
    }

    def "Should list recruiters"() {
        given: "We have two recruiters"
        facade.add(smith)
        facade.add(jones)
        when: "We request recruiters' list"
        Page<RecruiterDTO> foundRecruiters = facade.findAll(new PageRequest(0, 10))
        then: "System returns both recruiters"
        foundRecruiters.contains(smith)
        foundRecruiters.contains(jones)
    }

    def "Should throw not found exception"() {
        given: "Empty repository"
        when: "We try to find a nonexistent recruiter "
        facade.show(smith.id)
        then: "An exception will be thrown"
        thrown RecruiterNotFoundException
    }

}
