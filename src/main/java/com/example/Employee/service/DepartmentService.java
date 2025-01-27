package com.example.Employee.service;

import com.example.Employee.model.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentService {
    int getEmployeeSalarySumByDepartment(int departmentId);

    Employee getMinSalary(int departmentId);
    Employee getMaxSalary(int departmentId);

    List<Employee> getEmployeeByDepartment(int departmentId);

    Map<Integer, List<Employee>> getAllEmployeeGroupByDepartmenId();
}
