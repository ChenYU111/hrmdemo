package cn.wilmar.hrmdemo.repository;

import cn.wilmar.hrmdemo.entity.Department;
import cn.wilmar.hrmdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    @Query("select d from Department d")
    List<Department> getAllDepartment();

}
