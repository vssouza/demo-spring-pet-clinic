package com.example.demo.spring.petclinic.integration;

import com.example.demo.spring.petclinic.repository.OwnerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ActiveProfiles("JPA")
@DataJpaTest
public class OwnerRepositoryIntegrationTest {

    @Autowired
    private OwnerRepository ownerRepository;

    @Before
    public void setup() {

    }

    @Test
    public void findByLastName() {
//        Owner owner =  ownerRepository.findByLastName("Vinicius");
//        assertEquals("Yamauchi", owner.getLastName());
//        assertEquals("Vinicius", owner.getFirstName());
//        assertEquals(2, owner.getPets().size());
    }

}