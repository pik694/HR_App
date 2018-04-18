package pik.pw.recruitme.app.model.recruiter.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Builder
@Getter
@EqualsAndHashCode
public class RecruiterDTO {
    private int id;
    private String name;
    private String surname;
}
