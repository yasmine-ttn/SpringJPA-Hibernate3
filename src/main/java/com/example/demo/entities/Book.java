package com.example.demo.entities;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String bookName;
    @ManyToMany(mappedBy = "bookSet")
    private Set<Author> authors;

//    public Set<Author> getAuthors() {
//        return authors;
//    }
//
//    public void setAuthors(Set<Author> authors) {
//        this.authors = authors;
//    }



    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
