package com.bartek.myapp.controller;

import com.bartek.myapp.model.User;
import com.bartek.myapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/create")
    public @ResponseBody User createUser( @Valid @RequestBody User user) {
        User saved = userService.createUser(user.getLogin(), user.getPassword());
        return saved;
    }

    @GetMapping
    public List<User> users() {
        return (List<User>)userService.findAllUsers();
    }

}
