package com.example.econrich.location.dto;

import lombok.Getter;


@Getter
public class LocationResponse {

    private String city;
    private String postalCode;
    private String stateProvince;
    private String streetAddress;

    public LocationResponse(String city, String postalCode, String stateProvince, String streetAddress) {
        this.city = city;
        this.postalCode = postalCode;
        this.stateProvince = stateProvince;
        this.streetAddress = streetAddress;
    }

}
