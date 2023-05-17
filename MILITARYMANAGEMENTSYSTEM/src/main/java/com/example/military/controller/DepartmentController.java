package com.example.military.controller;

import com.example.military.model.Department;
import com.example.military.serviceImplementation.DepartmentServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class DepartmentController {
    @Autowired
    DepartmentServiceImplementation service;

    @GetMapping("/department/new")
    public String showDepartmentForm(Model model){
        Department department = new Department();
        model.addAttribute("department", department);

        return "department";
    }
    @PostMapping("/department/save")
    public String saveDepartment(Model model, Department department, RedirectAttributes ra) {
        try {
            Department savedDepartment = service.saveDepartment(department);
            model.addAttribute("department", department);
            ra.addFlashAttribute("message", "Department saved successfully");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "redirect:/department/list";
    }

    @GetMapping("/department/list")
    public String displayDepartments(Model model){
        List<Department> listDepartment = service.displayDepartments();
        model.addAttribute("listDepartment", listDepartment);
        return "departmentcrud";
    }
}
