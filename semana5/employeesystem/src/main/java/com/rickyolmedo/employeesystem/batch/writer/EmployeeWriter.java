package com.rickyolmedo.employeesystem.batch.writer;

import com.rickyolmedo.employeesystem.batch.model.Employee;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

@Component
public class EmployeeWriter implements ItemWriter<Employee> {

    @Override
    public void write(Chunk<? extends Employee> employees) throws Exception {
        employees.forEach(System.out::println);
    }
}

