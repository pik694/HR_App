package pik.pw.recruitme.app.model.applicants.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import pik.pw.recruitme.app.model.applicants.dto.ApplicantDTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.time.LocalDate;


@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Applicant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    @NotEmpty
    private String surname;

    @Email
    @NotNull
    @NotEmpty
    private String email;

    @Past
    @NotNull
    private LocalDate birthDate;



    @NotNull
    @NotEmpty
    private String phoneNumber;

    public ApplicantDTO toDTO() {

        return ApplicantDTO.builder()
                .id(id)
                .firstName(name)
                .lastName(surname)
                .birthDate(birthDate)
                .email(email)
                .phoneNumber(phoneNumber)
                .build();
    }
}
