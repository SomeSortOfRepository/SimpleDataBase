package ru.dolinini.SimpleDB.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    List<PersonInterests> interests;

    public Person() {
    }

    public Person(String name, String sureName) {
        this.name = name;
        this.sureName = sureName;
        interests=new ArrayList<>();
    }


    public List<PersonInterests> getInterests() {
        return interests;
    }

    public void addInterests(PersonInterests interest) {
        interest.setPerson(this);
        this.interests.add(interest);
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
                ", interests=" + interests +
                '}';
    }
}
