package com.cph.CA1Backend.persistance;


import com.cph.CA1Backend.entities.Phone;

import java.util.logging.Level;
import java.util.logging.Logger;

public class PhoneMapper {

    PersistenceManager persistenceManager;

    public PhoneMapper(PersistenceManager persistenceManager) {
        this.persistenceManager = persistenceManager;
    }

    void saveNewPhone(Phone phone) {
        Logger.getLogger("web").log(Level.INFO, "");

        persistenceManager.entityTransaction().begin();
        persistenceManager.getEntityManager().persist((phone));
        persistenceManager.entityTransaction().commit();
    }
}
