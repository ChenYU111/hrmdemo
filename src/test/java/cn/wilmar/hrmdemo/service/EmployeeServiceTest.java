package cn.wilmar.hrmdemo.service;

import cn.wilmar.hrmdemo.entity.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class EmployeeServiceTest {
    @Autowired
    EmployeeService employeeService;

    @Test
    public void getEmployee() {
        assertEquals("li1", employeeService.getEmployee(2).getEmployeeName());
    }

    @Test
    public void getAllEmployee() {
        assertEquals(8, employeeService.getAllEmployee().size());
    }

    @Test
    public void createEmployee() {
        Employee e = new Employee();
        e.setEntryTime(new Date());
        e.setBoss("zhang1");
        e.setJobNum("00010");
        e.setSalary(new BigDecimal(10120));
        assertEquals(new BigDecimal(10120), employeeService.createEmployee(e).getSalary());
    }

    @Test
    public void getAllEmployeeByDepartment() {
        assertEquals(5, employeeService.getAllEmployeeByDepartment(1).size());
    }

    @Test
    public void getAllEmployeeJob() {
        assertEquals(2, employeeService.getAllEmployeeJob(2).size());
    }
}