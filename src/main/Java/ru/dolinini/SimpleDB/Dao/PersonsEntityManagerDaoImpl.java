package ru.dolinini.SimpleDB.Dao;

import ru.dolinini.SimpleDB.model.Person;
import ru.dolinini.SimpleDB.util.EntityManagerFactoryUtil;
import ru.dolinini.SimpleDB.util.HibernateSessionFactoryUtil;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class PersonsEntityManagerDaoImpl implements Dao<Person> {

    @Override
    public List<Person> findAll() {
        EntityManager em= EntityManagerFactoryUtil.getEntityManager();
        List<Person> persons=(List<Person>)em.createQuery("from Person").getResultList();
        em.close();
        return persons;
    }
    @Override
    public Person findById(int id) {
       // EntityManager em=EntityManagerFactoryUtil.getEntityManager();
        Person p=EntityManagerFactoryUtil.getEntityManager().find(Person.class, id);
        return p;
    }

    @Override
    public void update(Person person) {
        EntityManager em=EntityManagerFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void save(Person person) {
        EntityManager em=EntityManagerFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(person);
        em.getTransaction().commit();
        em.close();
    }

    @Override
    public void delete(Person person) {
        EntityManager em=EntityManagerFactoryUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(em.contains(person) ? person : em.merge(person));
        em.getTransaction().commit();
    }


}
