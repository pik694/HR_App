package pik.pw.recruitme.app.model.recruiter.domain

import groovy.transform.CompileStatic
import pik.pw.recruitme.app.model.recruiter.dto.RecruiterDTO

@CompileStatic
trait SampleRecruiters {
    RecruiterDTO jkowalski = createRecruiterDTO(1, "Jan", "Kowalski");
    RecruiterDTO akwiatkowska = createRecruiterDTO(2, "Anna", "Kowalska");

    static private RecruiterDTO createRecruiterDTO(int id, String name, String surname) {
        return RecruiterDTO.builder()
                                .id(id)
                                .name(name)
                                .surname(surname)
                                .build()
    }
}