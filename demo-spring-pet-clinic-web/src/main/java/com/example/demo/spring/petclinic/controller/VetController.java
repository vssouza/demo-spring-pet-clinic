package com.example.demo.spring.petclinic.controller;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.spring.petclinic.model.Vet;
import com.example.demo.spring.petclinic.service.VetService;

@Controller
@RequestMapping("/vets")
public class VetController {

    private final VetService vetService;

    @Autowired
    public VetController(final VetService vetService) {
        this.vetService = vetService;
    }

    @RequestMapping(path = {"/index", "/index.html" })
    public String getVets(final Model model) {
        model.addAttribute("vets", vetService.findAll());
        return "vets/index";
    }

    @GetMapping(path = "")
    public @ResponseBody Set<Vet> getVetsJson() {
        return vetService.findAll();
    }
}
