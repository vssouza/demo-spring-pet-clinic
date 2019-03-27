package com.example.demo.spring.petclinic.service.bootstrap;

import com.example.demo.spring.petclinic.model.*;
import com.example.demo.spring.petclinic.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;

@Component
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    @Autowired
    public DataInitializer(final OwnerService ownerService, final VetService vetService, final PetTypeService petTypeService,
                           final SpecialityService specialityService, final VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        if(petTypeService.findAll().size() == 0) {
            loadInMemoryData();
        }
    }

    private void loadInMemoryData() {
        Speciality radiology = specialityService.save(createSpeciality("Radiology"));
        Speciality surgery = specialityService.save(createSpeciality("Surgery"));
        Speciality dentistry = specialityService.save(createSpeciality("Dentistry"));

        vetService.save(createVet("Samwise", "Gangi", radiology, surgery));
        vetService.save(createVet("Frodo", "Baggins", surgery, dentistry));
        vetService.save(createVet("Merry", "Peppins"));
        log.info("Loaded initial data for Vets...");

        PetType dogType = petTypeService.save(createPetType("Dog"));
        PetType catType = petTypeService.save(createPetType("Cat"));
        log.info("Loaded initial data for Pet Types...");

        Pet harley = createPet("Harley", LocalDate.of(2016, 07, 23),  catType);
        Pet minho = createPet("Minho", LocalDate.of(2017, 03, 12), dogType);
        Pet doe = createPet("Doe", LocalDate.of(2019, 11,15), dogType);

        ownerService.save(createOwner("Vinicius", "Yamauchi", "Hophill vale", "Tullamore", harley, minho));
        ownerService.save(createOwner("Bruno", "Noda", "Onze de Junho", "Sao Paulo", doe));
        log.info("Loaded initial data for Owners...");
        log.info("Loaded initial data for Pets...");

        visitService.save(createVisit(harley, LocalDate.of(2019, Month.DECEMBER, 8), "Annual Checkup."));
        visitService.save(createVisit(minho, LocalDate.of(2019, Month.APRIL, 13), "Acunpucture session"));
        visitService.save(createVisit(minho, LocalDate.of(2019, Month.MAY, 13), "Acunpucture session"));
        visitService.save(createVisit(minho, LocalDate.of(2019, Month.JUNE, 13), "Acunpucture session"));
        visitService.save(createVisit(doe, LocalDate.of(2019, Month.SEPTEMBER, 21), "Surgery"));
        visitService.save(createVisit(doe, LocalDate.of(2019, Month.NOVEMBER, 25), "Checkup"));
        log.info("Loaded initial data for Visits...");
    }

    private Visit createVisit(final Pet pet, final LocalDate date, final String description) {
        Visit visit = new Visit();
        visit.setPet(pet);
        visit.setDate(date);
        visit.setDescription(description);
        return visit;
    }

    private Speciality createSpeciality(final String description) {
        Speciality speciality = new Speciality();
        speciality.setDescription(description);
        return speciality;
    }

    private Owner createOwner(final String firstName, final String lastName, final String address, final String city, final Pet... pets) {
        Owner owner = Owner.builder()
                .firstName(firstName)
                .lastName(lastName)
                .address(address)
                .city(city)
                .build();
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
