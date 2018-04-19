package pik.pw.recruitme.app.model.recruiter.domain

import groovy.transform.CompileStatic
import pik.pw.recruitme.app.model.recruiter.dto.RecruiterDTO

@CompileStatic
trait SampleRecruiters {
    RecruiterDTO smith = createRecruiterDTO(1, "John", "Smith")
    RecruiterDTO jones = createRecruiterDTO(2, "William", "Jones")

    static private RecruiterDTO createRecruiterDTO(int id, String name, String surname) {
        return RecruiterDTO.builder()
                .id(id)
                .name(name)
                .surname(surname)
                .build()
    }
}