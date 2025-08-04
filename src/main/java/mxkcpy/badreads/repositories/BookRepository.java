package mxkcpy.badreads.repositories;

import mxkcpy.badreads.data.Book;

import java.util.List;
import java.util.Map;
import java.util.zip.DataFormatException;

public interface BookRepository {

    public List<Book> findById(int id);

    public void getAll() throws DataFormatException;
}
