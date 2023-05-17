package com.example.military.service;

import com.example.military.model.Department;

import java.util.List;

public interface DepartmentService {
    Department saveDepartment(Department department);
    List<Department> displayDepartments();
    Department findDepartmentById(Department department);
    //Department findDepartmentByName(Department department);
    Department updateDepartment(Department department);
    void deleteDepartment(Department department);
}
