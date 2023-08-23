package com.example.econrich.employee.controller;

import com.example.econrich.employee.dto.EmployeeResponse;
import com.example.econrich.employee.service.EmployeeService;
import com.example.econrich.global.dto.GlobalResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/{employeeId}")
    @Operation(summary = "특정 사원 현재 정보 조회 API")
    @Parameter(name = "employeeId", description = "사원 번호 ex.100")
    public GlobalResponse getEmployeeById(@PathVariable("employeeId") Long employeeId) {

        EmployeeResponse employeeResponse = employeeService.getEmployeeById(employeeId);
        return GlobalResponse.success(employeeResponse);
    }

}
