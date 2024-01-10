package com.example.bookshop.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookId implements Serializable {

    private int id;

    private String isbn;
}
