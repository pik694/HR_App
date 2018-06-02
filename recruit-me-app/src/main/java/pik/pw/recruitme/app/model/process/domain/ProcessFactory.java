package pik.pw.recruitme.app.model.process.domain;

import pik.pw.recruitme.app.model.applicants.domain.ApplicantFactory;
import pik.pw.recruitme.app.model.process.dto.CommentDTO;
import pik.pw.recruitme.app.model.process.dto.ProcessDTO;

import java.util.ArrayList;
import java.util.List;

public class ProcessFactory {

    private List<Comment> convertComments(List<CommentDTO> dtos) {

        CommentFactory factory = new CommentFactory();
        List<Comment> comments = new ArrayList<>();

        dtos.forEach( commentDTO -> comments.add(factory.from(commentDTO)));

        return comments;
    }

    Process from(ProcessDTO dto) {
        JobPostingFactory jobPostingFactory = new JobPostingFactory();
        ApplicantFactory applicantFactory = new ApplicantFactory();

        return Process.builder()
                .id(dto.getId())
                .job(jobPostingFactory.from(dto.getJob()))
                .applicant(applicantFactory.from(dto.getApplicant()))
                .status(dto.getStatus())
                .comments(convertComments(dto.getComments()))
                .build();
    }
}
