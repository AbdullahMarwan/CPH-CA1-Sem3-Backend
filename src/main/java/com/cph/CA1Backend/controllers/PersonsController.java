package com.cph.CA1Backend.controllers;

import com.cph.CA1Backend.persistance.old_temp.dtos.PersonDTO;
import com.cph.CA1Backend.entities.Person;
import com.cph.CA1Backend.persistance.PersistenceManager;
import com.cph.CA1Backend.persistance.PersonMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("persons")
public class PersonsController {
    private static final String APPLICATION_JSON = "application/json";

    private final PersistenceManager persistenceManager = new PersistenceManager("pu");
    private final PersonMapper personMapper = new PersonMapper(persistenceManager);

    @GetMapping(value = "test")
    public String testEndpoint() {
        return "Hello test endpoint!";
    }

    @RequestMapping(
            value = "/",
            method = RequestMethod.GET,
            produces = APPLICATION_JSON
    )
    public List<Person> getAllPersons() {
        return personMapper.getAllPeople();
    }

    @GetMapping
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPersonById(@PathParam("id") int id) {
        return personMapper.getById(id);
    }

    @RequestMapping(
            value = "/",
            method = RequestMethod.POST,
            consumes = APPLICATION_JSON,
            produces = APPLICATION_JSON
    )
    public Person createPerson(@RequestBody Person person) {
        return personMapper.create(person);
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public PersonDTO updatePerson(@PathParam("id") int id, PersonDTO person) {
        return personsFacade.updatePerson(id, person);
    }
}
