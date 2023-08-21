package com.example.econrich.country.entity;

import com.example.econrich.region.entity.Region;
import jakarta.persistence.*;
import lombok.Getter;


@Getter
@Entity
@Table(name = "countries")
public class Country {

    @Id
    @Column(name = "country_id")
    private String countryId;

    @Column(name = "country_name")
    private String countryName;

    @ManyToOne
    @JoinColumn(name = "region_id")
    private Region region;

}
