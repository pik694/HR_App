package pik.pw.recruitme.app.model.process.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import pik.pw.recruitme.app.model.applicants.dto.ApplicantDTO;

import java.util.List;
import java.util.Set;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProcessDTO {

    @JsonProperty("id")
    private int id;

    @Setter
    @JsonProperty("job")
    private JobPostingDTO job;

    @Setter
    @JsonProperty("applicant")
    private ApplicantDTO applicant;

    @JsonProperty("status")
    private int status;

    @JsonProperty("comments")
    private List<CommentDTO> comments;

}
