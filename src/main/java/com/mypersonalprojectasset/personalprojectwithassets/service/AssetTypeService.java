package com.mypersonalprojectasset.personalprojectwithassets.service;

import com.mypersonalprojectasset.personalprojectwithassets.model.AssetType;
import com.mypersonalprojectasset.personalprojectwithassets.repository.AssetTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class AssetTypeService {
    private final AssetTypeRepository repository;
@Autowired
    public AssetTypeService(AssetTypeRepository repository) {
        this.repository = repository;
    }


    public void save(AssetType assetType) {
     assetType= repository.save(assetType);
    if(assetType.getId()>0){
    System.out.println("asset type has been created "+ assetType.getId());
}
else{
    System.out.println("asset has not been created");
}
    }
    public List<AssetType> findAll() {
    return repository.findAll();
    }
}
