package com.example.econrich.department.service;

import com.example.econrich.department.dto.DepartmentResponse;
import com.example.econrich.department.entity.Department;
import com.example.econrich.department.repository.DepartmentRepository;
import com.example.econrich.employee.entity.Employee;
import com.example.econrich.global.error.ErrorCode;
import com.example.econrich.global.exception.CustomException;
import com.example.econrich.location.dto.LocationResponse;
import com.example.econrich.location.entity.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    public void increaseSalaryByDepartment(Long departmentId, BigDecimal increaseRate) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new CustomException(ErrorCode.DEPARTMENT_NOT_FOUND));

        if (increaseRate.compareTo(BigDecimal.ZERO) < 0) {
            throw new CustomException(ErrorCode.INVALID_INPUT_VALUE);
        }

        List<Employee> employees = department.getEmployees();
        for (Employee employee : employees) {
            BigDecimal currentSalary = employee.getSalary();
            BigDecimal increasedSalary = currentSalary.multiply(BigDecimal.ONE.add(increaseRate.divide(BigDecimal.valueOf(100))));
            employee.setSalary(increasedSalary);
        }
    }
}
