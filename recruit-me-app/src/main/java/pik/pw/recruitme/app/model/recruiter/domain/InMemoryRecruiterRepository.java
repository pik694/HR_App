package pik.pw.recruitme.app.model.recruiter.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

class InMemoryRecruiterRepository {

    private ConcurrentHashMap<Integer, Recruiter> map = new ConcurrentHashMap<>();

    Recruiter save(Recruiter recruiter) {

        requireNonNull(recruiter);

        map.put(recruiter.toDTO().getId(), recruiter);

        return recruiter;

    }

    Recruiter findByIdOrThrow(Integer id) {

        Recruiter recruiter = map.get(id);

        if (recruiter == null) {
            throw new RecruiterNotFoundException(id);
        }
        return recruiter;
    }

    void deleteById(Integer id) {
        map.remove(id);
    }


    Page<Recruiter> findAll(Pageable pageable) {

        return new PageImpl<>(new ArrayList<>(map.values()), pageable, map.size());
    }


    class RecruiterNotFoundException extends RuntimeException {
        RecruiterNotFoundException(Integer id) {
            super("Could not find a recruiter with id: " + id.toString());
        }
    }

}
