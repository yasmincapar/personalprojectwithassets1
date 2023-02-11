package com.mypersonalprojectasset.personalprojectwithassets.service;

import com.mypersonalprojectasset.personalprojectwithassets.model.User;
import com.mypersonalprojectasset.personalprojectwithassets.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;


    }

    //this finds all the users in the database and returns it back
    public List<User> findAll() {
        return repository.findAll();
    }

    public void save(User user) {
    user = repository.save(user);//save to the database
        //so basically if the user is created will return back to you
        //the user and the userId.
    if(user.getId()>0){//gives back the user to you with the id
        System.out.println("the user is saved with id: "+user.getId());
}
    else{
        throw new RuntimeException("the cannot be saved");
}
    }


}
