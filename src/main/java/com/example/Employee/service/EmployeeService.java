package com.example.Employee.service;

import com.example.Employee.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;

public interface EmployeeService {
    Employee add(String firstName, String lastName, int salary, int departament);
    Employee remove(String firstName, String lastName, int salary, int departament);
    Employee find(String firstName, String lastName, int salary, int departament);

    Collection<Employee> findAll();
}
