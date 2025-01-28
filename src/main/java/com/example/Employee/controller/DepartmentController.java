package com.example.Employee.controller;
import com.example.Employee.model.Employee;
import com.example.Employee.service.impl.DepartmentServiceImpl;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentServiceImpl departmentService;

    public DepartmentController(DepartmentServiceImpl departmentService) {
        this.departmentService = departmentService;
    }

    @GetMapping("/{departmentId}/salary/sum")
    public int getEmployeeSalarySumByDepartment(@PathVariable int departmentId) {
        return departmentService.getEmployeeSalarySumByDepartment(departmentId);
    }

    @GetMapping("{departmentId}/salary/max")
    public Employee getMaxSalary(@PathVariable int departmentId) {
        return departmentService.getMaxSalary(departmentId);
    }

    @GetMapping("/{departmentId}/salary/min")
    public Employee getMinSalary(@PathVariable int departmentId) {
        return departmentService.getMinSalary(departmentId);
    }

    @GetMapping("/{departmentId}/employees")
    public List<Employee> getEmployeeByDepartment(@PathVariable int departmentId) {
        return departmentService.getEmployeeByDepartment(departmentId);
    }

    @GetMapping("/employees")
    public Map<Integer, List<Employee>> getAllEmployedGroupByDepartmenId() {
        return departmentService.getAllEmployeeGroupByDepartmenId();
    }
}

