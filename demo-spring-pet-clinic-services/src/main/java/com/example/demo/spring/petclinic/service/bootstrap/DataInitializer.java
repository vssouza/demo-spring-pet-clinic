package com.example.demo.spring.petclinic.service.bootstrap;

import com.example.demo.spring.petclinic.model.*;
import com.example.demo.spring.petclinic.service.OwnerService;
import com.example.demo.spring.petclinic.service.PetTypeService;
import com.example.demo.spring.petclinic.service.SpecialityService;
import com.example.demo.spring.petclinic.service.VetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private static Logger logger = LoggerFactory.getLogger(DataInitializer.class.getName());

    @Autowired
    public DataInitializer(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
    }

    @Override
    public void run(String... args) throws Exception {

        if(petTypeService.findAll().size() == 0) {
            loadInMemoryData();
        }
    }

    private void loadInMemoryData() {
        Speciality radiology = createSpeciality("Radiology");
        Speciality surgery = createSpeciality("Surgery");
        Speciality dentistry = specialityService.save(createSpeciality("Dentistry"));

        vetService.save(createVet("Samwise", "Gangi", radiology, surgery));
        vetService.save(createVet("Frodo", "Baggins", surgery, dentistry));
        vetService.save(createVet("Merry", "Peppins"));
        logger.info("Loaded initial data for Vets...");

        PetType dogType = petTypeService.save(createPetType("Dog"));
        PetType catType = petTypeService.save(createPetType("Cat"));
        logger.info("Loaded initial data for Pet Types...");

        Pet harley = createPet("Harley", LocalDate.of(2016, 07, 23),  catType);
        Pet minho = createPet("Minho", LocalDate.of(2017, 03, 12), dogType);
        Pet doe = createPet("Doe", LocalDate.of(2019, 11,15), dogType);
        logger.info("Loaded initial data for Pets...");

        ownerService.save(createOwner("Vinicius", "Yamauchi", "Hophill vale", "Tullamore", harley, minho));
        ownerService.save(createOwner("Bruno", "Noda", "Onze de Junho", "Sao Paulo", doe));
        logger.info("Loaded initial data for Owners...");
    }

    private Speciality createSpeciality(final String description) {
        Speciality speciality = new Speciality();
        speciality.setDescription(description);
        return speciality;
    }

    private Owner createOwner(final String firstName, final String lastName, final String address, final String city, final Pet... pets) {
        Owner owner = new Owner();
        owner.setFirstName(firstName);
        owner.setLastName(lastName);
        owner.setAddress(address);
        owner.setCity(city);
        for(Pet pet : pets) {
            owner.getPets().add(pet);
        }
        return owner;
    }

    private Vet createVet(final String firstName, final String lastName, Speciality... specialities) {
        Vet vet = new Vet();
        vet.setFirstName(firstName);
        vet.setLastName(lastName);
        if(specialities != null) {
            for(Speciality speciality : specialities) {
                vet.getSpecialities().add(speciality);
            }
        }
        return vet;
    }

    private PetType createPetType(final String name) {
        PetType petType = new PetType();
        petType.setName(name);
        return petType;
    }

    private Pet createPet(final String name, final LocalDate birthdate, final PetType petType) {
        Pet pet = new Pet();
        pet.setName(name);
        pet.setBirthDate(birthdate);
        pet.setPetType(petType);
        return pet;
    }

}
