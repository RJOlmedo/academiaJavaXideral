package com.rickyolmedo.employeesystem.batch.reader;

import com.rickyolmedo.employeesystem.batch.model.Employee;
import org.springframework.batch.item.ItemReader;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployeeReader implements ItemReader<Employee> {

    private List<Employee> employees = List.of(
            new Employee(1L, "John Doe", "HR"),
            new Employee(2L, "Jane Smith", "Finance")
    );
    private int index = 0;

    @Override
    public Employee read() {
        if (index < employees.size()) {
            return employees.get(index++);
        }
        return null; // End of data
    }
}
