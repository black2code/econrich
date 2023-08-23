package com.example.econrich.employee.mapper;


import com.example.econrich.employee.dto.EmployeeResponse;
import com.example.econrich.employee.entity.Employee;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", // 빌드 시 구현체 만들고 빈으로 등록
        injectionStrategy = InjectionStrategy.CONSTRUCTOR, // 생성자 주입 전략
        unmappedTargetPolicy = ReportingPolicy.ERROR) // 일치하지 않는 필드가 있으면 빌드 시 에러)
public interface EmployeeMapper {

    @Mapping(source = "job.jobTitle", target = "jobTitle")
    @Mapping(source = "salary", target = "salary")
    EmployeeResponse employeeToEmployeeResponse(Employee employee);
}
