package pik.pw.recruitme.app.model.users;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pik.pw.recruitme.app.model.users.domain.UserFacade;
import pik.pw.recruitme.app.model.users.dto.UserDTO;

import java.util.List;

@RestController
public class UserController {

    private UserFacade userFacade;

    public UserController(UserFacade userFacade) {
        this.userFacade = userFacade;
    }


    @GetMapping("/users")
    List<UserDTO> getRecruiters() {
        return userFacade.findAll();
    }

    @GetMapping("/users/{id}")
    UserDTO getRecruiter(@PathVariable int id) {
        return userFacade.show(id);
    }

    @PostMapping("/users")
    void addUser(@RequestBody UserDTO userDTO){

        userFacade.add(userDTO);
    }

    @PostMapping("/users/{id}")
    ResponseEntity<?> addUser(){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/users")
    ResponseEntity<?> updateUsers(){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PutMapping("/users/{id}")
    void updateUser(@RequestBody UserDTO userDTO){
        userFacade.add(userDTO);
    }


    @DeleteMapping("/users/{id}")
    void deleteUser(@PathVariable int id){

        userFacade.delete(id);

    }

    @DeleteMapping("/users")
    ResponseEntity<?> deleteUsers(@PathVariable int id){
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }





}
