package com.example.Employee.service.impl;

import com.example.Employee.model.Employee;
import com.example.Employee.service.DepartmentService;
import com.example.Employee.service.EmployeeService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentServiceImpl implements DepartmentService {
    private final EmployeeServiceImpl employeeService;

    public DepartmentServiceImpl(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public int getEmployeeSalarySumByDepartment(int departmentId) {
        return employeeService.findAll()
                .values()
                .stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .mapToInt(Employee::getSalary)
                .sum();
    }

    @Override
    public Employee getMaxSalary(int departmentId) {
        return employeeService.findAll()
                .values()
                .stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .max(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }


    @Override
    public Employee getMinSalary(int departmentId) {
        return employeeService.findAll()
                .values()
                .stream()
                .filter(employee -> employee.getDepartment() == departmentId)
                .min(Comparator.comparing(Employee::getSalary))
                .orElse(null);
    }


    @Override
    public List<Employee> getEmployeeByDepartment(int depratmentId) {
        return employeeService.findAll()
                .values()
                .stream()
                .filter(employee -> employee.getDepartment() == depratmentId)
                .collect(Collectors.toList());

    }

    @Override
    public Map<Integer, List<Employee>> getAllEmployeeGroupByDepartmenId() {
        return employeeService.findAll()
                .values()
                .stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
    }
}
