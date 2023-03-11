package com.cph.CA1Backend.persistance;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

public class PersistenceManager {
    private EntityManagerFactory entityManagerFactory;
    private EntityManager entityManager;

    public PersistenceManager(String entityUnit) {
        if (System.getenv("DEPLOYED") != null) {
            Map overridenProperties = new HashMap<>();

            overridenProperties.put("jakarta.persistence.jdbc.url", System.getenv("JDBC_DRIVER_PREFIX") + System.getenv("JDBC_HOST") + System.getenv("JDBC_DB") + System.getenv("JDBC_PARAMS"));
            overridenProperties.put("jakarta.persistence.jdbc.user", System.getenv("JDBC_USER"));
            overridenProperties.put("jakarta.persistence.jdbc.password", System.getenv("JDBC_PASSWORD"));

            this.entityManagerFactory = Persistence.createEntityManagerFactory(entityUnit, overridenProperties);
            this.entityManager = this.entityManagerFactory.createEntityManager();
        } else {
            this.entityManagerFactory = Persistence.createEntityManagerFactory(entityUnit);
            this.entityManager = this.entityManagerFactory.createEntityManager();
        }
    }

    public EntityTransaction entityTransaction() {
        return this.entityManager.getTransaction();
    }

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
