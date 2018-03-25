package pik.pw.recruitme.app.repository;

import pik.pw.recruitme.app.model.Recruiter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecruiterRepository extends CrudRepository<Recruiter, Long> {

    List<Recruiter> findByLastName(String lastName);
}

