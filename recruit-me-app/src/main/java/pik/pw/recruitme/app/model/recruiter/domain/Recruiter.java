package pik.pw.recruitme.app.model.recruiter.domain;

import lombok.Builder;
import pik.pw.recruitme.app.model.recruiter.dto.RecruiterDTO;

@Builder
class Recruiter {
    private int id;
    private String name;
    private String surname;

    RecruiterDTO toDTO(){
        return RecruiterDTO.builder()
                .id(id)
                .name(name)
                .surname(surname)
                .build();
    }

}
