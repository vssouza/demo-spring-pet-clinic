package com.example.demo.spring.petclinic.controller;

import com.example.demo.spring.petclinic.model.Owner;
import com.example.demo.spring.petclinic.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Collection;
import java.util.Collections;

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

    @GetMapping("/{ownerId}")
    public ModelAndView getOwner(@PathVariable ("ownerId") Long ownerId) {
        ModelAndView modelAndView = new ModelAndView("owners/ownerDetails");
        modelAndView.addObject(this.ownerService.findById(ownerId));
        return modelAndView;
    }

    @GetMapping("/find")
    public String initFindForm(final Model model) {
        model.addAttribute("owner", Owner.builder().build());
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

    @GetMapping("/new")
    public String initCreationForm(final Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/new")
    public String processCreationForm(@Valid final Owner owner, final BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "owners/createOrUpdateOwnerForm";
        }
        else {
            owner.setPets(Collections.EMPTY_SET);
            Owner savedOwner = this.ownerService.save(owner);
            return String.format("redirect:/owners/%d", savedOwner.getId());
        }
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateForm(@PathVariable final Long ownerId, final Model model) {
        model.addAttribute("owner", this.ownerService.findById(ownerId));
        return "owners/createOrUpdateOwnerForm";
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateForm(@PathVariable final Long ownerId, @Valid final Owner owner, final BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "owners/createOrUpdateOwnerForm";
        }
        else {
            owner.setId(ownerId);
            owner.setPets(this.ownerService.findById(ownerId).getPets());
            this.ownerService.save(owner);
            return String.format("redirect:/owners/%d", owner.getId());
        }
    }
}
