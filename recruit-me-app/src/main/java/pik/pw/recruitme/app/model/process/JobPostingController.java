package pik.pw.recruitme.app.model.process;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pik.pw.recruitme.app.model.process.domain.JobPostingFacade;
import pik.pw.recruitme.app.model.process.dto.JobPostingDTO;

import java.util.List;

@RestController
public class JobPostingController {

    private JobPostingFacade jobPostingFacade;

    public JobPostingController(JobPostingFacade jobPostingFacade) {

        this.jobPostingFacade = jobPostingFacade;
    }

    @GetMapping("/jobs")
    List<JobPostingDTO> getJobPostings() {
        return jobPostingFacade.findAll();
    }

    @GetMapping("/jobs/{id}")
    JobPostingDTO getJobPosting(@PathVariable int id) {
        return jobPostingFacade.show(id);
    }

    @PostMapping("/jobs")
    JobPostingDTO addJobPosting(@RequestBody JobPostingDTO jobPostingDTO){

        return jobPostingFacade.add(jobPostingDTO);
    }

    @PostMapping("/jobs/{id}")
    ResponseEntity<?> addJobPosting(){

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/jobs")
    ResponseEntity<?> updateJobPostings(){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/jobs/{id}")
    void updateJobPosting(@RequestBody JobPostingDTO jobPostingDTO){
        jobPostingFacade.add(jobPostingDTO);
    }


    @DeleteMapping("/jobs/{id}")
    void deleteJobPosting(@PathVariable int id){

        jobPostingFacade.delete(id);

    }

    @DeleteMapping("/jobs")
    ResponseEntity<?> deleteJobPostings(@PathVariable int id){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


}
