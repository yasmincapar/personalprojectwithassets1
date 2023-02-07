package com.mypersonalprojectasset.personalprojectwithassets.service;

import com.mypersonalprojectasset.personalprojectwithassets.model.AssetType;
import com.mypersonalprojectasset.personalprojectwithassets.repository.AssetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetTypeService {
    private final AssetTypeRepository repository;
@Autowired
    public AssetTypeService(AssetTypeRepository repository) {
        this.repository = repository;
    }
    public AssetType saveAssetType(AssetType assetype) {
        return repository.save(assetype);
    }
}
