package mxkcpy.badreads.repositories;

import mxkcpy.badreads.data.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.zip.DataFormatException;

public interface BookRepository {
    public Book findById(long id);
    public List<Book> getAll() throws DataFormatException;
}
