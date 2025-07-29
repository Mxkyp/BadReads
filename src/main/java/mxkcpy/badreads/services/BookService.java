package mxkcpy.badreads.services;

import mxkcpy.badreads.data.Book;
import mxkcpy.badreads.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.DataFormatException;

@Service
public class BookService {
    BookRepository bookRepository;
    List<Book> bookList;

    public BookService(BookRepository bookRepository) throws DataFormatException {
        this.bookRepository = bookRepository;
        bookList = bookRepository.getAll();
    }

    public List<Book> getAll() {
        return bookList;
    }
}
