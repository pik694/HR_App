package pik.pw.recruitme.app.model.recruiter.domain;

import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

class InMemoryRecruiterRepository implements RecruiterRepository {

    private ConcurrentHashMap<Integer, Recruiter> map = new ConcurrentHashMap<>();

    public Recruiter save(Recruiter recruiter) {

        requireNonNull(recruiter);

        map.put(recruiter.toDTO().getId(), recruiter);

        return recruiter;

    }

    public Recruiter findById(Integer id) {

        return map.get(id);

    }

    public void deleteById(Integer id) {
        map.remove(id);
    }


    public Page<Recruiter> findAll(Pageable pageable) {

        return new PageImpl<>(new ArrayList<>(map.values()), pageable, map.size());
    }




}
