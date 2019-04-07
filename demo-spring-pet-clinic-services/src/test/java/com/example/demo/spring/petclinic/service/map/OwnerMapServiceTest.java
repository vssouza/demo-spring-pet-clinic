package com.example.demo.spring.petclinic.service.map;

import com.example.demo.spring.petclinic.model.Owner;
import com.example.demo.spring.petclinic.model.Pet;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Set;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

public class OwnerMapServiceTest {

    private static final String FIRST_OWNER_FIRST_NAME = "Vinicius";
    private static final String FIRST_OWNER_LAST_NAME = "Yamauchi";

    private static final String SECOND_OWNER_FIRST_NAME = "Bruno";
    private static final String SECOND_OWNER_LAST_NAME = "Noda";

    private static final String THIRD_OWNER_FIRST_NAME = "Alexandre";
    private static final String THIRD_OWNER_LAST_NAME = "Arantes";

    private static final String NULL_ID_FIRST_NAME = "Alexandre";
    private static final String NULL_ID_LAST_NAME = "Arantes";


    @Mock
    private Owner firstMockOwner;
    @Mock
    private Owner secondMockOwner;
    @Mock
    private Owner thirdOwner;
    @Mock
    private Owner nullOwner;
    @Mock
    private PetTypeMapService petTypeService;
    @Mock
    private PetMapService petService;
    @Mock
    private Set<Pet> pets;

    private OwnerMapService ownerMapService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ownerMapService = new OwnerMapService(petTypeService, petService);
        createOwnerMocks();
        createOwners();
    }

    private void createOwnerMocks() {
        when(firstMockOwner.getId()).thenReturn(1L);
        when(firstMockOwner.getFirstName()).thenReturn(FIRST_OWNER_FIRST_NAME);
        when(firstMockOwner.getLastName()).thenReturn(FIRST_OWNER_LAST_NAME);
        when(firstMockOwner.getPets()).thenReturn(pets);
        when(pets.isEmpty()).thenReturn(false);

        when(secondMockOwner.getId()).thenReturn(2L);
        when(secondMockOwner.getFirstName()).thenReturn(SECOND_OWNER_FIRST_NAME);
        when(secondMockOwner.getLastName()).thenReturn(SECOND_OWNER_LAST_NAME);
        when(secondMockOwner.getPets()).thenReturn(pets);
        when(pets.isEmpty()).thenReturn(false);

        when(thirdOwner.getId()).thenReturn(3L);
        when(thirdOwner.getFirstName()).thenReturn(THIRD_OWNER_FIRST_NAME);
        when(thirdOwner.getLastName()).thenReturn(THIRD_OWNER_LAST_NAME);
        when(thirdOwner.getPets()).thenReturn(pets);
        when(pets.isEmpty()).thenReturn(false);

        when(nullOwner.getFirstName()).thenReturn(NULL_ID_FIRST_NAME);
        when(nullOwner.getLastName()).thenReturn(NULL_ID_LAST_NAME);
        when(nullOwner.getPets()).thenReturn(pets);
        when(pets.isEmpty()).thenReturn(false);
    }

    private void createOwners() {
        ownerMapService.save(firstMockOwner);
        ownerMapService.save(secondMockOwner);
    }

    @Test
    public void findById() {
        Owner firstOwner = ownerMapService.findById(1L);
        assertEquals(FIRST_OWNER_FIRST_NAME, firstOwner.getFirstName());

        Owner secondOwner = ownerMapService.findById(2L);
        assertEquals(SECOND_OWNER_FIRST_NAME, secondOwner.getFirstName());

        Owner nullOwner = ownerMapService.findById(3L);
        assertNull(nullOwner);

    }

    @Test
    public void save() {
        ownerMapService.save(thirdOwner);
        assertEquals(3, ownerMapService.findAll().size());
        assertEquals(THIRD_OWNER_LAST_NAME, ownerMapService.findById(3L).getLastName());
    }

    @Test
    public void saveExistingOwner() {
        ownerMapService.save(secondMockOwner);
        assertEquals(2, ownerMapService.findAll().size());
        assertEquals(SECOND_OWNER_LAST_NAME, ownerMapService.findById(2L).getLastName());
    }

    @Test
    public void saveNullIdOwner() {
        Owner owner = ownerMapService.save(nullOwner);
        assertEquals(3, ownerMapService.findAll().size());
        assertNotNull(owner.getId());
        assertNotNull(owner);
    }

    @Test
    public void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(2, owners.size());
        assertTrue(owners.contains(firstMockOwner));
        assertTrue(owners.contains(secondMockOwner));
    }

    @Test
    public void deleteById() {
        ownerMapService.deleteById(1L);
        assertEquals(1, ownerMapService.findAll().size());
        assertFalse(ownerMapService.findAll().contains(firstMockOwner));
    }

    @Test
    public void delete() {
        ownerMapService.delete(ownerMapService.findById(2L));
        assertEquals(1, ownerMapService.findAll().size());
        assertFalse(ownerMapService.findAll().contains(secondMockOwner));
    }

    @Test
    public void findByLastName() {
        Owner firstOwner = ownerMapService.findByLastName(FIRST_OWNER_LAST_NAME);
        assertEquals(FIRST_OWNER_LAST_NAME, firstOwner.getLastName());
        assertEquals(FIRST_OWNER_FIRST_NAME, firstOwner.getFirstName());

        Owner secondOwner = ownerMapService.findByLastName(SECOND_OWNER_LAST_NAME);
        assertEquals(SECOND_OWNER_FIRST_NAME, secondOwner.getFirstName());
        assertEquals(SECOND_OWNER_LAST_NAME, secondOwner.getLastName());
    }
}