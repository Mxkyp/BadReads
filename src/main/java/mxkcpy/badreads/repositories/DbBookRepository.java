package mxkcpy.badreads.repositories;

import mxkcpy.badreads.data.Book;
import mxkcpy.badreads.data.BookDetails;
import mxkcpy.badreads.data.BookEnums;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.zip.DataFormatException;

@Repository
public class DbBookRepository implements BookRepository {
    Map<Integer, Book> books;

    @Override
    public Book findById(long id) {
        return null;
    }

    @Override
    public Map<Integer, Book> getAll() throws DataFormatException {
        Book book1 = new Book(new BookDetails("9781234567890", "9781234567",
                "Winds of Freedom", null, List.of(new BookDetails.Author("John", "Smith")),
                List.of(BookEnums.Genre.HISTORICAL_FICTION, BookEnums.Genre.FICTION), "Url", "haha", new Date(),5));

        Book[] bookArr = new Book[]{book1};

        books = new HashMap<>(bookArr.length);

        for (Book b : bookArr) {
            books.put(b.getId(), b);
        }
        return books;
    }
}
