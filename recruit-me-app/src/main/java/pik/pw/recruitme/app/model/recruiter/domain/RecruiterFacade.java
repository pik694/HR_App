package pik.pw.recruitme.app.model.recruiter.domain;


import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import pik.pw.recruitme.app.model.recruiter.dto.RecruiterDTO;

import java.util.Arrays;

import static java.util.Objects.requireNonNull;

@Transactional
@Getter
public class RecruiterFacade {

    private RecruiterRepository repository;
    private RecruiterCreator recruiterCreator;

    public RecruiterFacade(RecruiterRepository repository, RecruiterCreator recruiterCreator) {
        this.repository = repository;
        this.recruiterCreator = recruiterCreator;
    }

    public RecruiterDTO add(RecruiterDTO dto) {

        requireNonNull(dto);
        Recruiter recruiter = recruiterCreator.from(dto);
        recruiter = repository.save(recruiter);
        return recruiter.toDTO();

    }

    public RecruiterDTO show(int id) {

        Recruiter recruiter = repository.findByIdOrThrow(id);
        return recruiter.toDTO();

    }


    public void delete(Integer... ids) {

        requireNonNull(ids);

        Arrays.stream(ids).forEach(
                repository::deleteById
        );

    }

    public Page<RecruiterDTO> findAll(Pageable pageable) {
        requireNonNull(pageable);
        return repository
                .findAll(pageable)
                .map(Recruiter::toDTO);
    }

}
