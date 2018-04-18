package pik.pw.recruitme.app.model.recruiter.domain

import pik.pw.recruitme.app.model.recruiter.dto.RecruiterDTO
import org.junit.After
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import spock.lang.Specification

class RecruiterSpec extends Specification  implements SampleRecruiters {
    RecruiterFacade facade = new RecruiterConfiguration().recruiterFacade()

    @After
    def "remove recruiters"() {
        facade.delete(jkowalski.id, akwiatkowska.id)
    }

    def "should add recruiter"(){
        when: "we add a recruiter"
            facade.add(jkowalski)

        then: "system has this recruiter"
            facade.show(jkowalski.id) == jkowalski
    }

    def "should list recruiters"(){
        given: "we have two recruiters in system"
            facade.add(jkowalski)
            facade.add(akwiatkowska)

        when: "we ask for all recruiters"
            Page<RecruiterDTO> foundRecruiters = facade.findAll( new PageRequest(0,10))

        then: "system returns the recruiters we have added"
            foundRecruiters.contains(jkowalski)
            foundRecruiters.contains(akwiatkowska)
    }
}
