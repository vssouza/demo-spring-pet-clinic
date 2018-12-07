package com.example.demo.spring.petclinic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * mvn spring-boot:help -Ddetail=true
 *      shows detailed options for the execution
 *
 * mvn spring-boot:run -Drun.arguents=--debug
 *      will start the springboot software displaying autoconfiguration report
 */

@SpringBootApplication
public class DemoSpringPetClinicApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringPetClinicApplication.class, args);
    }
}
