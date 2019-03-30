package com.example.demo.spring.petclinic.service.map;

import com.example.demo.spring.petclinic.model.Owner;
import com.example.demo.spring.petclinic.repository.OwnerRepository;
import com.example.demo.spring.petclinic.service.jpa.OwnerJpaService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Set;

import static java.util.Optional.ofNullable;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

public class OwnerMapServiceTest {

    private static final String FIRST_OWNER_FIRST_NAME = "Vinicius";
    private static final String FIRST_OWNER_LAST_NAME = "Yamauchi";

    private static final String SECOND_OWNER_FIRST_NAME = "Bruno";
    private static final String SECOND_OWNER_LAST_NAME = "Noda";


    @Mock
    private Owner firstMockOwner;
    @Mock
    private Owner secondMockOwner;
    @Mock
    private Set<Owner> owners;

    @Mock
    private OwnerRepository ownerRepository;
    private OwnerJpaService ownerJpaService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ownerJpaService = new OwnerJpaService(ownerRepository);
        createOwnerMocks();
        createOwnerRepositoryMocks();
        createOwners();
    }

    private void createOwnerMocks() {
        when(firstMockOwner.getId()).thenReturn(1L);
        when(firstMockOwner.getFirstName()).thenReturn(FIRST_OWNER_FIRST_NAME);
        when(firstMockOwner.getLastName()).thenReturn(FIRST_OWNER_LAST_NAME);

        when(secondMockOwner.getId()).thenReturn(2L);
        when(secondMockOwner.getFirstName()).thenReturn(SECOND_OWNER_FIRST_NAME);
        when(secondMockOwner.getLastName()).thenReturn(SECOND_OWNER_LAST_NAME);
    }

    private void createOwnerRepositoryMocks() {
        when(ownerRepository.findByLastName(FIRST_OWNER_LAST_NAME)).thenReturn(firstMockOwner);
        when(ownerRepository.findByLastName(SECOND_OWNER_LAST_NAME)).thenReturn(secondMockOwner);
        when(ownerRepository.findById(1L)).thenReturn(ofNullable(firstMockOwner));
        when(ownerRepository.findById(2L)).thenReturn(ofNullable(secondMockOwner));
        when(ownerRepository.findById(3L)).thenReturn(ofNullable(null));
        when(ownerRepository.findAll()).thenReturn(owners);
    }

    private void createOwners() {
        owners.add(firstMockOwner);
        owners.add(secondMockOwner);
    }

    @Test
    public void findById() {
        Owner firstOwner = ownerJpaService.findById(1L);
        assertEquals(FIRST_OWNER_FIRST_NAME, firstOwner.getFirstName());

        Owner secondOwner = ownerJpaService.findById(2L);
        assertEquals(SECOND_OWNER_FIRST_NAME, secondOwner.getFirstName());

        Owner nullOwner = ownerJpaService.findById(3L);
        assertNull(nullOwner);

        verify(ownerRepository, times(1)).findById(1L);
    }

    @Test
    public void save() {
    }

    @Test
    public void findAll() {
    }

    @Test
    public void deleteById() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void findByLastName() {
        Owner firstOwner = ownerJpaService.findByLastName(FIRST_OWNER_LAST_NAME);
        assertEquals(FIRST_OWNER_LAST_NAME, firstOwner.getLastName());
        assertEquals(FIRST_OWNER_FIRST_NAME, firstOwner.getFirstName());

        Owner secondOwner = ownerJpaService.findByLastName(SECOND_OWNER_LAST_NAME);
        assertEquals(SECOND_OWNER_FIRST_NAME, secondOwner.getFirstName());
        assertEquals(SECOND_OWNER_LAST_NAME, secondOwner.getLastName());

        verify(ownerRepository, times(1)).findByLastName(FIRST_OWNER_LAST_NAME);
    }
}