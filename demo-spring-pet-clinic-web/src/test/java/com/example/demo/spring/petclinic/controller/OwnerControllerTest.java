package com.example.demo.spring.petclinic.controller;

import com.example.demo.spring.petclinic.model.Owner;
import com.example.demo.spring.petclinic.service.OwnerService;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.Matchers.*;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
public class OwnerControllerTest {

    @Mock
    private OwnerService ownerService;

    @InjectMocks
    private OwnerController ownerController;

    @Mock
    private Owner firstMockOwner;

    @Mock
    private Owner secondMockOwner;

    private Set<Owner> ownerSet;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(ownerController).build();

        ownerSet = new HashSet<>();
        ownerSet.add(firstMockOwner);
        ownerSet.add(secondMockOwner);

        when(ownerService.findAll()).thenReturn(ownerSet);
    }

    @Test
    public void getOwner() throws Exception {
        when(ownerService.findById(anyLong())).thenReturn(Owner.builder().id(1L).build());
        mockMvc.perform(get("/owners/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownerDetails"))
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attribute("owner", hasProperty("id", is(1L))));

        verify(ownerService).findById(anyLong());
    }

    @Test
    public void initFindForm() throws Exception {
        mockMvc.perform(get("/owners/find"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/findOwners"))
                .andExpect(model().attributeExists("owner"))
                .andExpect(model().attribute("owner", notNullValue()));
    }

    @Test
    public void processFindFormNoReturn() throws Exception {
        when(ownerService.findByLastNameLike(anyString())).thenReturn(Collections.emptyList());
        mockMvc.perform(get("/owners").param("lastName", "NoName"))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/findOwners"))
                .andExpect(model().hasErrors());

        verify(ownerService).findByLastNameLike(anyString());
    }

    @Test
    public void processFindFormReturnResults() throws Exception {
        when(ownerService.findByLastNameLike(anyString())).thenReturn(ownerSet);
        mockMvc.perform(get("/owners").param("lastName", ""))
                .andExpect(status().isOk())
                .andExpect(view().name("owners/ownersList"))
                .andExpect(model().attributeExists("selections"))
                .andExpect(model().attribute("selections", hasSize(2)));

        verify(ownerService).findByLastNameLike(StringUtils.EMPTY);
    }
}