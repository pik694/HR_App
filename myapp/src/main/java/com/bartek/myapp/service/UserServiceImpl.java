package com.bartek.myapp.service;

import com.bartek.myapp.model.User;
import com.bartek.myapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repository;

    @Override
    public User createUser(String login, String password) {
        User saved = repository.save(new User(login, password));
        return saved;
    }

    @Override
    public Optional<User> deleteUser(long id) {
        Optional<User> user = repository.findById(id);
        if (user.isPresent()) {
            repository.delete(user.get());
        }
        return user;
    }

    @Override
    public Optional<User> findUserById(long id) {
        return repository.findById(id);
    }

    @Override
    public User editUser(long id, String newLogin, String newPassword) {
        Optional<User> user = repository.findById(id);

        if (user.isPresent()) {
            User foundUser = user.get();
            foundUser.setLogin(newLogin);
            foundUser.setPassword(newPassword);
            repository.save(foundUser);
        }
        return user.get();
    }

    @Override
    public User login(String login, String password) {
        return null;
    }

    @Override
    public Iterable<User> findAllUsers() {
        return repository.findAll();
    }
}
