package cn.wilmar.hrmdemo.repository;

import cn.wilmar.hrmdemo.entity.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JobRepository extends JpaRepository<Job, Integer> {
    @Query("select e from Job e")
    List<Job> getAllJob();

    @Query("select j from Job j join Department d on j.department.id = d.id where d.id=?1")
    List<Job> getAllJobByDepartment(Integer departId);
}
