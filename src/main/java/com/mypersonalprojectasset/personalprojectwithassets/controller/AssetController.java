package com.mypersonalprojectasset.personalprojectwithassets.controller;

import com.mypersonalprojectasset.personalprojectwithassets.model.Asset;
import com.mypersonalprojectasset.personalprojectwithassets.model.AssetRequest;
import com.mypersonalprojectasset.personalprojectwithassets.model.AssetType;
import com.mypersonalprojectasset.personalprojectwithassets.service.AssetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class AssetController {
    @Autowired
    private AssetService service;

    public AssetController() {
    }

    public AssetController(AssetService service) {
        this.service = service;
    }

    @GetMapping("/assetpage")
    public String goingtoassetpage(Model model) {
        List<AssetType> assettypelist = service.getAllAssetTypes();
        model.addAttribute("assetTypes", assettypelist);
        model.addAttribute("asset", new AssetRequest());
        return "addassetpage";
    }

    @PostMapping("/addasset")
    public String addnewasset(AssetRequest assetRequest, Model model) {
        service.addnewasset(assetRequest);
        model.addAttribute("allassets", service.getAllAssets());
        return "assetlistpage";
    }


}
