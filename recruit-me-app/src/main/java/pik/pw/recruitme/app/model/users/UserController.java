package pik.pw.recruitme.app.model.users;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pik.pw.recruitme.app.model.users.domain.UserFacade;
import pik.pw.recruitme.app.model.users.dto.UserDTO;

@RestController
@CrossOrigin(origins = "http://127.0.0.1:80")
public class UserController {

    private UserFacade userFacade;

    String hello = "Hello World";

    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }

    @GetMapping("/hello")
    public String getHello() {
        return hello;
    }

    @GetMapping("recruiters")
    Page<UserDTO> getRecruiters(Pageable pageable) {
        return userFacade.findAll(pageable);
    }

    @GetMapping("users/{id}")
    UserDTO getRecruiter(@PathVariable int id) {
        return userFacade.show(id);
    }
}
