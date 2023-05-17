package com.example.military.serviceImplementation;

import com.example.military.model.Department;
import com.example.military.repository.DepartmentRepository;
import com.example.military.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentServiceImplementation implements DepartmentService {
    @Autowired
    DepartmentRepository repo;
    @Override
    public Department saveDepartment(Department department) {
        return repo.save(department);
    }

    @Override
    public List<Department> displayDepartments() {
        return repo.findAll();
    }

    @Override
    public Department findDepartmentById(Department department) {
        return repo.findById(department.getDepart_no()).orElse(null);
    }


    @Override
    public Department updateDepartment(Department department) {
        Department savedDepartment = repo.findById(department.getDepart_no()).orElse(null);
        if (savedDepartment!=null){
            savedDepartment.setDepart_name(department.getDepart_name());

            return repo.save(savedDepartment);
        }else {
            return repo.save(department);
        }

    }

    @Override
    public void deleteDepartment(Department department) {
        Department savedDepartment = repo.findById(department.getDepart_no()).orElse(null);
        if (savedDepartment!=null){
            repo.delete(savedDepartment);
        }
    }
}
