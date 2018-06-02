package pik.pw.recruitme.app.model.process;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pik.pw.recruitme.app.model.process.domain.JobPostingFacade;
import pik.pw.recruitme.app.model.process.domain.ProcessFacade;
import pik.pw.recruitme.app.model.process.dto.JobPostingDTO;
import pik.pw.recruitme.app.model.process.dto.ProcessDTO;

import java.util.List;

@RestController
public class JobPostingController {

    private JobPostingFacade jobPostingFacade;
    private ProcessFacade processFacade;

    public JobPostingController(JobPostingFacade jobPostingFacade, ProcessFacade processFacade) {

        this.jobPostingFacade = jobPostingFacade;
        this.processFacade = processFacade;
    }


    // "/jobs"

    @DeleteMapping("/jobs")
    ResponseEntity<?> deleteJobPostings() {

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/jobs")
    List<JobPostingDTO> getJobPostings() {

        return jobPostingFacade.findAll();
    }

    @PostMapping("/jobs")
    JobPostingDTO addJobPosting(@RequestBody JobPostingDTO jobPostingDTO) {

        return jobPostingFacade.add(jobPostingDTO);
    }

    @PutMapping("/jobs")
    ResponseEntity<?> updateJobPostings(){

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // "/jobs/{id}"

    @DeleteMapping("/jobs/{id}")
    void deleteJobPosting(@PathVariable int id) {

        jobPostingFacade.delete(id);

    }

    @GetMapping("/jobs/{id}")
    JobPostingDTO getJobPosting(@PathVariable int id) {

        return jobPostingFacade.show(id);
    }


    @PostMapping("/jobs/{id}")
    ResponseEntity<?> addJobPosting() {

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/jobs/{id}")
    void updateJobPosting(@RequestBody JobPostingDTO jobPostingDTO){

        jobPostingFacade.add(jobPostingDTO);
    }

    // "/jobs/{id}/processes

    @DeleteMapping("jobs/{id}/processes")
    ResponseEntity<?> deleteApplicantProcesses() {

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("jobs/{id}/processes")
    List<ProcessDTO> getProcesses(@PathVariable int id) {

        return processFacade.findAllProcessesOfJobPosting(id);
    }

    @PostMapping("/jobs/{id}/processes")
    ResponseEntity<?> addProcesses() {

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/jobs/{id}/processes")
    ResponseEntity<?> updateProcesses() {

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }











}
