package com.example.econrich.employee.service;


import com.example.econrich.employee.dto.EmployeeResponse;
import com.example.econrich.employee.entity.Employee;
import com.example.econrich.employee.mapper.EmployeeMapper;
import com.example.econrich.employee.repository.EmployeeRepository;
import com.example.econrich.global.error.ErrorCode;
import com.example.econrich.global.exception.CustomException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;


    public EmployeeResponse getEmployeeById(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOTFOUND_USER));

        EmployeeResponse employeeResponse = employeeMapper.employeeToEmployeeResponse(employee);
        return employeeResponse;
    }

}
