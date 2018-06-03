package pik.pw.recruitme.app.model.process.domain;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import pik.pw.recruitme.app.model.applicants.domain.Applicant;
import pik.pw.recruitme.app.model.process.dto.CommentDTO;
import pik.pw.recruitme.app.model.process.dto.JobPostingDTO;
import pik.pw.recruitme.app.model.process.dto.ProcessDTO;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
class Process {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;

    @NotNull
    @ManyToOne
    @JoinColumn(name="job_posting_id", nullable = false)
    private JobPosting job;

    @NotNull
    @ManyToOne
    @JoinColumn(name="applicant_id", nullable = false)
    private Applicant applicant;

    @NotNull
    private Integer status;

    @OneToMany(mappedBy="process")
    private List<Comment> comments;

    private List<CommentDTO> convertComments()
    {
        List<CommentDTO> dtos = new ArrayList<>();

        if (comments != null)
        comments.forEach(comment -> dtos.add( comment.toDTO()));

        return dtos;
    }

    ProcessDTO toDTO() {

        return ProcessDTO.builder()
                            .id(id)
                            .job(job.toDTO())
                            .applicant(applicant.toDTO())
                            .comments(convertComments())
                            .build();
    }
}
