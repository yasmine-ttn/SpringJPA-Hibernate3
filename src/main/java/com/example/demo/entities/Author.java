package com.example.demo.entities;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    @OneToMany(mappedBy = "author",cascade=CascadeType.PERSIST)
    @Size(min=3)
    private Set<Subject> subjects;

    public Set<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(Set<Subject> subjects) {
        this.subjects = subjects;
    }


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name="author_books",
            joinColumns = @JoinColumn(name="author_id",referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name="book_id",referencedColumnName = "id"))
    private Set<Book> bookSet;
    @Embedded
    private Address address;


    public Set<Book> getBookSet() {
        return bookSet;
    }

    public void setBookSet(Set<Book> bookSet) {
        this.bookSet = bookSet;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }




}
