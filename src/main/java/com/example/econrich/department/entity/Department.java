package com.example.econrich.department.entity;

import com.example.econrich.employee.entity.Employee;
import com.example.econrich.location.entity.Location;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;


@Getter
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @Column(name = "department_id")
    private Integer departmentId;

    @Column(name = "department_name")
    private String departmentName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private Location location;

    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

}