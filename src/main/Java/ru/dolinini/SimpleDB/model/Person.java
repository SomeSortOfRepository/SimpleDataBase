package ru.dolinini.SimpleDB.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column()
    private String name;
    @Column(name = "surename")
    private String sureName;
    @Column(name = "oneworddescription")
    private String oneWordDescription;

    @OneToMany(mappedBy = "person", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    List<PersonThing> things;

    public Person() {
    }

    public Person(String name, String sureName) {
        this.name = name;
        this.sureName = sureName;
        things=new ArrayList<>();
    }


    public List<PersonThing> getThings() {
        return things;
    }

    public void addThing(PersonThing thing) {
        thing.setPerson(this);
        this.things.add(thing);
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public String getOneWordDescription() {
        return oneWordDescription;
    }

    public void setOneWordDescription(String oneWordDescription) {
        this.oneWordDescription = oneWordDescription;
    }

    @Override
    public String toString() {
        return "Persons{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sureName='" + sureName + '\'' +
                ", oneWordDescription='" + oneWordDescription + '\'' +
                ", things=" + things +
                '}';
    }
}
