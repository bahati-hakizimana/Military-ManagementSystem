package com.example.military.controller;

import com.example.military.model.Batallion;
import com.example.military.model.Department;
import com.example.military.model.Soldier;
import com.example.military.serviceImplementation.BattalionServiceImplementation;
import com.example.military.serviceImplementation.DepartmentServiceImplementation;
import com.example.military.serviceImplementation.SoldierServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SoldierController {
    @Autowired
    SoldierServiceImplementation service;
    DepartmentServiceImplementation departmentService;
    BattalionServiceImplementation battalianService;



    @GetMapping("/soldier/list")
    public String displaySoldiers(Model model){
        List<Soldier> listSoldier = service.displaySoldiers();

        model.addAttribute("listSoldier", listSoldier);

        return "soldiercrud";
    }

    @GetMapping("/newsoldier")
    public String getNewSoldierForm(Model model){
        Soldier soldier = new Soldier();
        //List<Department> listDepartment = departmentService.displayDepartments();
        //List<Batallion> listBattalian = battalianService.displayBattalions();
        model.addAttribute("soldier", soldier);
        //model.addAttribute("listDepartment",listDepartment);
        //model.addAttribute("listBattalian", listBattalian);
        return "newsoldier";
    }

    @PostMapping("/soldier/save")
    public String saveSoldier(Model model, Soldier soldier, RedirectAttributes ra){

        try {
           Soldier savedSoldier = service.saveSoldier(soldier);
            model.addAttribute("soldier",savedSoldier);
            ra.addFlashAttribute("message","Soldier saved successfully");
        }catch (Exception ex){
            ex.printStackTrace();
        }


        return "redirect:/soldier/list";
    }

    @GetMapping("/soldier/edit/{id}")
    public String editEmployee(@PathVariable("id") Soldier id, Model model, RedirectAttributes ra){

        try{
            Soldier savedEmployee = service.findSolderByArmyNumber(id);
            model.addAttribute("employee", savedEmployee);
            model.addAttribute("pageTitle", "edit Soldier (ID: "+id+")");
            ra.addFlashAttribute("message", "Soldier with ID: "+id+" successfully updated");
        }catch (Exception e){
            e.printStackTrace();
        }
        return "newsoldier";
    }

    @GetMapping("/soldier/delete/{id}")
    public String deleteEmployee(@PathVariable("id") Soldier id, Model model, RedirectAttributes ra){
        try {
            service.deleteSoldier(id);
            ra.addFlashAttribute("message", "Soldier with ID " + id + " deleted successfully");

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "redirect:/employee/list";
    }

}
