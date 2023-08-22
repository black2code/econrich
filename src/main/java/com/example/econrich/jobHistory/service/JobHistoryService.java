package com.example.econrich.jobHistory.service;

import com.example.econrich.employee.entity.Employee;
import com.example.econrich.employee.repository.EmployeeRepository;
import com.example.econrich.global.error.ErrorCode;
import com.example.econrich.global.exception.CustomException;
import com.example.econrich.jobHistory.dto.JobHistoryResponse;
import com.example.econrich.jobHistory.entity.JobHistory;
import com.example.econrich.jobHistory.repository.JobHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class JobHistoryService {

    private final EmployeeRepository employeeRepository;
    private final JobHistoryRepository jobHistoryRepository;

    public List<JobHistoryResponse> getJobHistoryByEmployeeId(Long employeeId) {

        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new CustomException(ErrorCode.NOTFOUND_USER));

        List<JobHistory> jobHistories = jobHistoryRepository.findByEmployee(employee);
        return jobHistories.stream()
                .map(JobHistoryResponse::new)
                .collect(Collectors.toList());
    }
}
