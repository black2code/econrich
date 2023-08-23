package com.example.econrich.employee.entity;

import com.example.econrich.department.entity.Department;
import com.example.econrich.job.entity.Job;
import jakarta.persistence.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;


@Getter
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "hire_date")
    private LocalDate hireDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "job_id")
    private Job job;

    @Column(name = "salary")
    private BigDecimal salary;

    @Column(name = "commission_pct")
    private BigDecimal commissionPct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

    public String getJobTitle() {
        return job.getJobTitle();
    }

    public void setSalary(BigDecimal increasedSalary) {
        this.salary = increasedSalary;
    }

}
