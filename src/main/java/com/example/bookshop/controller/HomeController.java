package com.example.bookshop.controller;

import com.example.bookshop.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final BookService service;

    @GetMapping({"/","home"})
    public String home(Model model){
        model.addAttribute("books",service.bookList());
        return "index";
    }
}
