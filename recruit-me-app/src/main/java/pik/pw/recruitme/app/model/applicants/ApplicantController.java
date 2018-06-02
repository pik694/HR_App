package pik.pw.recruitme.app.model.applicants;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pik.pw.recruitme.app.model.applicants.domain.ApplicantFacade;
import pik.pw.recruitme.app.model.applicants.dto.ApplicantDTO;
import pik.pw.recruitme.app.model.process.domain.ProcessFacade;
import pik.pw.recruitme.app.model.process.dto.ProcessDTO;

import java.util.List;

@RestController
public class ApplicantController {

    private ApplicantFacade applicantFacade;
    private ProcessFacade processFacade;

    public ApplicantController(ApplicantFacade applicantFacade, ProcessFacade processFacade) {

        this.applicantFacade = applicantFacade;
        this.processFacade = processFacade;
    }

    // "/applicants"

    @DeleteMapping("/applicants")
    ResponseEntity<?> deleteApplicants() {

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/applicants")
    List<ApplicantDTO> getApplicants() {

        return applicantFacade.findAll();
    }

    @PostMapping("/applicants")
    ApplicantDTO addApplicant(@RequestBody ApplicantDTO applicantDTO) {

        return applicantFacade.add(applicantDTO);
    }

    @PutMapping("/applicants")
    ResponseEntity<?> updateApplicants(){

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    // "/applicants/{id}

    @DeleteMapping("/applicants/{id}")
    void deleteApplicant(@PathVariable int id) {

        applicantFacade.delete(id);

    }

    @GetMapping("/applicants/{id}")
    ApplicantDTO getApplicant(@PathVariable int id) {

        return applicantFacade.show(id);
    }


    @PostMapping("/applicants/{id}")
    ResponseEntity<?> addApplicant() {

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }


    @PutMapping("/applicants/{id}")
    void updateApplicant(@RequestBody ApplicantDTO applicantDTO){

        applicantFacade.add(applicantDTO);
    }

    // "applicants/{id}/processes

    @DeleteMapping("/applicants/{id}/processes")
    ResponseEntity<?> deleteApplicantProcesses() {

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/applicants/{id}/processes")
    List<ProcessDTO> getApplicantProcesses(@PathVariable int id) {

        return processFacade.getProcessesByApplicantId(id);
    }

    @PostMapping("/applicants/{id}/processes")
    ResponseEntity<?> addApplicantProcess() {

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/applicants/{id}/process")
    ResponseEntity<?> updateApplicantProcesses() {

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }



}
