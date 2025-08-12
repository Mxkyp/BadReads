package mxkcpy.badreads.controllers;

import mxkcpy.badreads.data.Book;
import mxkcpy.badreads.exceptions.InvalidBookIdException;
import mxkcpy.badreads.exceptions.NoBooksFoundException;
import mxkcpy.badreads.services.BookService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public final class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public List<Book> home() throws NoBooksFoundException {
        return bookService.getRandomBooks(50);
    }

    @GetMapping("/book")
    public Book book(@RequestParam int id) throws InvalidBookIdException {
        return bookService.getBookById(id);
    }

}
