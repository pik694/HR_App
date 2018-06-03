package pik.pw.recruitme.app.model.applicants.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ApplicantDTO {

    @JsonProperty("id")
    private int id;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("birthDate")
    private LocalDate birthDate;

    @JsonProperty("phoneNumber")
    private String phoneNumber;
}
