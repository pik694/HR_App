package pik.pw.recruitme.app.model.process.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

public class InMemoryJobPostingsRepository implements JobPostingRepository {

    private ConcurrentHashMap<Integer, JobPosting> map = new ConcurrentHashMap<>();

    @Override
    public JobPosting save(JobPosting jobPosting) {

        requireNonNull(jobPosting);

        map.put(jobPosting.toDTO().getId(), jobPosting);

        return jobPosting;
    }

    @Override
    public JobPosting findById(Integer id) {

        return map.get(id);
    }

    @Override
    public void deleteById(Integer id) {

        map.remove(id);
    }

    @Override
    public List<JobPosting> findAll() {

        return new ArrayList<>(map.values());
    }
}
