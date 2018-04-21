package pik.pw.recruitme.app.model.users.domain

import groovy.transform.CompileStatic
import pik.pw.recruitme.app.model.users.dto.UserDTO

@CompileStatic
trait SampleRecruiters {
    UserDTO smith = new UserDTO(1, "jsmith", "password", "John", "Smith", "some@mail.com")
    UserDTO jones = new UserDTO(2, "wjones", "password", "William", "Jones", "another@mail.com")

}