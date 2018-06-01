package pik.pw.recruitme.app.model.job_postings.domain;

import pik.pw.recruitme.app.model.job_postings.dto.JobPostingDTO;

class JobPostingFactory {

    JobPosting from(JobPostingDTO dto) {

        return JobPosting.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .description(dto.getDescription())
                .salaryInfo(dto.getSalaryInfo())
                .build();
    }
}
