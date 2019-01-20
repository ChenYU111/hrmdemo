package cn.wilmar.hrmdemo.controller;

import cn.wilmar.hrmdemo.entity.Employee;
import cn.wilmar.hrmdemo.entity.Job;
import cn.wilmar.hrmdemo.service.JobService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JobController {
    private final JobService jobService;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @PostMapping("/jobs")
    public Job createEmployee(@RequestBody Job e) {
        return jobService.createJob(e);
    }

    @PutMapping("/jobs")
    public Job updateEmployee(@RequestBody Job e) {
        return jobService.updateJob(e);
    }

    @GetMapping("/jobs/{id}")
    public Job getOneEmployee(@PathVariable("id") Integer id) {
        return jobService.getJob(id);
    }

    @GetMapping("/jobs")
    public List<Job> getAllJob() {
        return jobService.getAllJob();
    }

    @GetMapping("/jobs/department")
    public List<Job> getAllJobByDepart(@RequestParam("departId") Integer departId) {
        return jobService.getAllJobByDepartId(departId);
    }

    @DeleteMapping("/jobs/{id}")
    public void deleteJob(@PathVariable("id") Integer id) {
        jobService.deleteJob(id);
    }
}
