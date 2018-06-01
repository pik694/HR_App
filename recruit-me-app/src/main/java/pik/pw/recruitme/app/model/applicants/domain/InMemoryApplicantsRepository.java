package pik.pw.recruitme.app.model.applicants.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.Objects.requireNonNull;

public class InMemoryApplicantsRepository implements ApplicantRepository {

   private ConcurrentHashMap<Integer, Applicant>map = new ConcurrentHashMap<>();

    public Applicant save(Applicant applicant) {

        requireNonNull(applicant);

        map.put(applicant.toDTO().getId(), applicant);

        return applicant;
    }

    public Applicant findById(Integer id) {

        return map.get(id);
    }

    public void deleteById(Integer id) {

        map.remove(id);
    }

    public List<Applicant> findAll() {

        return new ArrayList<>(map.values());
    }

}
