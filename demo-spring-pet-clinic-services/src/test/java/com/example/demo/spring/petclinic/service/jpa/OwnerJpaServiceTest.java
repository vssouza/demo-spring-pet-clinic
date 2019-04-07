package com.example.demo.spring.petclinic.service.jpa;

import com.example.demo.spring.petclinic.model.Owner;
import com.example.demo.spring.petclinic.repository.OwnerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class OwnerJpaServiceTest {

    public static final String FIRST_OWNER_LAST_NAME = "Yamauchi";
    public static final String FIRST_OWNER_FIRST_NAME = "Vinicius";

    public static final String SECOND_OWNER_LAST_NAME = "Noda";
    public static final String SECOND_OWNER_FIRST_NAME = "Bruno";

    @Mock
    private OwnerRepository ownerRepository;
    @Mock
    private Owner owner1;
    @Mock
    private Owner owner2;

    @InjectMocks
    private OwnerJpaService ownerJpaService;

    @Before
    public void setup() {
        when(owner1.getId()).thenReturn(1L);
        when(owner1.getFirstName()).thenReturn(FIRST_OWNER_FIRST_NAME);
        when(owner1.getLastName()).thenReturn(FIRST_OWNER_LAST_NAME);

        when(owner2.getId()).thenReturn(2L);
        when(owner2.getFirstName()).thenReturn(SECOND_OWNER_FIRST_NAME);
        when(owner2.getLastName()).thenReturn(SECOND_OWNER_LAST_NAME);
    }

    @Test
    public void findByLastName() {
        when(ownerRepository.findByLastName(any(String.class))).thenReturn(owner1);

        Owner searchOwner = ownerJpaService.findByLastName(FIRST_OWNER_LAST_NAME);
        assertTrue(FIRST_OWNER_FIRST_NAME.equals(searchOwner.getFirstName()));
        verify(ownerRepository, times(1)).findByLastName(FIRST_OWNER_LAST_NAME);
    }

    @Test
    public void findById() {
        when(ownerRepository.findById(any(Long.class))).thenReturn(Optional.of(owner2));
        Owner searchOwner = ownerJpaService.findById(2L);
        assertTrue(SECOND_OWNER_FIRST_NAME.equals(searchOwner.getFirstName()));
        verify(ownerRepository, times(1)).findById(2L);
    }

    @Test
    public void findByIdNotFound() {
        when(ownerRepository.findById(any(Long.class))).thenReturn(Optional.empty());
        Owner searchOwner = ownerJpaService.findById(3L);
        assertNull(searchOwner);
        verify(ownerRepository, times(1)).findById(3L);
    }

    @Test
    public void save() {
        Owner ownerToSave = Owner.builder().id(3L).firstName("Alexandre").lastName("Arantes").build();
        when(ownerRepository.save(any(Owner.class))).thenReturn(ownerToSave);
        Owner savedOwner = ownerJpaService.save(ownerToSave);
        assertNotNull(savedOwner);
        assertTrue(ownerToSave.getFirstName().equals(savedOwner.getFirstName()));
        verify(ownerRepository, times(1)).save(ownerToSave);

    }

    @Test
    public void findAll() {
        Set<Owner> owners = new HashSet<>();
        owners.add(owner1);
        owners.add(owner2);
        when(ownerRepository.findAll()).thenReturn(owners);

        Set<Owner> searchOwners = ownerJpaService.findAll();
        assertNotNull(searchOwners);
        assertEquals(2, searchOwners.size());
    }

    // default for verify is 1 time
    @Test
    public void delete() {
        ownerJpaService.delete(owner1);
        verify(ownerRepository).delete(any());
    }

    @Test
    public void deleteById() {
        ownerJpaService.deleteById(1L);
        verify(ownerRepository, times(1)).deleteById(any());
    }
}