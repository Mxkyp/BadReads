package mxkcpy.badreads.controllers;

import mxkcpy.badreads.data.Book;
import mxkcpy.badreads.data.BookDetails;
import mxkcpy.badreads.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public final class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String home(Model model) {
        Map<Integer, Book> books = bookService.getAll();

        model.addAttribute("books", books);
        return "BadReads";
    }

    @GetMapping("/book")
    public String book(Model model, @RequestParam int id) {
        Book book = bookService.getBookById(id);
        model.addAttribute("book", book);
        model.addAttribute("bookDetails", book.getDetails());
        return "Book";
    }

}
