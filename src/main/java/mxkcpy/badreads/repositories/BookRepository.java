package mxkcpy.badreads.repositories;

import mxkcpy.badreads.data.Book;

import java.util.Map;
import java.util.zip.DataFormatException;

public interface BookRepository {

    public Book findById(long id);

    public Map<Integer, Book> getAll() throws DataFormatException;
}
