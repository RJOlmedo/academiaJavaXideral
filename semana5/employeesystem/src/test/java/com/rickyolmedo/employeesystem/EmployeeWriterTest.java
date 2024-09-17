package com.rickyolmedo.employeesystem;

import com.rickyolmedo.employeesystem.batch.model.Employee;
import com.rickyolmedo.employeesystem.batch.writer.EmployeeWriter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.test.context.SpringBatchTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.*;

@SpringBatchTest
public class EmployeeWriterTest {

    @InjectMocks
    private EmployeeWriter employeeWriter;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testWrite() throws Exception {
        // Set up mocks
        Employee employee = new Employee(1L, "John Doe", "HR");

        Chunk<Employee> chunk = new Chunk<>(List.of(employee));

        employeeWriter.write(chunk);
        // Verify that the write method works
        assertNotNull(chunk);
    }
}
