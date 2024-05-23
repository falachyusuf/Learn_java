package com.example.backendjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.backendjava.models.Employee;
import com.example.backendjava.models.User;
import com.example.backendjava.repository.UserRepository;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @GetMapping
    public String index(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "user/index";
    }

    @GetMapping(value = {"form", "form/{id}"})
    public String getForm(Model model, @PathVariable(required = false) Integer id){
        if(id != null){
            model.addAttribute("user", userRepository.findById(id).orElse(new User()));
        }else{
            model.addAttribute("user", new User());
        }
        return "user/form";
    }
    @PostMapping("save")
    public String insertUser(User user){
        User newUser = userRepository.save(user);
        if(newUser != null){
            userRepository.save(user);
            return "redirect:/user";
        }else{
            return "user/index";
        }
    }

    @PostMapping("delete/{id}")
    public String deleteById(@PathVariable(required = true) Integer id){
        try {
            userRepository.deleteById(id);
            Boolean isDeleted = userRepository.findById(id).isEmpty();
            if(isDeleted){
                System.out.println("data deleted");
            } else {
                System.out.println("failed to delete data");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/user";
    }
}
