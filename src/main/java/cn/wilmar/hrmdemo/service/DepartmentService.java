package cn.wilmar.hrmdemo.service;

import cn.wilmar.hrmdemo.entity.Department;
import cn.wilmar.hrmdemo.entity.Employee;
import cn.wilmar.hrmdemo.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository departmentRepository;

    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public Department getDepartment(Integer id) {
        Department one = departmentRepository.findById(id).get();
        return one;
    }

    public List<Department> getAllDepartment() {
        return departmentRepository.getAllDepartment();
    }

    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    public Department updateDepartment(Department employee) {
        return departmentRepository.save(employee);
    }

    public void deleteDepartment(Integer id) {
        departmentRepository.deleteById(id);
    }
}
