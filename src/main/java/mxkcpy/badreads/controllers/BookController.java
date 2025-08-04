package mxkcpy.badreads.controllers;

import mxkcpy.badreads.data.Book;
import mxkcpy.badreads.services.PlainBookService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public final class BookController {
    private final PlainBookService bookService;

    public BookController(PlainBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public List<Book> home(Model model) {
        return bookService.getRandomBooks(50);
    }

    @GetMapping("/book")
    public Book book(Model model, @RequestParam int id) {
        return bookService.getBookById(id);
    }

}
