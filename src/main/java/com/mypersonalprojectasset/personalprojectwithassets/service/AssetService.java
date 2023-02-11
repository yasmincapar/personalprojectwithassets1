package com.mypersonalprojectasset.personalprojectwithassets.service;

import com.mypersonalprojectasset.personalprojectwithassets.model.AssetType;
import com.mypersonalprojectasset.personalprojectwithassets.repository.AssetRepository;
import com.mypersonalprojectasset.personalprojectwithassets.repository.AssetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssetService {
    @Autowired
    private AssetTypeRepository assetTypeRepository;
    @Autowired
    private AssetRepository repository;


    public AssetService(){

    }

    public AssetService(AssetTypeRepository assetTypeRepository, AssetRepository repository) {
        this.assetTypeRepository = assetTypeRepository;
        this.repository = repository;
    }

    public List<AssetType> getAllAssetTypes() {
        return assetTypeRepository.findAll();

    }
}
