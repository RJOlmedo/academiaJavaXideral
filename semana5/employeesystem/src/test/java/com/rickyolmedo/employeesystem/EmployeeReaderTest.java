package com.rickyolmedo.employeesystem;

import com.rickyolmedo.employeesystem.batch.model.Employee;
import com.rickyolmedo.employeesystem.batch.reader.EmployeeReader;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EmployeeReaderTest {

    @Mock
    private EmployeeReader employeeReader; // Mocked dependency

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks
    }

    @Test
    void testRead() throws Exception {
        // Given
        Employee expectedEmployee = new Employee(1L, "John Doe", "HR");
        when(employeeReader.read()).thenReturn(expectedEmployee); // Mocking the read method

        // When
        Employee actualEmployee = employeeReader.read();

        // Then
        assertEquals(expectedEmployee, actualEmployee);
    }
}
