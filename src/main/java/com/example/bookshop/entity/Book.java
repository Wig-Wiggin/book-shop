package com.example.bookshop.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter@Setter
@IdClass(BookId.class)
@NoArgsConstructor
public class Book {

    @Id
    private int id;

    @Id
    private String isbn;

    private String title;

    private String description;

    private Double price;

    private int stock;

    public Book(int id, String isbn, String title, String description, Double price, int stock) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.description = description;
        this.price = price;
        this.stock = stock;
    }

    @ManyToOne
    private Author author;

    @ManyToOne
    private Publisher publisher;

    @ManyToMany
    private List<Genre> genres = new ArrayList<>();

    @OneToMany(mappedBy = "book")
    private List<OrderItem> orderItems = new ArrayList<>();

    public void addGenre(Genre genre){
        genre.getBooks().add(this);
        genres.add(genre);
    }

    public void addOrderItem(OrderItem orderItem){
        orderItem.setBook(this);
        orderItems.add(orderItem);
    }
}
