package com.example.econrich.employee.mapper;

import com.example.econrich.employee.dto.EmployeeResponse;
import com.example.econrich.employee.entity.Employee;
import com.example.econrich.job.entity.Job;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-08-22T04:28:05+0900",
    comments = "version: 1.5.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public EmployeeResponse employeeToEmployeeResponse(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeeResponse employeeResponse = new EmployeeResponse();

        employeeResponse.setJobTitle( employeeJobJobTitle( employee ) );
        employeeResponse.setFirstName( employee.getFirstName() );
        employeeResponse.setLastName( employee.getLastName() );
        employeeResponse.setEmail( employee.getEmail() );
        employeeResponse.setPhoneNumber( employee.getPhoneNumber() );
        employeeResponse.setHireDate( employee.getHireDate() );

        return employeeResponse;
    }

    private String employeeJobJobTitle(Employee employee) {
        if ( employee == null ) {
            return null;
        }
        Job job = employee.getJob();
        if ( job == null ) {
            return null;
        }
        String jobTitle = job.getJobTitle();
        if ( jobTitle == null ) {
            return null;
        }
        return jobTitle;
    }
}
