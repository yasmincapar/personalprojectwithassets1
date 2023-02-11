package com.mypersonalprojectasset.personalprojectwithassets.repository;

import com.mypersonalprojectasset.personalprojectwithassets.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends JpaRepository<Asset, Integer> {
}
