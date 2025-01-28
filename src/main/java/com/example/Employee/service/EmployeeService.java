package com.example.Employee.service;

import com.example.Employee.model.Employee;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;

@Service
public interface EmployeeService {
    Employee add(String firstName, String lastName, int salary, int department);
    Employee remove(String firstName, String lastName, int salary, int department);
    Employee find(String firstName, String lastName, int salary, int department);
    Map<String, Employee> findAll();
}
