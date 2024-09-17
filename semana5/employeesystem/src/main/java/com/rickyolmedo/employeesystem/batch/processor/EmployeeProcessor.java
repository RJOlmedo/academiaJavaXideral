package com.rickyolmedo.employeesystem.batch.processor;

import com.rickyolmedo.employeesystem.batch.model.Employee;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class EmployeeProcessor implements ItemProcessor<Employee, Employee> {

    @Override
    public Employee process(Employee employee) {
        // Convert name to uppercase
        employee.setName(employee.getName().toUpperCase());
        return employee;
    }
}
