package com.cph.CA1Backend.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonsController {

    @GetMapping(value = "/api/test")
    public String testEndpoint() {
        return "Hello test endpoint!";
    }

}
