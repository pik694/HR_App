package com.bartek.myapp.service;

import com.bartek.myapp.model.User;

import java.util.Optional;

public interface UserService {
    public User createUser(String login, String password);
    public Optional<User> deleteUser(long id);
    public Optional<User> findUserById(long id);
    public User editUser(long id, String newLogin, String newPassword);
    public User login(String login, String password);
    public Iterable<User> findAllUsers();
}
