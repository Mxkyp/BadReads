package mxkcpy.badreads.controllers;

import mxkcpy.badreads.data.Book;
import mxkcpy.badreads.data.BookDetails;
import mxkcpy.badreads.repositories.BookRepository;
import mxkcpy.badreads.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public final class BookController {
    private final BookService bookService;
    private final BookRepository bookRepository;

    public BookController(BookService bookService, BookRepository bookRepository) {
        this.bookService = bookService;
        this.bookRepository = bookRepository;
    }

    @GetMapping("/")
    public String home(Model model) {

        return bookRepository.findById(2);
    }

    @GetMapping("/book")
    public String book(Model model, @RequestParam int id) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("bookDetails", book.getDetails());
        return "Book";
    }

}
