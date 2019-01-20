package cn.wilmar.hrmdemo.service;

import cn.wilmar.hrmdemo.entity.Employee;
import cn.wilmar.hrmdemo.entity.Job;
import cn.wilmar.hrmdemo.repository.EmployeeRepository;
import cn.wilmar.hrmdemo.repository.JobRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobService {
    private final JobRepository jobRepository;

    public JobService(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    public Job getJob(Integer id) {
        Job one = jobRepository.findById(id).get();
        return one;
    }

    public List<Job> getAllJob() {
        return jobRepository.getAllJob();
    }

    public Job createJob(Job job) {
        return jobRepository.save(job);
    }

    public Job updateJob(Job job) {
        return jobRepository.save(job);
    }

    public void deleteJob(Integer id) {
        jobRepository.deleteById(id);
    }

    public List<Job> getAllJobByDepartId(Integer departId) {
        return jobRepository.getAllJobByDepartment(departId);
    }
}
