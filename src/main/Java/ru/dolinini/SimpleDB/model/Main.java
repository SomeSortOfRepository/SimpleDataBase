package ru.dolinini.SimpleDB.model;

import ru.dolinini.SimpleDB.Services.PersonService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PersonService personService=new PersonService();


        Person person1=new Person("Abba","Cruik");   //Create 2 persons
        Person person2=new Person("Gugo","Zirca");

        personService.savePerson(person1);                          //add persons in DB
        personService.savePerson(person2);

        PersonThing thing1=new PersonThing("boiled egg");           //create things
        PersonThing thing2=new PersonThing("lonely boot");
        PersonThing thing3=new PersonThing("fresh salad");

        person1.addThing(thing1);                                   //assign things to persons
        person1.addThing(thing2);
        person2.addThing(thing3);

        personService.updatePerson(person1);                        //update persons with their new things in DB
        personService.updatePerson(person2);



        System.out.println(personService.findAllPersons());         //check that persons received their things



          List<Person> list=personService.findAllPersons();         //remove all persons and their things
          for (Person person: list) {
              personService.deletePerson(person);
          }



    }
}
