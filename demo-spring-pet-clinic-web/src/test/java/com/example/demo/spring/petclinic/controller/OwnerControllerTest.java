package com.example.demo.spring.petclinic.controller;

import com.example.demo.spring.petclinic.service.OwnerService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class OwnerControllerTest {

    @Mock
    private Model model;

    @Mock
    private OwnerService ownerService;

    private OwnerController ownerController;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        ownerController = new OwnerController(ownerService);
    }

    @Test
    public void getOwnersPage() {
        Assert.assertEquals("owners/index", ownerController.listOwners(model));
        verify(ownerService, times(1)).findAll();
        verify(model, times(1)).addAttribute(eq("owners"), anySet());
    }
}