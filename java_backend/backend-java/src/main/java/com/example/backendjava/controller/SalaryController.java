package com.example.backendjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.backendjava.models.Salary;
import com.example.backendjava.repository.SalaryRepository;

@Controller
@RequestMapping("salary")
public class SalaryController {
    @Autowired
    private SalaryRepository salaryRepository;

    @GetMapping
    public String index(Model model){
        model.addAttribute("salaries", salaryRepository.findAll());
        return "salary/index";
    }

    @GetMapping(value = {"form", "form/{id}"})
    public String getForm(Model model, @PathVariable(required = false) Integer id){
        if(id != null){
            model.addAttribute("salary", salaryRepository.findById(id));
        } else {
            model.addAttribute("salary", new Salary());
        }
        return "salary/form";
    }

    @PostMapping("save")
    public String insertSalary(Salary salary){
        Salary newSalary = salaryRepository.save(salary);
        if(newSalary != null){
            return "redirect:/salary";
        }
        return "position/index";
    }

    @PostMapping("delete/{id}")
    public String deleteSalary(@PathVariable(required = true) Integer id){
        salaryRepository.deleteById(id);
        Boolean isDeleted = salaryRepository.findById(id).isEmpty();
        if (isDeleted) {
            System.out.println("data deleted");
        } else {
            System.out.println("failed to delete data");
        }
        return "redirect:/salary";
    }
}
