package pik.pw.recruitme.app.model.job_postings.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import pik.pw.recruitme.app.model.job_postings.dto.JobPostingDTO;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.ZoneId;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
class JobPosting {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotEmpty
    @NotEmpty
    private String title;

    @NotEmpty
    @NotNull
    private String description;

    @NotEmpty
    @NotNull
    private String salaryInfo;

    JobPostingDTO toDTO() {

        return JobPostingDTO.builder()
                .id(id)
                .title(title)
                .description(description)
                .salaryInfo(salaryInfo)
                .build();
    }
}
