package com.example.military.repository;

import com.example.military.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    //Department findByNo(Department department);

    //Department findByDepat_name(Department department);
}
