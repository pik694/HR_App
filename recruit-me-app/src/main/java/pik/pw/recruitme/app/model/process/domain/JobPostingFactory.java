package pik.pw.recruitme.app.model.process.domain;

import pik.pw.recruitme.app.model.process.dto.JobPostingDTO;

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
