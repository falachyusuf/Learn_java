package com.example.backendjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.backendjava.models.Departement;
import com.example.backendjava.repository.DepartementRepository;

@Controller
@RequestMapping("departement")
public class DepartementController {

    @Autowired
    private DepartementRepository departementRepository;

    // Get all data
    @GetMapping
    public String index(Model model) {
        model.addAttribute("departements", departementRepository.findAll());
        return "departement/index";
    }

    // Insert and update data
    @GetMapping(value = {"form", "form/{id}"})
    public String getForm(Model model,  @PathVariable(required = false) Integer id){
        if(id != null){
            model.addAttribute("departement", departementRepository.findById(id));
        }else{
            model.addAttribute("departement", new Departement());
        }
        return "departement/form";
    }

    @PostMapping("save")
    public String insertData(Departement departement){
        Departement newDept = departementRepository.save(departement);
        if(newDept != null){
            return "redirect:/departement";
        } else {
            return "departement/index";
        }
    }

    // Delete departement
    @PostMapping("delete/{id}")
    public String deleteData(@PathVariable(required = true) Integer id){
        departementRepository.deleteById(id);
        if(departementRepository.findById(id).isEmpty()){
            System.out.println("data deleted successfully");
        } else {
            System.out.println("data failed to be deleted");
        }
        return "redirect:/departement";
    }
}
