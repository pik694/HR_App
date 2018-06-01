package pik.pw.recruitme.app.model.applicants;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pik.pw.recruitme.app.model.applicants.domain.ApplicantFacade;
import pik.pw.recruitme.app.model.applicants.dto.ApplicantDTO;
import pik.pw.recruitme.app.model.users.dto.UserDTO;

import java.util.List;

@RestController
public class ApplicantController {

    private ApplicantFacade applicantFacade;

    public ApplicantController(ApplicantFacade applicantFacade) {

        this.applicantFacade = applicantFacade;
    }

    @GetMapping("/applicants")
    List<ApplicantDTO> getApplicants() {

        return applicantFacade.findAll();
    }

    @GetMapping("/applicants/{id}")
    ApplicantDTO getApplicant(@PathVariable int id) {

        return applicantFacade.show(id);
    }

    @PostMapping("/applicants")
    ApplicantDTO addApplicant(@RequestBody ApplicantDTO applicantDTO){

        return applicantFacade.add(applicantDTO);
    }

    @PostMapping("/applicants/{id}")
    ResponseEntity<?> addApplicant() {

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/applicants")
    ResponseEntity<?> updateApplicants(){

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/applicants/{id}")
    void updateApplicant(@RequestBody ApplicantDTO applicantDTO){

        applicantFacade.add(applicantDTO);
    }


    @DeleteMapping("/applicants/{id}")
    void deleteApplicant(@PathVariable int id){

        applicantFacade.delete(id);

    }

    @DeleteMapping("/applicants")
    ResponseEntity<?> deleteApplicants(@PathVariable int id){

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
