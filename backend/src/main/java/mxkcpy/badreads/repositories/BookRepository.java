package mxkcpy.badreads.repositories;

import mxkcpy.badreads.data.Book;

import java.util.List;

public interface BookRepository {

    Book findById(int id);

    List<Book> retrieveNRandomBooks(int numberOfBooks);
}
