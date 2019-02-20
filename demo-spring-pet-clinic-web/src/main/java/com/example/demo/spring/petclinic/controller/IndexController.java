package com.example.demo.spring.petclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {

    @RequestMapping(path = {"", "index", "/", "index.html"})
    public String showIndex() {
        return "index";
    }

    @RequestMapping({"oups", "/owners/find"})
    public String showErrorPlaceholder() {
        return "notimplemented";
    }
}
