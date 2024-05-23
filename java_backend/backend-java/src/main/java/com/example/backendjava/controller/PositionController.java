package com.example.backendjava.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.backendjava.models.Position;
import com.example.backendjava.repository.PositionRepository;

@Controller
@RequestMapping("position")
public class PositionController {
    @Autowired
    private PositionRepository positionRepository;
    // Get all data
    @GetMapping
    public String index(Model model){
        model.addAttribute("positions", positionRepository.findAll());
        return "position/index";
    }
    // Insert data and update data
    @GetMapping(value = {"form","form/{id}"})
    public String form(Model model, @PathVariable(required = false)Integer id){
        if(id != null){
            model.addAttribute("position", positionRepository.findById(id));
        } else {
            model.addAttribute("position", new Position());
        }
        return "position/form";
    }

    @PostMapping("save")
    public String insertPosition(Position position){
        Position newPosition = positionRepository.save(position);
        if(newPosition != null){
            return "redirect:/position";
        }else{
            return "position/index";
        }
    }

    // Delete data
    @PostMapping("delete/{id}")
    public String deletePosition(@PathVariable(required = true) Integer id){
        positionRepository.deleteById(id);
        Boolean isDeleted = positionRepository.findById(id).isEmpty();
        if(isDeleted){
            System.out.println("data deleted");
        } else {
            System.out.println("failed to delete data");
        }
        return "redirect:/position";
    }

}
