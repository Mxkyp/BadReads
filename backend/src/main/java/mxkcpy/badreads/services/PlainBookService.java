package mxkcpy.badreads.services;

import mxkcpy.badreads.data.Book;
import mxkcpy.badreads.exceptions.InvalidBookIdException;
import mxkcpy.badreads.exceptions.NoBooksFoundException;
import mxkcpy.badreads.repositories.BookRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PlainBookService implements BookService {
    BookRepository bookRepository;

    public PlainBookService(BookRepository bookRepository)  {
        this.bookRepository = bookRepository;
    }

    public List<Book> getRandomBooks(int numberOfBooks) throws NoBooksFoundException {
        List<Book> books = bookRepository.retrieveNRandomBooks(numberOfBooks);
        if (books == null || books.size() != numberOfBooks) throw new NoBooksFoundException();
        return books;
    }

    public Book getBookById(int id) throws InvalidBookIdException {
        Book book = bookRepository.findById(id);
        if (book == null) throw new InvalidBookIdException(id);
        return book;
    }
}
