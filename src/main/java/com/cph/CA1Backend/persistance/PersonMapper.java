package com.cph.CA1Backend.persistance;


import com.cph.CA1Backend.entities.Person;
import jakarta.persistence.TypedQuery;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PersonMapper {
    PersistenceManager persistenceManager;

    public PersonMapper(PersistenceManager persistenceManager) {
        this.persistenceManager = persistenceManager;
    }

    public Person getSpecificPerson(int personId) {
        Logger.getLogger("web").log(Level.INFO, "");

        Person person = persistenceManager.getEntityManager().find(Person.class, personId);

        return person;
    }

    public List<Person> getAllPeople() {
        TypedQuery<Person> query = persistenceManager.getEntityManager().createNamedQuery("getAllPeople", Person.class);

        return query.getResultList();
    }

    public Person create(Person person) {
        Logger.getLogger("web").log(Level.INFO, "");

        persistenceManager.entityTransaction().begin();
        persistenceManager.getEntityManager().persist((person));
        persistenceManager.entityTransaction().commit();
    }
}
