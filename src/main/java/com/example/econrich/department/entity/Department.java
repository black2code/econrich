package com.example.econrich.department.entity;

import com.example.econrich.employee.entity.Employee;
import com.example.econrich.location.entity.Location;
import jakarta.persistence.*;
import lombok.Getter;


@Getter
@Entity
@Table(name = "departments")
public class Department {

    @Id
    @Column(name = "department_id")
    private Integer departmentId;

    @Column(name = "department_name")
    private String departmentName;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employee manager;

    @ManyToOne
    @JoinColumn(name = "location_id")
    private Location location;

}
