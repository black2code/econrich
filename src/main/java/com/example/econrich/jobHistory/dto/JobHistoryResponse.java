package com.example.econrich.jobHistory.dto;


import com.example.econrich.jobHistory.entity.JobHistory;
import lombok.Getter;

import java.time.LocalDate;


@Getter
public class JobHistoryResponse {

    private final LocalDate startDate;
    private final LocalDate endDate;
    private final String departmentName;
    private final String jobTitle;

    public JobHistoryResponse (JobHistory jobHistory) {
        this.startDate = jobHistory.getStartDate();
        this.endDate = jobHistory.getEndDate();
        this.departmentName = jobHistory.getDepartmentName();
        this.jobTitle = jobHistory.getJob().getJobTitle();
    }
}
