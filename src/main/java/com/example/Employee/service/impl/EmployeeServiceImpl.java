package com.example.Employee.service.impl;

import com.example.Employee.Exeption.EmployeeAlreadyAddedException;
import com.example.Employee.Exeption.InvalidInputException;
import com.example.Employee.model.Employee;
import com.example.Employee.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;


@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final Map<String, Employee> employees = new HashMap<>();

    @Override
    public Employee add(String firstName, String lastName, int salary, int department) {
        String fullName = firstName + "" + lastName;
        if (!validataInput(firstName,lastName)) {

            throw new InvalidInputException();
        }
        if (employees.containsKey(fullName)) {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует");
        }
        employees.put(fullName, new Employee(firstName, lastName, salary, department));
        return employees.get(fullName);
    }

    @Override
    public Employee remove(String firstName, String lastName, int salary, int department) {
        String fullName = firstName + "" + lastName;
        if (!validataInput(firstName, lastName)) {
            throw new InvalidInputException();
        }
        return employees.remove(fullName);
    }

    @Override
    public Employee find(String firstName, String lastName, int salary, int department) {
        String fullName = firstName + "" + lastName;
        if (!validataInput(firstName, lastName)) {
            throw new InvalidInputException();
        }
        return employees.get(fullName);
    }

    @Override
    public Map<String, Employee> findAll() {
        return employees;
    }

    private boolean validataInput(String firstName, String lastName) {
        return isAlpha(firstName) && isAlpha(lastName);
    }
}
