package ru.dolinini.SimpleDB.model;

import ru.dolinini.SimpleDB.Services.PersonService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonService personService=new PersonService();


        Person person1=new Person("Abba","Cruik");
        Person person2=new Person("Gugo","Zirca");

        personService.savePerson(person1);
        personService.savePerson(person2);

        PersonThing thing1=new PersonThing("boiled egg");
        PersonThing thing2=new PersonThing("someone killed by boiled egg");
        PersonThing thing3=new PersonThing("fresh meat");

        person1.addThing(thing1);
        person1.addThing(thing2);
        person2.addThing(thing3);

        personService.updatePerson(person1);
        personService.updatePerson(person2);

//        personService.deletePerson(person1);
//        personService.deletePerson(person2);

        System.out.println(personService.findAllPersons());

          List<Person> list=personService.findAllPersons();
          for (Person person: list) {
              personService.deletePerson(person);
          }



    }
}
