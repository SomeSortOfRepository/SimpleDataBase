package ru.dolinini.SimpleDB.Dao;

import org.hibernate.Session;

import org.hibernate.Transaction;
import ru.dolinini.SimpleDB.model.Person;
import ru.dolinini.SimpleDB.util.EntityManagerFactoryUtil;
import ru.dolinini.SimpleDB.util.HibernateSessionFactoryUtil;


import javax.persistence.EntityManager;
import java.util.List;


public class PersonsDaoImpl implements Dao<Person> {

    public List<Person> findAll() {
        Session s=HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Person> persons=(List<Person>)s.createQuery("from Person").list();
        s.close();
        return persons;
    }

    public Person findById(int id) {
        Person p=HibernateSessionFactoryUtil.getSessionFactory().openSession().find(Person.class, id);
        return p;
    }

    public void save(Person person) {
        Session session=HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction t=session.beginTransaction();
        session.save(person);
        t.commit();
        session.close();
    }
    public void update (Person person) {
        Session session=HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction t= session.beginTransaction();
        session.update(person);
        t.commit();
        session.close();
    }
    public void delete (Person person) {
        Session session=HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Transaction t= session.beginTransaction();
        session.delete(person);
        t.commit();
        session.close();
    }


}
