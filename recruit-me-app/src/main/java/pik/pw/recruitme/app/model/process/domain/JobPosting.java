package pik.pw.recruitme.app.model.process.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import pik.pw.recruitme.app.model.process.dto.JobPostingDTO;


import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
