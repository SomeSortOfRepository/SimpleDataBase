package ru.dolinini.SimpleDB.model;

import ru.dolinini.SimpleDB.Services.PersonService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonService personService=new PersonService();


//        Person person1=new Person("Abba","Cruik");
//        Person person2=new Person("Gugo","Zirca");

//        personService.savePerson(person1);
//        personService.savePerson(person2);

//        PersonInterests interest1=new PersonInterests("boiling eggs");
//        PersonInterests interest2=new PersonInterests("killing people with boiled eggs");

//        Person person1=personService.findPersonById(13);
//        Person person2=personService.findPersonById(14);

//        person1.addInterests(interest1);
//        person2.addInterests(interest2);

//        personService.updatePerson(person1);
//        personService.updatePerson(person2);

//        personService.deletePerson(person1);
//        personService.deletePerson(person2);
          List<Person> list=personService.findAllPersons();
          for (Person person: list) {
              personService.deletePerson(person);
          }

          System.out.println(personService.findAllPersons());
          System.out.println(personService.findPersonById(14));
//        personService.deletePersonById(9);
//        personService.deletePersonById(10);


    }
}
