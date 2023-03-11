package com.cph.CA1Backend.controllers;

import com.cph.CA1Backend.entities.Person;
import com.cph.CA1Backend.persistance.PersistenceManager;
import com.cph.CA1Backend.persistance.PersonMapper;
import jakarta.websocket.server.PathParam;
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

    @RequestMapping(
            value = "/",
            method = RequestMethod.POST,
            consumes = APPLICATION_JSON,
            produces = APPLICATION_JSON
    )
    public void createPerson(@RequestBody Person person) {
    }

//    @GetMapping
//    @Path("/{id}")
//    @Produces(MediaType.APPLICATION_JSON)
//    public Person getPersonById(@PathParam("id") int id) {
//        return personMapper.getById(id);
//    }
//
//    @PUT
//    @Path("/{id}")
//    @Consumes(MediaType.APPLICATION_JSON)
//    @Produces(MediaType.APPLICATION_JSON)
//    public PersonDTO updatePerson(@PathParam("id") int id, PersonDTO person) {
//        return personsFacade.updatePerson(id, person);
//    }
}
