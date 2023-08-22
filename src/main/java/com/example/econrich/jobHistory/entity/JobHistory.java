package com.example.econrich.jobHistory.entity;

import com.example.econrich.department.entity.Department;
import com.example.econrich.employee.entity.Employee;
import com.example.econrich.job.entity.Job;
import jakarta.persistence.*;
import lombok.Getter;

import java.io.Serializable;
import java.time.LocalDate;


@Getter
@Entity
@Table(name = "job_history")
@IdClass(JobHistoryId.class)
public class JobHistory implements Serializable {

    @Id
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Id
    @Column(name = "start_date")
    private LocalDate startDate;

    @Id
    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    public String getDepartmentName() {
        return department.getDepartmentName();
    }
}
