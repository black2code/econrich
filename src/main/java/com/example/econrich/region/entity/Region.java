package com.example.econrich.region.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;


@Getter
@Entity
@Table(name = "regions")
public class Region {

    @Id
    @Column(name = "region_id")
    private Integer regionId;

    @Column(name = "region_name")
    private String regionName;

}

