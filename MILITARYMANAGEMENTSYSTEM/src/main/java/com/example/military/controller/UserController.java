package com.example.military.controller;

import com.example.military.model.UserModel;
import com.example.military.serviceImplementation.UserServiceImplementation;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserServiceImplementation service;

    @GetMapping("/login")
    public String getLoginPage(Model model) {
        UserModel user = new UserModel();
        model.addAttribute("user", user);

        return "login";
    }
    @PostMapping("/login")
    public String login(UserModel user, Model model, RedirectAttributes ra){
        UserModel savedUser = service.findUserbyarmynunber(user);
        if (savedUser!=null){
            if (savedUser.getArmy_number()==123456){
                if (savedUser.getPassword().equals(user.getPassword())){
                    return "adminPernal";
                }else {
                    ra.addFlashAttribute("message", "wrong password");
                    return "redirect:/login";
                }
            }
            else {
                if (savedUser.getArmy_number()==user.getArmy_number()){
                    if (savedUser.getPassword().equals(user.getPassword())){
                        return "userPage";
                    }else {
                        ra.addFlashAttribute("message", "wrong password");
                        return "redirect:/login";
                    }
                }else {
                    ra.addFlashAttribute("message", "invalid credential");
                    return "redirect:/login";
                }
            }
        }
        ra.addFlashAttribute("message", "Try again");

//        user.setArmy_number(0);
//        user.setPassword("");
        return "";
    }



    @GetMapping("/signup")
    public String getSignupPage(Model model) {
        UserModel user = new UserModel();
        model.addAttribute("user", user);

        return "signup";
    }
    @PostMapping("/signup")
    public String signupForm(UserModel user, Model model, RedirectAttributes ra){

        try{
            UserModel savedUser = service.saveUser(user);
            model.addAttribute("user", savedUser);

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return "redirect:/login";
    }



}
