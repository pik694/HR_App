package pik.pw.recruitme.app.model.job_postings.domain;

import org.springframework.data.repository.Repository;
import pik.pw.recruitme.app.infrastructure.mvc.ObjectNotFoundException;

import java.util.List;

interface JobPostingRepository extends Repository<JobPosting, Integer> {

    JobPosting save(JobPosting jobPosting);

    JobPosting findById(Integer id);

    void deleteById(Integer id);

    List<JobPosting> findAll();

    default JobPosting findByIdOrThrow(Integer id) {

        JobPosting jobPosting = findById(id);

        if(jobPosting == null ) {
            throw new ObjectNotFoundException("Job posting with id "+id);
        }

        return jobPosting;
    }
}
