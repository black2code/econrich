package com.example.econrich.jobHistory.repository;

import com.example.econrich.employee.entity.Employee;
import com.example.econrich.jobHistory.entity.JobHistory;
import com.example.econrich.jobHistory.entity.JobHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobHistoryRepository extends JpaRepository<JobHistory, JobHistoryId> {

    List<JobHistory> findByEmployee(Employee employee);
}

