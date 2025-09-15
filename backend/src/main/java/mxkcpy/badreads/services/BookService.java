package mxkcpy.badreads.services;

import mxkcpy.badreads.data.Book;

import java.util.List;

public interface BookService {

    public List<Book> getRandomBooks(int booksToGet);

    public Book getBookById(int id);
}
