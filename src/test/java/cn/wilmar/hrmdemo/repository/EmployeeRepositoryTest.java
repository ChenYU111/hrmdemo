package cn.wilmar.hrmdemo.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepositoryTest {

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    public void getAllEmployee() {
        assertEquals(7, employeeRepository.getAllEmployee().size());
    }

    @Test
    public void getAllEmployeeByDepartment() {
        assertEquals(2, employeeRepository.getAllEmployeeByDepartment(2).size());
    }

    @Test
    public void getAllEmployeeByJob() {
        assertEquals(2, employeeRepository.getAllEmployeeByJob(2).size());
    }

    @Test
    public void getAllEmployeeLike() {
        String str = "%" + 0001 + "%";
        assertEquals(7, employeeRepository.getAllEmployeeLike(str).size());
    }
}