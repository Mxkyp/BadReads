package mxkcpy.badreads.services;

import mxkcpy.badreads.data.Book;
import mxkcpy.badreads.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

@Service
public class PlainBookService {
    BookRepository bookRepository;

    public PlainBookService(BookRepository bookRepository) throws DataFormatException {
        this.bookRepository = bookRepository;
    }

    public List<Book> getRandomBooks(int booksToGet) {
        List<Book> books = new ArrayList<>();
        for (int i = 0; i < booksToGet; i++) {
            do {
                Book book = bookRepository.retrieveRandomBook();
            }  while (books.contains(bookRepository.retrieveRandomBook()));
            books.add(bookRepository.retrieveRandomBook());
        }
        return books;
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id);
    }
}
