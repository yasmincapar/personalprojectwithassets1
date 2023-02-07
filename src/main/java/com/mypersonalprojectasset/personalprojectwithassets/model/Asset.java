package com.mypersonalprojectasset.personalprojectwithassets.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.OneToOne;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Asset {
    private int id;
    private String title;
    private String line_number;
    private String link;
    private String programming_language;

    @OneToOne//one asset has one type
    private AssetType assetType;

}
