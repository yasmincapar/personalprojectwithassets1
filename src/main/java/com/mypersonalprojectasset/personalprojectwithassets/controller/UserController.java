package com.mypersonalprojectasset.personalprojectwithassets.controller;

import com.mypersonalprojectasset.personalprojectwithassets.model.Role;
import com.mypersonalprojectasset.personalprojectwithassets.model.User;
import com.mypersonalprojectasset.personalprojectwithassets.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserRepository repository;
//model carries and passes everything to the view will carry from controller to html
    @GetMapping("/adminpage")//this is once it reaches teh index page if it is an admin will authorize if not will not authorize
    public String showUserList(Model theModel, HttpSession session) {
        User user = (User) session.getAttribute("user");
        theModel.addAttribute("allusers", repository.findAll());
      //  User user = new User(theModel.getAttribute("username"), theModel.getAttribute("role"));
        if (user.getRole().equals(Role.ADMIN)) {
            return "adminpage";
        } else if (user.getRole().equals(Role.USER)) {
            return "unauthorized";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/signup")
    public String showSignupPage(User user, HttpSession session) {
        User userInSession = (User) session.getAttribute("user");
        if (userInSession.getRole().equals(Role.ADMIN)) {
            return "adduser";
        } else if (userInSession.getRole().equals(Role.USER)) {
            return "unauthorized";
        } else {
            return "redirect:/login";
        }

    }
    @PostMapping("/adduser")
    public String addUser(@Valid User user, BindingResult result, Model theModel) {
        if (result.hasErrors()) {
            return "adduser";
        }

        repository.save(user);//when add user us pressed user should be saved
        return "redirect:/adminpage";
    }
    @GetMapping("/create/{id}")
    public String createUser(@PathVariable int id, @Valid User user, BindingResult result, Model theModel, HttpSession session) {
                return "userassetcreatepage";

    }



}
