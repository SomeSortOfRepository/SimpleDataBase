package ru.dolinini.SimpleDB.model;

import javax.persistence.*;

@Entity
@Table(name = "personthings")
public class PersonThing {

    @Column
    private String thing;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne ()
    @JoinColumn(name = "person_id")
    Person person;

    public PersonThing() {
    }

    public PersonThing(String thing) {
        this.thing = thing;
    }


    public String getThing() {
        return thing;
    }

    public void setThing(String interest) {
        this.thing = interest;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "PersonThing{" +
                "thing='" + thing + '\'' +
                ", id=" + id +
                '}';
    }
}
