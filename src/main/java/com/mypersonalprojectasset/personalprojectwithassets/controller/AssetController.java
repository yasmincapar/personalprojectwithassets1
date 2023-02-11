package com.mypersonalprojectasset.personalprojectwithassets.controller;

import com.mypersonalprojectasset.personalprojectwithassets.model.AssetType;
import com.mypersonalprojectasset.personalprojectwithassets.service.AssetService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class AssetController {
    @Autowired
    private AssetService service;

public AssetController(){
}

    public AssetController(AssetService service){
    this.service=service;
    }

    @GetMapping("/assetpage")
    public String goingtoassetpage(Model model){
        List<AssetType> assettypelist= service.getAllAssetTypes();
        model.addAttribute("assetTypes",assettypelist);

        return "addassetpage";
    }


}
