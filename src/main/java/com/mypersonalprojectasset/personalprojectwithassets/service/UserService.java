package com.mypersonalprojectasset.personalprojectwithassets.service;

import com.mypersonalprojectasset.personalprojectwithassets.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;


    }
}
