package ru.dolinini.SimpleDB.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerFactoryUtil {
    private static final EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory= Persistence.createEntityManagerFactory("ru.dolinini");
    }
    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
    public static void close() {
        entityManagerFactory.close();
    }
}
