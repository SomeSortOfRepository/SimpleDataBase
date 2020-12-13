package ru.dolinini.SimpleDB.Dao;

import org.hibernate.Session;
import org.hibernate.SessionException;
import org.hibernate.Transaction;
import ru.dolinini.SimpleDB.model.Person;
import ru.dolinini.SimpleDB.util.HibernateSessionFactoryUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PersonsDao {

    public List<Person> getAllPersons() {
        Session session=HibernateSessionFactoryUtil.getSessionFactory().openSession();
        List<Person> persons= (List<Person>) session.createQuery("From Person").list();
        session.close();
        return persons;
    }

    public Person findById(int id) {
        Session session=HibernateSessionFactoryUtil.getSessionFactory().openSession();
        Person p=session.get(Person.class, id);
        session.close();
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

//    public List<Person> findAllPersonsWithInterest (String inter) {
//        List<Person> personsWithInterest= (List<Person>) HibernateSessionFactoryUtil.getSessionFactory().openSession().createQuery("From Persons Where PersonInterests.interest='inter'").list();
//    }

}
