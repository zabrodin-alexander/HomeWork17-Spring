package com.example.Employee;

import com.example.Employee.Exeption.EmployeeAlreadyAddedException;
import com.example.Employee.model.Employee;
import com.example.Employee.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class EmployeeServiceImplTest {
    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();

    @Test
    public void addEmployeeAlreadyTest() {
        //given
        String firstName = "Ivan";
        String lastName = "Ivanov";
        int salary = 1000;
        int department = 1;
        //when
        employeeService.add(firstName, lastName, salary, department);
        //then
        assertThrows(EmployeeAlreadyAddedException.class, () -> employeeService.add(firstName, lastName, salary, department));
    }

    @Test
public void correctAddEmployeeTest() {
    Employee employeeToAdd = new Employee("Ivan", "Ivanov", 1000, 1);
    Employee addedEmployee = employeeService.add(employeeToAdd.getFirstName(), employeeToAdd.getLastName(), employeeToAdd.getSalary(), employeeToAdd.getDepartment());
    assertEquals(employeeToAdd, addedEmployee);
}

    @Test
    public void employeeNotNullTest() {
        String firstName = "Ivan";
        String lastName ="Ivanov";
        int salary = 50000;
        int department = 1;
        Employee addedEmployee = employeeService.add(firstName, lastName, salary, department);
        assertNotNull(addedEmployee);
    }
}