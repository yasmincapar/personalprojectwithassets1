package com.mypersonalprojectasset.personalprojectwithassets.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="asset_table")
public class Asset {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String creation_date;
    private String link;
//shouldnt be hard coded attributes  list of attributes
    //specifc attributes for assettype
    //custom asset types
    @OneToOne//one asset has one type
    private AssetType assetType;

}
