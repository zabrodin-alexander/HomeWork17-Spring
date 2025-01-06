package com.example.Employee.controller;

import com.example.Employee.model.Employee;
import com.example.Employee.service.EmployeeService;
import com.example.Employee.service.EmployeeServiceImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;


@RestController
@RequestMapping("/employee")
public class EmpolyeeController {
    final private EmployeeService service;

    public EmpolyeeController(EmployeeServiceImpl service) {
        this.service = service;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int salary, @RequestParam int departament) {
        return service.add(firstName, lastName, salary, departament);
    }

    @GetMapping("/remove")
    public Employee removeEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int salary, @RequestParam int departament) {
        return service.remove(firstName, lastName, salary, departament);
    }

    @GetMapping("/find")
    public Employee finfEmployee(@RequestParam String firstName, @RequestParam String lastName, @RequestParam int salary, @RequestParam int departament) {
        return service.find(firstName, lastName, salary, departament);
    }

    @GetMapping
    public Collection<Employee> findAll() {
        return service.findAll();
    }

}


