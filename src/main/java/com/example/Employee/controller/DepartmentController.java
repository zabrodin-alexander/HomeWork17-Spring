package com.example.Employee.controller;

import com.example.Employee.model.Employee;
import com.example.Employee.service.DepartmentService;
import com.example.Employee.service.EmployeeService;
import com.example.Employee.service.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/department")
public class DepartmentController {
    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping(path = "/add-data")
    public void addTestData() {
        departmentService.addTestData();
    }

    @GetMapping("/{id}/employees")
//Аннотация которая указывает, что метод будет обрабатывать GET-запросы по указанному пути.
    //и содержит динамическую часть {id}, которая будет заменена на конкретное значение.
    public List<Employee> getEmployeesByDepartmentId(@PathVariable int id) {//Метод получения всех сотрудников по департаменту.
        //Метод принимает параметр число, а Аннотация @PathVariable извлекате его и связывает с методом
        return departmentService.getEmployeesByDepartmentId(id);//возвращаем метод получения всех сотрудников по департаменту из сервиса(где заложена вся логика
        //и принимает парамет Id, который используется для поиска сотрудника по департаменту
    }

    @GetMapping("/{id}/salary/sum")
    public Integer getSalaryByDepartmentId(@PathVariable Integer id) {
        return departmentService.getSalaryByDepartmentId(id);
    }

    @GetMapping("{id}/salary/max")
    public Integer getSalaryMaxByDepartmentId(@PathVariable Integer id) {
        return departmentService.getSalaryMaxByDepartmentId(id);
    }

    @GetMapping("{id}/salary/min")
    public Integer getSalaryMinByDepartmentId(@PathVariable Integer id) {
        return departmentService.getSalaryMinByDepartmentId(id);
    }

    @GetMapping("employees")
    public Map<Integer, List<Employee>> getEmployeesGroupedByDepartment() {
        return departmentService.getEmployeesGroupedByDepartment();
    }
}
