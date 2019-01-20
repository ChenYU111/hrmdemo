package cn.wilmar.hrmdemo.controller;

import cn.wilmar.hrmdemo.entity.Employee;
import cn.wilmar.hrmdemo.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/employees")
    public Employee createEmployee(@RequestBody Employee e) {
        return employeeService.createEmployee(e);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee e) {
        return employeeService.updateEmployee(e);
    }

    @GetMapping("/employees/search")
    public List<Employee> getEmployeeBySearchKey(@RequestParam(value = "searchKey", required = false) String searchKey) {
        return employeeService.getAllEmployee(searchKey);

    }

    @GetMapping("/employees/{id}")
    public Employee getOneEmployee(@PathVariable("id") Integer id) {
        return employeeService.getEmployee(id);
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/employees/department")
    public List<Employee> getAllEmployeeByDepartId(@RequestParam("departId") Integer departId) {
        return employeeService.getAllEmployeeByDepartment(departId);
    }

    @GetMapping("/employees/job")
    public List<Employee> getAllEmployeeByJob(@RequestParam("jobId") Integer jobId) {
        return employeeService.getAllEmployeeJob(jobId);
    }

    @DeleteMapping("/employees/{id}")
    public void deleteEmployee(@PathVariable("id") Integer id) {
        employeeService.deleteEmployee(id);
    }


}
