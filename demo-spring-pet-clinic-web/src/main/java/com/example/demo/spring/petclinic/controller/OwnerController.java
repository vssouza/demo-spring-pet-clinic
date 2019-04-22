package com.example.demo.spring.petclinic.controller;

import com.example.demo.spring.petclinic.model.Owner;
import com.example.demo.spring.petclinic.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Collection;

@Controller
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    @Autowired
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    /*
     * We don't want web forms to have access to ID field
     */
    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping(path={"", "/index", "/index.html"})
    public String listOwners(final Model model) {
        model.addAttribute("owners", ownerService.findAll());
        return "owners/index";
    }

    @GetMapping("/{ownerId}")
    public ModelAndView getOwner(@PathVariable ("ownerId") Long ownerId) {
        ModelAndView modelAndView = new ModelAndView("owners/ownerDetails");
        modelAndView.addObject(this.ownerService.findById(ownerId));
        return modelAndView;
    }

    @GetMapping("/find")
    public String initFindForm(final Model model) {
        model.addAttribute("owner", new Owner());
        return "owners/findOwners";
    }

    @GetMapping(path = {"", "/"})
    public String processFindForm(final Owner owner, final BindingResult bindingResult, final Model model) {
        // Empty string is the broadest type of search possible
        owner.setLastName(owner.getLastName() == null ? "" : owner.getLastName());

        // Find owners by last name
        Collection<Owner> result = this.ownerService.findByLastNameLike(owner.getLastName());
        if(result.isEmpty()) {
            bindingResult.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        }
        else {
            model.addAttribute("selections", result);
        }
        return "owners/ownersList";
    }
}
