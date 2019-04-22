package com.example.demo.spring.petclinic.formatter;

import com.example.demo.spring.petclinic.model.PetType;
import com.example.demo.spring.petclinic.service.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    @Override
    public PetType parse(String text, Locale locale) throws ParseException {
        return petTypeService.findAll().stream()
                .filter(petType -> petType.getName().equalsIgnoreCase(text))
                .findAny()
                .orElseThrow(() -> new ParseException(String.format("Type not found: %s ", text),0));
    }

    @Override
    public String print(PetType petType, Locale locale) {
        return petType.getName();
    }
}
