package pik.pw.recruitme.app.model.applicants.domain

import groovy.transform.CompileStatic
import org.apache.tomcat.jni.Local
import pik.pw.recruitme.app.model.applicants.dto.ApplicantDTO

import java.time.LocalDate

@CompileStatic
trait SampleApplicants {
    ApplicantDTO smith = new ApplicantDTO(1, "John", "Smith","jsmith@gmail.com", LocalDate.of(2010, 01,01), "123456789")
    ApplicantDTO jones = new ApplicantDTO(2, "Wiliam", "Jones", "wjones@gmail.com", LocalDate.of(2012, 01,01),"987654321")
}