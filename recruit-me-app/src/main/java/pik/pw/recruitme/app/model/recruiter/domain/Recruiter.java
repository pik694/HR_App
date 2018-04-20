package pik.pw.recruitme.app.model.recruiter.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import pik.pw.recruitme.app.model.recruiter.dto.RecruiterDTO;

import javax.persistence.Entity;
import javax.persistence.Id;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
class Recruiter {

    @Id
    private int id;

    private String name;

    private String surname;

    RecruiterDTO toDTO() {
        return RecruiterDTO.builder()
                .id(id)
                .name(name)
                .surname(surname)
                .build();
    }

}
