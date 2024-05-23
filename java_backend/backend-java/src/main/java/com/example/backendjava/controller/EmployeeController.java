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
import com.example.backendjava.repository.DepartementRepository;
import com.example.backendjava.repository.EmployeeRepository;
import com.example.backendjava.repository.PositionRepository;
import com.example.backendjava.repository.UserRepository;

@Controller
@RequestMapping("employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PositionRepository positionRepository;

    @Autowired
    private DepartementRepository departementRepository;

    @Autowired
    private UserRepository userRepository;

    // Get all employees
    @GetMapping
    public String index (Model model){
        model.addAttribute("employees", employeeRepository.findAll());
        return "employee/index";
    }

    // Delete employees
    @PostMapping("delete/{id}")
    public String deleteById(@PathVariable(required = true) Integer id){
        try {
            employeeRepository.deleteById(id);
            Boolean isDeleted = employeeRepository.findById(id).isEmpty();
            if(isDeleted){
                System.out.println("data deleted");
            } else {
                System.out.println("failed to delete data");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "redirect:/employee";
    }

     @GetMapping(value = {"form", "form/{id}"})
    public String form(Model model, @PathVariable(required = false) Integer id){
        if(id != null){
            model.addAttribute("employee", employeeRepository.findById(id));
        }else{
            model.addAttribute("employee", new Employee());
        }
        model.addAttribute("positionOptions", positionRepository.findAll());
        model.addAttribute("departementOptions", departementRepository.findAll());
        return "employee/form";
    }

    @PostMapping("save")
    public String insertPosition(Employee employee, User user){
        Employee newEmp = employeeRepository.save(employee);
        if(newEmp != null){
            Integer userId = newEmp.getId();
            user.setId(userId);
            userRepository.save(user);
            return "redirect:/user/form/" + userId;
        }else{
            return "employee/index";
        }
    }

    
}
