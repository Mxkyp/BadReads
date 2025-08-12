package mxkcpy.badreads.repositories;

import mxkcpy.badreads.data.Book;

public interface BookRepository {

    public Book findById(int id);

    public Book retrieveRandomBook();
}
