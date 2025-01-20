package com.example.Employee;

import com.example.Employee.Exeption.InvalidInputException;
import com.example.Employee.model.Employee;
import com.example.Employee.service.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceImplTest {

    @Test
    public void addTest() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        assertDoesNotThrow(() -> employeeService.add("Иван", "Петров", 50000, 1));
    }

    @Test
    public void addTestName() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        assertThrows(InvalidInputException.class, () -> employeeService.add("", "Петров", 50000, 1));
    }

    @Test
    void addCorrectEmployeeTest() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        Employee result = employeeService.add("Иван", "Петров", 46460, 1);
        assertNull(result);
    }

    @Test
    public void removeTest() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        assertDoesNotThrow(() -> employeeService.remove("Иван", "Петров", 50000, 1));
    }

    @Test
    public void findTest() {
        EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
        assertDoesNotThrow(() -> employeeService.find("Иван", "Петров", 50000, 1));
    }
}
