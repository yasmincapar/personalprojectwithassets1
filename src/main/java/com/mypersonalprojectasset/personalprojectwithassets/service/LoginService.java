package com.mypersonalprojectasset.personalprojectwithassets.service;

import com.mypersonalprojectasset.personalprojectwithassets.model.User;
import com.mypersonalprojectasset.personalprojectwithassets.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {
    private final UserRepository repository;

    public LoginService(UserRepository repository) {
        this.repository = repository;
    }

    public User findByUsernameAndPassword(String username, String password) {
        return repository.findByUsernameAndPassword(username, password);
    }

    public List<User> findAll() {
        return repository.findAll();
    }
}
