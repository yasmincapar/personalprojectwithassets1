package com.mypersonalprojectasset.personalprojectwithassets.service;

import com.mypersonalprojectasset.personalprojectwithassets.model.Asset;
import com.mypersonalprojectasset.personalprojectwithassets.model.AssetRequest;
import com.mypersonalprojectasset.personalprojectwithassets.model.AssetType;
import com.mypersonalprojectasset.personalprojectwithassets.repository.AssetRepository;
import com.mypersonalprojectasset.personalprojectwithassets.repository.AssetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
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

    @Transactional(readOnly = true)
    public List<AssetType> getAllAssetTypes() {
        return assetTypeRepository.findAll();

    }

    @Transactional
    public void addnewasset(AssetRequest assetRequest) {
        AssetType assetType = assetTypeRepository.findById(assetRequest.getAssetTypeId()).get();
        Asset asset = new Asset();
        asset.setName(assetRequest.getName());
        asset.setLink(assetRequest.getLink());
        asset.setCreation_date(LocalDate.now().toString());
        asset.setAssetType(assetType);

        repository.save(asset);
    }
}
