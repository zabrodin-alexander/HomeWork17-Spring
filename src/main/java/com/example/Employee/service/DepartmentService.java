package com.example.Employee.service;

import com.example.Employee.model.Employee;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class DepartmentService {
    Employee employee;

    private Map<String, Employee> employees = new HashMap<>();
    //Создаем Map(словарь сотрудников) с типом данных, String это ключ (Фамилия сотрудника), Employee - содержит информацию о сотруднике

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employees.values());
    }

    public void addTestData() {
        employees.put("Иванов", new Employee("Иван", "Иванов", 1, 50000));
        employees.put("Петров", new Employee("Петр", "Петров", 1, 35000));
        employees.put("Сидоров", new Employee("Егор", "Сидоров", 2, 45000));
        employees.put("Михайлов", new Employee("Михаил", "Михайлов", 2, 35000));
        employees.put("Алексеев", new Employee("Алексей", "Алексеев", 3, 25000));
        employees.put("Федоров", new Employee("Олег", "Федоров", 4, 70000));
    }

    public List<Employee> getEmployeesByDepartmentId(int departmentId) {//Создаем публичный метод всех сотрудников по департаменту,
        // который возвращет список и принимает параметр departmentId.
        List<Employee> result = new ArrayList<>();//Создаем список result, который будет добавлять сотрудника по департаменту.
        for (Employee employee : employees.values()) {//Запускаем цикл, который проходит по каждому элементу коллекции employees. Метод values - возвращает коллекцию всех значений из Map.
            if (employee.getDepartment() == (departmentId)) {//Добавляем условный оператор, который сравнивает совпадает ли departmentId с переданным.
                result.add(employee);// Если условие истина, то сотрудник добавляется в список result
            }
        }
        return result;//Возвращаем результат списком
    }

    public Integer getSalaryByDepartmentId(Integer departmentId) {
        int sum = 0;
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == (departmentId)) {
                sum += employee.getSalary();
            }
        }
        return sum;
    }

    public Integer getSalaryMaxByDepartmentId(Integer departmentId) {
        int maxSalary = Integer.MIN_VALUE;
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == (departmentId)) {
                if (employee.getSalary() > maxSalary)
                    maxSalary = employee.getSalary();
            }
        }
        return maxSalary;
    }

    public Integer getSalaryMinByDepartmentId(Integer departmentId) {
        int minSalary = Integer.MAX_VALUE;
        for (Employee employee : employees.values()) {
            if (employee.getDepartment() == (departmentId)) {
                if (employee.getSalary() < minSalary) {
                    minSalary = employee.getSalary();
                }
            }
        }
        return minSalary;
    }

    public Map<Integer, List<Employee>> getEmployeesGroupedByDepartment() {
        Map<Integer, List<Employee>> all = new HashMap<>();
        for (Employee employee : employees.values()) {
            all.computeIfAbsent(employee.getDepartment(), k -> new ArrayList<>())
                    .add(employee);
        }
        return all;
    }
}





