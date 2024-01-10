package com.example.bookshop.controller;

import com.example.bookshop.dao.BookDao;
import com.example.bookshop.entity.BookId;
import com.example.bookshop.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Controller
@RequiredArgsConstructor
@RequestMapping("/book")
public class BookController {

    public  final BookService service;


    @GetMapping("/list-books")
    public String listBooks(Model model){
        model.addAttribute("books",service.bookList());
        return "listbooks";
    }

    @GetMapping("/book-details")
    public String bookDetails(@RequestParam("id")Integer id, @RequestParam("isbn")String isbn,Model model){
        BookId bookId = null;
        if ((Objects.nonNull(id)) && (Objects.nonNull(isbn))){
            bookId = new BookId();
            bookId.setId(id);
            bookId.setIsbn(isbn);
        }else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        model.addAttribute("book",service.findById(bookId));

        return "bookdetails";

    }
}
