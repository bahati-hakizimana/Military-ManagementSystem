package com.example.military.controller;

import com.example.military.model.Batallion;
import com.example.military.serviceImplementation.BattalionServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BattarianController {
    @Autowired
    BattalionServiceImplementation service;

    @GetMapping("/battalian/new")
    public String getBattalianForm(Model model){
        Batallion batallian = new Batallion();
        model.addAttribute("batallian", batallian);
        return "batarian";
    }

    @PostMapping("/save/battalian")
    public String saveBattalian(Model model, Batallion batallion, RedirectAttributes ra){
        Batallion savedBattalian = service.saveBattalion(batallion);
        model.addAttribute("battalian", savedBattalian);
        ra.addFlashAttribute("message", "Battalian save successfully");
        return "redirect:/batallian/list";
    }

    @GetMapping("/batallian/list")
    public String listBatallians(Model model){
        List<Batallion> listBattalian = service.displayBattalions();
        model.addAttribute("listBattalian", listBattalian);

        return "batariancrud";
    }
}
