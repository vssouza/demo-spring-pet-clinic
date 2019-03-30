package com.example.demo.spring.petclinic.controller;

import com.example.demo.spring.petclinic.model.Owner;
import com.example.demo.spring.petclinic.service.OwnerService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;

public class OwnerControllerTest {

    private static final String FIRST_OWNER_FIRST_NAME = "Vinicius";
    private static final String FIRST_OWNER_LAST_NAME = "Yamauchi";

    private static final String SECOND_OWNER_FIRST_NAME = "Bruno";
    private static final String SECOND_OWNER_LAST_NAME = "Noda";

    @Mock
    private Model model;

    @Mock
    private OwnerService ownerService;

    @Mock
    private Owner firstMockOwner;

    @Mock Owner secondMockOwner;

    private OwnerController ownerController;
    private Set<Owner> ownerSet;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ownerController = new OwnerController(ownerService);

        createOwnerMocks();

        ownerSet = new HashSet<>();
        ownerSet.add(firstMockOwner);
        ownerSet.add(secondMockOwner);

        when(ownerService.findAll()).thenReturn(ownerSet);
    }

    private void createOwnerMocks() {
        when(firstMockOwner.getId()).thenReturn(1L);
        when(firstMockOwner.getFirstName()).thenReturn(FIRST_OWNER_FIRST_NAME);
        when(firstMockOwner.getLastName()).thenReturn(FIRST_OWNER_LAST_NAME);

        when(secondMockOwner.getId()).thenReturn(2L);
        when(secondMockOwner.getFirstName()).thenReturn(SECOND_OWNER_FIRST_NAME);
        when(secondMockOwner.getLastName()).thenReturn(SECOND_OWNER_LAST_NAME);
    }

    @Test
    public void getOwnersPage() {
        assertEquals("owners/index", ownerController.listOwners(model));
        verify(ownerService, times(1)).findAll();

        ArgumentCaptor<Set<Owner>> argumentCaptor = ArgumentCaptor.forClass(Set.class);

        verify(model, times(1)).addAttribute(eq("owners"), argumentCaptor.capture());
        assertEquals(2, argumentCaptor.getValue().size());
    }
}