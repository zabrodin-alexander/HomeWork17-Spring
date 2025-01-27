package com.example.Employee;
import com.example.Employee.model.Employee;
import com.example.Employee.service.impl.DepartmentServiceImpl;
import com.example.Employee.service.impl.EmployeeServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class DepartmenServiceImplTest {

    @Mock
    private EmployeeServiceImpl employeeService;

    @InjectMocks
    private DepartmentServiceImpl departmentService;

    private final Map<String, Employee> employees = new HashMap<>() {{
        put("IvanIvanov", new Employee("Ivan", "Ivanov", 50000, 1));
        put("PetrPetrov", new Employee("Petr", "Petrov", 100000, 1));
        put("OlegSidorov", new Employee("Oleg", "Sidorov", 150000, 1));
    }};

    @Test
    public void correctSumSalaryByDepartment() {
        //given(Дано)
        int departmentId = 1;
        int expectedSum = 300000;
        Mockito.when(employeeService.findAll()).thenReturn(employees);
        //when(Когда)
        int actualSum = departmentService.getEmployeeSalarySumByDepartment(departmentId);
        //then(Тогда)
        assertEquals(expectedSum, actualSum);
    }

    @Test
    public void maxSalaryEmployeeByDepartment() {
        int departmentId = 1;
        Employee expectedEmployee = employees.get("OlegSidorov");
        Mockito.when(employeeService.findAll()).thenReturn(employees);
        Employee actualEmployee = departmentService.getMaxSalary(departmentId);
        assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    public void minSalaryEmployeeByDepartment() {
        int departmentId = 1;
        Employee expectedEmployee = employees.get("IvanIvanov");
        Mockito.when(employeeService.findAll()).thenReturn(employees);
        Employee actualEmployee = departmentService.getMinSalary(departmentId);
        assertEquals(expectedEmployee, actualEmployee);
    }

    @Test
    public void correctEmployeeByDepartment() {
        //given
        int departmentId = 1;
        Collection<Employee> expectedEmployees = new ArrayList<>(employees.values());
        Mockito.when(employeeService.findAll()).thenReturn(employees);
        //when
        List<Employee> actualEmployees = departmentService.getEmployeeByDepartment(departmentId);
        //then
        assertEquals(expectedEmployees, actualEmployees);
    }

    @Test
    public void correctEmployeeGroupByDepartment() {
        //given
        int departmentId = 1;
        Map<Integer, List<Employee>> expectedEmployees = new HashMap<>() {{
            put(1, new ArrayList<>(employees.values()));
        }};
        Mockito.when(employeeService.findAll()).thenReturn(employees);
        //when
        Map<Integer, List<Employee>> actualEmployees = departmentService.getAllEmployeeGroupByDepartmenId();
        //then
        assertEquals(expectedEmployees, actualEmployees);
    }
}
