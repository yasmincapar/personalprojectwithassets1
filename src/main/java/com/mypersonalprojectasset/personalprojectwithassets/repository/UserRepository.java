package com.mypersonalprojectasset.personalprojectwithassets.repository;

import com.mypersonalprojectasset.personalprojectwithassets.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
//This is where we'll place all our derived query methods.
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    //To get all this free functionality, all we had to do was declare an interface which extends Spring Data JPA’s JpaRepository, specifying the domain type as User and the id type as integer
    //User is the classes name we use extends as we want to be able to use the JpaRepository
    @Query("SELECT u FROM User u WHERE u.username = ?1 AND u.password = ?2")
    //controller has username and password
    //select all users where the username that user imputted will equal to password that user inputted
    User findByUsernameAndPassword(String username, String password);
    //creating a user type
}