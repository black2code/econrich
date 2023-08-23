package com.example.econrich.department.controller;

import com.example.econrich.department.dto.DepartmentResponse;
import com.example.econrich.department.service.DepartmentService;
import com.example.econrich.global.dto.GlobalResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
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

    @Transactional
    @PostMapping("/increase-salary")
    @Operation(summary = "특정 부서의 급여를 특정 비율로 인상 및 사원 정보 업데이트 API")
    @Parameter(name = "departmentId", description = "부서 번호 ex.90")
    @Parameter(name = "increaseRate", description = "퍼센트 숫자 ex.10")
    public GlobalResponse increaseSalaryByDepartment(@RequestParam(value = "departmentId", required = true) Long departmentId,
                                                     @RequestParam(value = "increaseRate", required = true) BigDecimal increaseRate) {

        departmentService.increaseSalaryByDepartment(departmentId, increaseRate);
        return GlobalResponse.success("Salary increased successfully");

    }

}
