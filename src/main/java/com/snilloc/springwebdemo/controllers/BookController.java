package com.snilloc.springwebdemo.controllers;

import com.snilloc.springwebdemo.repositories.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// Spring will detect this as a spring bean and wire it into the context
@Controller
public class BookController {

    private BookRepository bookRespository;

    public BookController(BookRepository bookRespository) {
        this.bookRespository = bookRespository;

    }

    @RequestMapping("books")
    public String getBooks(Model model) {

        // Associate thymeleaf view of books, with iterator of books
        model.addAttribute("books", bookRespository.findAll());


        // return the thymeleaf view of books
        return "books";
    }

}
