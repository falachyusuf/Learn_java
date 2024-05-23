package com.example.backendjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.backendjava.models.Employee;
import com.example.backendjava.models.Salary;
import com.example.backendjava.models.TotalSalary;
import com.example.backendjava.models.User;
import com.example.backendjava.repository.EmployeeRepository;
import com.example.backendjava.repository.SalaryRepository;
import com.example.backendjava.repository.TotalSalaryRepository;

@Controller
@RequestMapping("totalsalary")
public class TotalSalaryController {
    @Autowired
    private TotalSalaryRepository totalSalaryRepository;

    @Autowired
    private SalaryRepository salaryRepository;

    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping
    public String index(Model model){
        model.addAttribute("totalsalaries", totalSalaryRepository.findAll());
        return "totalsalary/index";
    }

    @GetMapping(value = {"form", "form/{id}"})
    public String form(Model model, @PathVariable(required = false) Integer id){
        if(id != null){
            model.addAttribute("totalsalary", totalSalaryRepository.findById(id));
        }else{
            model.addAttribute("totalsalary", new TotalSalary());
        }
        model.addAttribute("salaryOptions", salaryRepository.findAll());
        model.addAttribute("employeeOptions", employeeRepository.findAll());
        return "totalsalary/form";
    }

    @PostMapping("save")
    public String insertTotal(TotalSalary totalSalary){
            Integer total = totalSalary.getSalary().getBaseSalary() + totalSalary.getSalary().getBonus();
            totalSalary.setTotalSalary(total);
            totalSalaryRepository.save(totalSalary);
            return "redirect:/totalsalary";

    }
}
