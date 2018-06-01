package pik.pw.recruitme.app.model.applicants.domain;

import org.springframework.transaction.annotation.Transactional;
import pik.pw.recruitme.app.model.applicants.dto.ApplicantDTO;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Objects.requireNonNull;

@Transactional
public class ApplicantFacade {

    private ApplicantRepository repository;
    private ApplicantFactory applicantFactory;

    public ApplicantFacade(ApplicantRepository repository, ApplicantFactory applicantFactory) {

        this.repository = repository;
        this.applicantFactory = applicantFactory;
    }

    public ApplicantDTO add(ApplicantDTO dto) {

        requireNonNull(dto);
        Applicant applicant = applicantFactory.from(dto);
        applicant = repository.save(applicant);

        return applicant.toDTO();
    }

    public ApplicantDTO show(Integer id) {

        Applicant applicant = repository.findByIdOrThrow(id);
        return applicant.toDTO();
    }

    public void delete(Integer... ids) {

        requireNonNull(ids);

        Arrays.stream(ids).forEach(repository::deleteById);
    }

    public List<ApplicantDTO> findAll() {

        List<ApplicantDTO> dtos = new ArrayList<>();

        for(Applicant applicant: repository.findAll()) {
            dtos.add(applicant.toDTO());
        }

        return dtos;
    }
}
