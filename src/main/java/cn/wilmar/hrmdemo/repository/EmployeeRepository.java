package cn.wilmar.hrmdemo.repository;

import cn.wilmar.hrmdemo.entity.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query("select e from Employee e")
    List<Employee> getAllEmployee();

    @Query("select e from Employee e join Department d on e.department.id=d.id where d.id=?1")
    List<Employee> getAllEmployeeByDepartment(Integer departId);

    @Query("select e from Employee e join Job j on e.job.id=j.id where j.id=?1")
    List<Employee> getAllEmployeeByJob(Integer jobId);

    @Query("select e from Employee e where e.boss like ?1 or e.employeeName like ?1 or e.jobNum like ?1")
    List<Employee> getAllEmployeeLike(String str);


}
