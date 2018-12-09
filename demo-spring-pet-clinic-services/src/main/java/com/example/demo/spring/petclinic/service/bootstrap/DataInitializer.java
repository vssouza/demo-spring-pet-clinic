package com.example.demo.spring.petclinic.service.bootstrap;

import com.example.demo.spring.petclinic.model.Owner;
import com.example.demo.spring.petclinic.model.Vet;
import com.example.demo.spring.petclinic.service.OwnerService;
import com.example.demo.spring.petclinic.service.VetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private static Logger logger = LoggerFactory.getLogger(DataInitializer.class.getName());

    @Autowired
    public DataInitializer(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

        ownerService.save(createOwner("Vinicius", "Yamauchi"));
        ownerService.save(createOwner("Bruno", "Noda"));
        logger.info("Loaded initial data for Owners...");

        vetService.save(createVet("Samwise", "Gangi"));
        vetService.save(createVet("Frodo", "Baggins"));
        logger.info("Loaded initial data for Vets...");

    }

    private Owner createOwner(final String firstName, final String lastName) {
        Owner owner = new Owner();
        owner.setFirstName(firstName);
        owner.setLastName(lastName);
        return owner;
    }

    private Vet createVet(final String firstName, final String lastName) {
        Vet vet = new Vet();
        vet.setFirstName(firstName);
        vet.setLastName(lastName);
        return vet;
    }

}
