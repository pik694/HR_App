package pik.pw.recruitme.app.model.recruiter;

import groovy.lang.GrabExclude;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pik.pw.recruitme.app.model.recruiter.domain.RecruiterFacade;
import pik.pw.recruitme.app.model.recruiter.dto.RecruiterDTO;

@RestController
public class RecruiterController {
    private RecruiterFacade recruiterFacade;

    String hello = "Hello World";

    public RecruiterController(RecruiterFacade recruiterFacade) {
        this.recruiterFacade = recruiterFacade;
    }

    @GetMapping("/hello")
    @CrossOrigin(origins = "http://127.0.0.1:80")
    public String getHello() {
        return hello;
    }

    @GetMapping("recruiters")
    Page<RecruiterDTO> getRecruiters(Pageable pageable) {
        return recruiterFacade.findAll(pageable);
    }

    @GetMapping("recruiter/{id}")
    RecruiterDTO getRecruiter(@PathVariable int id) {
        return recruiterFacade.show(id);
    }
}
