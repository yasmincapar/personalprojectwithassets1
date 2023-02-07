package com.mypersonalprojectasset.personalprojectwithassets.controller;

import com.mypersonalprojectasset.personalprojectwithassets.model.AssetType;
import com.mypersonalprojectasset.personalprojectwithassets.model.Role;
import com.mypersonalprojectasset.personalprojectwithassets.model.User;
import com.mypersonalprojectasset.personalprojectwithassets.service.AssetTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class AssetTypeController {
    private final AssetTypeService service;

    @Autowired
    public AssetTypeController(AssetTypeService service) {
        this.service = service;
    }

 //  @GetMapping("/assettypepage")//this is once it reaches teh index page if it is an admin will authorize if not will not authorize
//   public String fromadmintoassettypepage(Model theModel, HttpSession session, AssetType assetType) {
//      return "addassettype";}

    @GetMapping("/assettypepage")
    public String showSignupPage(User user, HttpSession session) {
        User userInSession = (User) session.getAttribute("user");
        if (userInSession.getRole().equals(Role.ADMIN)) {
            return "addassettype";
        } else if (userInSession.getRole().equals(Role.USER)) {
            return "unauthorized";
        } else {
            return "redirect:/login";
        }

    }
    @PostMapping("/addasset")
    public String addUser(@Valid AssetType assetType, BindingResult result, Model theModel) {
        if (result.hasErrors()) {
            return "adduser";
        }

        service.saveAssetType(assetType);//when add user us pressed user should be saved
        return "redirect:/adminpage";
    }
    }