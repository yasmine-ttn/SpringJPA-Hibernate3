package com.example.demo;

import com.example.demo.entities.Address;
import com.example.demo.entities.Author;
import com.example.demo.entities.Book;
import com.example.demo.entities.Subject;
import com.example.demo.repository.AuthorRepository;
import org.hibernate.Session;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.HashSet;

@SpringBootTest
public class AuthorTesting {
    @Autowired
    AuthorRepository repository;


    @Test
    public void testCreateAuthor()
    {
        Author author=new Author();

        author.setFirstName("Jenny");
        author.setLastName("Cooper");

        HashSet<Book> books=new HashSet<>();
        Book book1=new Book();

        book1.setBookName("Black Beauty");
        books.add(book1);

author.setBookSet(books);

        Address address=new Address();
        address.setStreetNumber(111);
        address.setLocation("Sesame Street");
        address.setState("Delhi");
        author.setAddress(address);
        repository.save(author);

    }
    @Test
    public void testPersist()
    {

        Author author=new Author();
        author.setFirstName("Kenny");
        author.setLastName("Chesling");
        Subject subject=new Subject();
        subject.setAuthor(author);
        subject.setName("Hebrew");
        Subject subject1=new Subject();
        subject1.setAuthor(author);
        subject1.setName("Maths");
        Subject subject2=new Subject();
        subject2.setAuthor(author);
        subject2.setName("Spanish");
HashSet<Subject> subjects=new HashSet<>();
subjects.add(subject);
subjects.add(subject1);
        subjects.add(subject2);
        author.setSubjects(subjects);
        Address address=new Address();
        address.setStreetNumber(111);
        address.setLocation("Sesame Street");
        address.setState("Delhi");
        author.setAddress(address);
repository.save(author);


    }

}
