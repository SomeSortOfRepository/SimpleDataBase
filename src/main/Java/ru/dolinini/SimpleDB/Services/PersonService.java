package ru.dolinini.SimpleDB.Services;

import ru.dolinini.SimpleDB.Dao.Dao;
import ru.dolinini.SimpleDB.Dao.PersonsEntityManagerDaoImpl;
import ru.dolinini.SimpleDB.model.Person;

import java.util.List;


public class PersonService {

    private Dao<Person> personsDao=new PersonsEntityManagerDaoImpl();

    public Person findPersonById(int id) {
        return personsDao.findById(id);
    }
    public void updatePerson (Person person) {
        personsDao.update(person);
    }
    public void deletePerson (Person person) {
        personsDao.delete(person);
    }
    public void deletePersonById (int id) {
        Person person=personsDao.findById(id);
        personsDao.delete(person);
    }
    public void savePerson(Person person) {
        personsDao.save(person);
    }
    public List<Person> findAllPersons () {
        return personsDao.findAll();
    }



}
