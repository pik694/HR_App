package pik.pw.recruitme.app.model.applicants.domain;

import org.springframework.data.repository.Repository;
import pik.pw.recruitme.app.infrastructure.mvc.ObjectNotFoundException;

import java.util.List;

public interface ApplicantRepository extends Repository<Applicant, Integer> {

    Applicant save(Applicant applicant);

    Applicant findById(Integer id);

    void deleteById(Integer id);

    List<Applicant> findAll();

    default Applicant findByIdOrThrow(Integer id) {

        Applicant applicant = findById(id);

        if(applicant == null) {
            throw new ObjectNotFoundException("Applicant with id " + id );
        }

        return applicant;
    }
}
