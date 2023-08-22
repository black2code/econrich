package com.example.econrich.department.dto;

import com.example.econrich.location.dto.LocationResponse;
import lombok.Getter;

import java.util.List;


@Getter
public class DepartmentResponse {

    private String departmentName;
    private List<LocationResponse> locationList;

    public DepartmentResponse(String departmentName, List<LocationResponse> locationList) {
        this.departmentName = departmentName;
        this.locationList = locationList;
    }

}
