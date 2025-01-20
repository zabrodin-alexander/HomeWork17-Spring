package com.example.Employee.service;

import com.example.Employee.Exeption.InvalidInputException;
import com.example.Employee.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

import static org.apache.commons.lang3.StringUtils.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private  Map<String, Employee> employees;

    public void EmployeeService() {
        employees = new HashMap<>();
    }

    @Override
    public Employee add(String firstName, String lastName, int salary, int departament) {
        if (!validataInput(firstName, lastName)) {
            throw new InvalidInputException();
        }
        return null;
    }

    @Override
    public Employee remove(String firstName, String lastName, int salary, int departament) {
        if (!validataInput(firstName, lastName)) {
            throw new InvalidInputException();
        }
        return null;
    }

    @Override
    public Employee find(String firstName, String lastName, int salary, int departament) {
        if (!validataInput(firstName, lastName)) {
            throw new InvalidInputException();
        }
        return null;
    }

    @Override
    public Collection<Employee> findAll() {
        return List.of();
    }

    private boolean validataInput(String firstName, String lastName) {
        return isAlpha(firstName) && isAlpha(lastName);
    }


}
