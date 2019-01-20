package cn.wilmar.hrmdemo.service;

import cn.wilmar.hrmdemo.entity.Employee;
import cn.wilmar.hrmdemo.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee getEmployee(Integer id) {
        Employee one = employeeRepository.findById(id).get();
        return one;
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.getAllEmployee();
    }

    public List<Employee> getAllEmployee(String searchKey) {
        List<Employee> allEmployee;
        if (null == searchKey || searchKey.equals("")) {
            allEmployee = employeeRepository.getAllEmployee();
        } else {
            allEmployee = employeeRepository.getAllEmployeeLike("%" + searchKey + "%");
        }
        return allEmployee;
    }

    public Employee createEmployee(Employee employee) {
        employee.setEntryTime(new java.util.Date());
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> getAllEmployeeByDepartment(Integer departId) {
        return employeeRepository.getAllEmployeeByDepartment(departId);
    }

    public List<Employee> getAllEmployeeJob(Integer jobId) {
        return employeeRepository.getAllEmployeeByJob(jobId);
    }
}


