package mxkcpy.badreads.repositories;

import mxkcpy.badreads.data.Book;
import mxkcpy.badreads.data.BookDetails;
import mxkcpy.badreads.data.BookEnums;
import org.postgresql.Driver;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import java.util.zip.DataFormatException;

@Repository
public class DbBookRepository implements BookRepository {
    private Map<Integer, Book> books;
    private JdbcTemplate jdbcTemplate;

    public DbBookRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public String findById(long id) {
       String sql = "SELECT * FROM public.books WHERE id = 2";
       RowMapper<String> bookRowMapper = (rs, rowNum) -> {
           return rs.getString("title");
       };

       return jdbcTemplate.queryForObject(sql, bookRowMapper);
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
