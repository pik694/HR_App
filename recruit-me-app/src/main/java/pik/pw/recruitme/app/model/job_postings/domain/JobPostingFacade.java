package pik.pw.recruitme.app.model.job_postings.domain;


import org.springframework.transaction.annotation.Transactional;
import pik.pw.recruitme.app.model.job_postings.dto.JobPostingDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Objects.requireNonNull;

@Transactional
public class JobPostingFacade {

    private JobPostingRepository repository;
    private JobPostingFactory jobPostingFactory;

    public JobPostingFacade(JobPostingRepository repository, JobPostingFactory jobPostingFactory) {

        this.repository = repository;
        this.jobPostingFactory = jobPostingFactory;
    }

    public JobPostingDTO add(JobPostingDTO dto) {

        requireNonNull(dto);
        JobPosting jobPosting = jobPostingFactory.from(dto);
        jobPosting = repository.save(jobPosting);

        return jobPosting.toDTO();
    }

    public JobPostingDTO show(Integer id) {

        JobPosting jobPosting  = repository.findByIdOrThrow(id);
        return jobPosting.toDTO();
    }

    public void delete(Integer... ids) {

        requireNonNull(ids);

        Arrays.stream(ids).forEach(repository::deleteById);
    }

    public List<JobPostingDTO> findAll() {

        List<JobPostingDTO> dtos = new ArrayList<>();

        for(JobPosting jobPosting: repository.findAll()) {
            dtos.add(jobPosting.toDTO());
        }

        return dtos;
    }
}
