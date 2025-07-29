package mxkcpy.badreads.controllers;

import mxkcpy.badreads.data.Book;
import mxkcpy.badreads.data.BookDetails;
import mxkcpy.badreads.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public final class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Book> books = bookService.getAll();
        List<BookDetails> details = new ArrayList<>();

        for (Book book : books) {
            details.add(book.getDetails());
        }

        model.addAttribute("books", details);
        return "BadReads";
    }

}
