package pik.pw.recruitme.app.model.applicants.domain

import groovy.transform.CompileStatic
import pik.pw.recruitme.app.model.applicants.dto.ApplicantDTO

@CompileStatic
trait SampleApplicants {
    ApplicantDTO smith = new ApplicantDTO(1, "John", "Smith", "jsmith@gmail.com", "123456789")
    ApplicantDTO jones = new ApplicantDTO(2, "Wiliam", "Jones", "wjones@gmail.com", "987654321")
}