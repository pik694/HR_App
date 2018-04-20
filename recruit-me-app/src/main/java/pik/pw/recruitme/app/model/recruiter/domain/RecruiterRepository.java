package pik.pw.recruitme.app.model.recruiter.domain;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.Repository;

interface RecruiterRepository extends Repository<Recruiter, Integer> {

    Recruiter save(Recruiter recruiter);

    Recruiter findById(Integer id);

    void deleteById(Integer id);

    Page<Recruiter> findAll(Pageable pageable);

    default Recruiter findByIdOrThrow(Integer id) {
        Recruiter recruiter = findById(id);

        if (recruiter == null) {
            throw new RecruiterNotFoundException(id);
        }
        return recruiter;
    }


}
