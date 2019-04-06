package com.example.demo.spring.petclinic.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class IndexControllerTest {

    private IndexController indexController;

    @Before
    public void setUp() {
        indexController = new IndexController();
    }

    @Test
    public void getIndexPage() throws Exception {
        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();



        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

}