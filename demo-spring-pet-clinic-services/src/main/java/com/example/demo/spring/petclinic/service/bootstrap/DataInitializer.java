package com.example.demo.spring.petclinic.service.bootstrap;

import com.example.demo.spring.petclinic.model.Owner;
import com.example.demo.spring.petclinic.model.Vet;
import com.example.demo.spring.petclinic.service.OwnerService;
import com.example.demo.spring.petclinic.service.VetService;
import com.example.demo.spring.petclinic.service.map.OwnerMapService;
import com.example.demo.spring.petclinic.service.map.VetMapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private static Logger logger = LoggerFactory.getLogger(DataInitializer.class.getName());


    public DataInitializer() {
        ownerService = new OwnerMapService();
        vetService = new VetMapService();
    }

    @Override
    public void run(String... args) throws Exception {

        ownerService.save(createOwner(1L, "Vinicius", "Yamauchi"));
        ownerService.save(createOwner(2L, "Bruno", "Noda"));
        logger.info("Loaded initial data for Owners...");

        vetService.save(createVet(1L, "Samwise", "Gangi"));
        vetService.save(createVet(2L, "Frodo", "Baggins"));
        logger.info("Loaded initial data for Vets...");

    }

    private Owner createOwner(final long id, final String firstName, final String lastName) {
        Owner owner = new Owner();
        owner.setId(id);
        owner.setFirstName(firstName);
        owner.setLastName(lastName);
        return owner;
    }

    private Vet createVet(final long id, final String firstName, final String lastName) {
        Vet vet = new Vet();
        vet.setId(id);
        vet.setFirstName(firstName);
        vet.setLastName(lastName);
        return vet;
    }

}
