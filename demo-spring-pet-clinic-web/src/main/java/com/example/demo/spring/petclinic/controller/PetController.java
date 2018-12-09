package com.example.demo.spring.petclinic.controller;

import com.example.demo.spring.petclinic.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;

    @Autowired
    public PetController(final PetService petService) {
        this.petService = petService;
    }

    @RequestMapping(path={"", "/index", "/index.html"})
    public String getIndex(final Model model) {

        return "pets/index";
    }
}
