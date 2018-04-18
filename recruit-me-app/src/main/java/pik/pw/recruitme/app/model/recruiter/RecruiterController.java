package pik.pw.recruitme.app.model.recruiter;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pik.pw.recruitme.app.model.recruiter.domain.RecruiterFacade;
import pik.pw.recruitme.app.model.recruiter.dto.RecruiterDTO;

@RestController
public class RecruiterController {
    private RecruiterFacade recruiterFacade;

    public RecruiterController(RecruiterFacade recruiterFacade){
        this.recruiterFacade = recruiterFacade;
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
