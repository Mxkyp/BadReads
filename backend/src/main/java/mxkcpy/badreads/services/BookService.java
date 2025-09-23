package mxkcpy.badreads.services;

import mxkcpy.badreads.data.Book;

import java.util.List;

public interface BookService {

    List<Book> getRandomBooks(int booksToGet);

    Book getBookById(int id);
}
