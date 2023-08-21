package com.example.econrich.jobHistory.entity;

import com.example.econrich.department.entity.Department;
import com.example.econrich.employee.entity.Employee;
import com.example.econrich.job.entity.Job;
import jakarta.persistence.*;

import java.time.LocalDate;


@Entity
@Table(name = "job_history")
public class JobHistory {

    @Id
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Id
    @Column(name = "start_date")
    private LocalDate startDate;

    @Id
    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "job_id")
    private Job job;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

}
