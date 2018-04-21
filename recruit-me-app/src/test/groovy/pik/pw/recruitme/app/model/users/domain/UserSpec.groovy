package pik.pw.recruitme.app.model.users.domain

import org.junit.After
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import pik.pw.recruitme.app.infrastructure.mvc.ObjectNotFoundException
import pik.pw.recruitme.app.model.users.dto.UserDTO
import spock.lang.Specification

class UserSpec extends Specification implements SampleUsers {

    UserFacade facade = new UserConfiguration().userFacade()

    @After
    def "Remove user"() {
        facade.delete(smith.id, jones.id)
    }

    def "Should add  a user"() {
        when: "We add a users"
        facade.add(smith)
        then: "System has this users"
        facade.show(smith.id) == smith
    }

    def "Should add users"() {
        when: "We add users"
        facade.add(smith)
        facade.add(jones)
        then: "We have users"
        facade.show(smith.id) == smith
        facade.show(jones.id) == jones
    }

    def "Should list users"() {
        given: "We have two users"
        facade.add(smith)
        facade.add(jones)
        when: "We request users' list"
        Page<UserDTO> foundRecruiters = facade.findAll(new PageRequest(0, 10))
        then: "System returns both users"
        foundRecruiters.contains(smith)
        foundRecruiters.contains(jones)
    }


    def "Should throw not found exception"() {
        given: "Empty repository"
        when: "We try to find a nonexistent users "
        facade.show(smith.id)
        then: "An exception will be thrown"
        thrown ObjectNotFoundException
    }

    def "Should remove user"(){
        given: "We have one recruiter"
        facade.add(jones)
        when: "We remove the recruiter"
        facade.delete(jones.id)
        facade.show(jones.id)
        then: "There is no recruiters"
        thrown ObjectNotFoundException

    }

    def "Should update user"(){
        given: "We have some user"
        facade.add(smith)

        when: "We update some some data"
        smith.firstName = "James"
        facade.add(smith)
        then: "User is updated"
        facade.show(smith.id) == smith
    }



}
