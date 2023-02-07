package com.mypersonalprojectasset.personalprojectwithassets.controller;

import com.mypersonalprojectasset.personalprojectwithassets.model.Role;
import com.mypersonalprojectasset.personalprojectwithassets.model.User;
import com.mypersonalprojectasset.personalprojectwithassets.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired//no need to create getters and setters
    UserRepository repository;

    //GET is used to request data from a specified resource
    @GetMapping("/")
    public String initialpage(Model model) {
        model.addAttribute("user", new User());
        return "index";//this is the first page
        //this is were I first want my page to open up
    }
    @GetMapping("/thelogin")
    public String login(Model model) {
        model.addAttribute("user", new User());
        return "login";//this is the first page
        //this is were I first want my page to open up
    }


//POST is used to send data to a server to create/update a resource.
    @PostMapping("/login")
    public String login(@ModelAttribute User user, Model model, HttpSession session) {
        User foundUser = repository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        //user.getPassword() comes form webpage
        //getting the query and cheking if the user actually exists
        if (foundUser != null) {
            session.setAttribute("user", foundUser);
            model.addAttribute("user", foundUser);
            if (foundUser.getRole().equals(Role.ADMIN)) {
                //if the founduser role is admin
                return "adminpage";//redirect you to this page
            }
            else if(foundUser.getRole().equals(Role.VIEWER)){
                return "viewerpage";
            }
            else {
                return "userpage";
            }
        } else {
            return "redirect:/login-error";
        }
    }

    @GetMapping("/login-error")
    public String loginError(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        model.addAttribute("loginError", true);
        return "login";
    }


}
