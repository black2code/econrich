package com.example.econrich.department.controller;

import com.example.econrich.department.dto.DepartmentResponse;
import com.example.econrich.department.entity.Department;
import com.example.econrich.department.service.DepartmentService;
import com.example.econrich.global.dto.GlobalResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentService departmentService;

    @GetMapping
    @Operation(summary = "모든 부서 정보 조회 API")
    public GlobalResponse getAllDepartmentsWithLocations() {

        List<DepartmentResponse> response = departmentService.getAllDepartmentsWithLocations();
        return GlobalResponse.success(response);

    }

}
