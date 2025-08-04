package mxkcpy.badreads.services;

import mxkcpy.badreads.data.Book;
import mxkcpy.badreads.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

@Service
public class BookService {
    BookRepository bookRepository;
    Map<Integer, Book> bookMap;

    public BookService(BookRepository bookRepository) throws DataFormatException {
        this.bookRepository = bookRepository;
        //bookMap = bookRepository.getAll();
    }

    public Map<Integer, Book> getAll() {
        return bookMap;
    }

    public Book getBookById(int id) {
        return bookMap.get(id);
    }
}
