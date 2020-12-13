package ru.dolinini.SimpleDB.model;

import javax.persistence.*;

@Entity
@Table(name = "personinterests")
public class PersonInterests {

    @Column
    private String interest;

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne ()
    @JoinColumn(name = "person_id")
    Person person;

    public PersonInterests() {
    }

    public PersonInterests(String interest) {
        this.interest = interest;
    }


    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    @Override
    public String toString() {
        return "PersonInterests{" +
                "interest='" + interest + '\'' +
                '}';
    }
}
