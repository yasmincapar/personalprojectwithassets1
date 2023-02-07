package com.mypersonalprojectasset.personalprojectwithassets.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;

import javax.persistence.*;

@AllArgsConstructor
//@AllArgsConstructor generates a constructor requiring argument for every field in the annotated class
@Builder
//@Builder lets you automatically produce the code required to have your class be instantiable with code such as:
//
//Person.builder()
//.name("Adam Savage")
//.city("San Francisco")
//.job("Mythbusters")
//.job("Unchained Reaction")
//.build();
@Scope("session")
@Entity
@NoArgsConstructor
//means no constructor is needed this creates it on its own
//@Entity annotation specifies that the class is an entity and is mapped to a database table.
@Table(name="usertable")//this is the table we created
@Data//It generates the getter methods for all the fields
//so we basically don't need to use create the getter and setters manually @Data annotation does it.
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)//autoincrement my table id values
    private int id;

    private String username;
    private String password;
    private Role role;

}
