package com.mypersonalprojectasset.personalprojectwithassets.util;

import com.mypersonalprojectasset.personalprojectwithassets.model.Role;
import com.mypersonalprojectasset.personalprojectwithassets.model.User;
import com.mypersonalprojectasset.personalprojectwithassets.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class InitializerRunner implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(InitializerRunner.class);

    @Autowired
    UserRepository repository;

    @Override
    public void run(String... args) throws Exception {
       // repository.deleteAll();
        if(repository.count() == 0) {
            repository.save(User.builder().username("laura").password("123456").role(Role.USER).build());
            repository.save(User.builder().username("mel").password("12345").role(Role.USER).build());
            repository.save(User.builder().username("issy").password("123").role(Role.USER).build());
            repository.save(User.builder().username("yasmin").password("1234").role(Role.ADMIN).build());
            repository.save(User.builder().username("isla").password("123456").role(Role.VIEWER).build());
            repository.findAll().forEach(user -> logger.info("{}", user));
        }
    }
}
