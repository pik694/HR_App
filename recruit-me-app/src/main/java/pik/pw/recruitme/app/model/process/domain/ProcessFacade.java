package pik.pw.recruitme.app.model.process.domain;

import org.springframework.transaction.annotation.Transactional;
import pik.pw.recruitme.app.model.applicants.domain.ApplicantFacade;
import pik.pw.recruitme.app.model.process.dto.ProcessDTO;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.Objects.requireNonNull;

@Transactional
public class ProcessFacade {

    private ProcessRepository repository;
    private ProcessFactory processFactory;
    private ApplicantFacade applicantFacade;
    private JobPostingFacade jobPostingFacade;

    public ProcessFacade(ProcessRepository repository, ProcessFactory creator, ApplicantFacade applicantFacade, JobPostingFacade jobPostingFacade) {

        this.processFactory = creator;
        this.repository = repository;
        this.applicantFacade = applicantFacade;
        this.jobPostingFacade = jobPostingFacade;
    }

    public ProcessDTO add(ProcessDTO dto) {

        requireNonNull(dto);


        dto.setApplicant(applicantFacade.show(dto.getApplicant().getId()));
        dto.setJob(jobPostingFacade.show(dto.getJob().getId()));

        Process process = processFactory.from(dto);
        process = repository.save(process);

        return process.toDTO();
    }

    public ProcessDTO show(Integer id) {

        Process process = repository.findByIdOrThrow(id);
        return process.toDTO();
    }

    public void delete(Integer... ids) {

        requireNonNull(ids);

        Arrays.stream(ids).forEach(repository::deleteById);
    }

    public List<ProcessDTO> findAll() {

        List<ProcessDTO> dtos = new ArrayList<>();

        for(Process process: repository.findAll()) {
            dtos.add(process.toDTO());
        }

        return dtos;
    }

    public List<ProcessDTO> findAllProcessesOfJobPosting(int jobPostingId) {

        List<ProcessDTO> dtos = new ArrayList<>();

        for(Process process: repository.findAll()) {

            ProcessDTO dto = process.toDTO();
            if(dto.getJob().getId() == jobPostingId )
                dtos.add(dto);
        }

        return dtos;
    }

    public List<ProcessDTO> getProcessesByApplicantId(int applicantId) {

        List<ProcessDTO> dtos = new ArrayList<>();

        for(Process process: repository.findAll()) {

            ProcessDTO dto = process.toDTO();
            if(dto.getApplicant().getId() == applicantId )
                dtos.add(dto);
        }

        return dtos;
    }
}
