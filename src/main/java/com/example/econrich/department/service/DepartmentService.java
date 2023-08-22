package com.example.econrich.department.service;

import com.example.econrich.department.dto.DepartmentResponse;
import com.example.econrich.department.entity.Department;
import com.example.econrich.department.repository.DepartmentRepository;
import com.example.econrich.location.dto.LocationResponse;
import com.example.econrich.location.entity.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<DepartmentResponse> getAllDepartmentsWithLocations() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream()
                .map(this::mapToDepartmentResponse)
                .collect(Collectors.toList());
    }

    private DepartmentResponse mapToDepartmentResponse(Department department) {
        Location location = department.getLocation();
        LocationResponse locationResponse = new LocationResponse(
                location.getCity(),
                location.getPostalCode(),
                location.getStateProvince(),
                location.getStreetAddress()
        );
        return new DepartmentResponse(department.getDepartmentName(), Collections.singletonList(locationResponse));
    }
}
