package com.example.bookshop.entity;

import jakarta.persistence.*;
import lombok.Generated;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter
@NoArgsConstructor
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String authorName;

    private String email;

    public Author(String name, String email) {
        this.authorName = name;
        this.email = email;
    }

    @OneToMany(mappedBy = "author",cascade = CascadeType.ALL)
    private List<Book> books = new ArrayList<>();

    public void addBook(Book book){
        book.setAuthor(this);
        books.add(book);
    }
}
