package com.example.econrich.jobHistory.controller;

import com.example.econrich.global.dto.GlobalResponse;
import com.example.econrich.jobHistory.dto.JobHistoryResponse;
import com.example.econrich.jobHistory.service.JobHistoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/employees")
public class JobHistoryController {

    private final JobHistoryService jobHistoryService;

    @GetMapping("/{employeeId}/history")
    @Operation(summary = "특정 사원 이력 정보 조회 API")
    @Parameter(name = "employeeId", description = "사원 번호 ex.100")
    public GlobalResponse getJobHistoryByEmployeeId(@PathVariable("employeeId") Long employeeId) {

        List<JobHistoryResponse> jobHistoryResponseList =
                jobHistoryService.getJobHistoryByEmployeeId(employeeId);
        return GlobalResponse.success(jobHistoryResponseList);

    }
}
