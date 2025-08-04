package mxkcpy.badreads.repositories;

import mxkcpy.badreads.data.Book;
import mxkcpy.badreads.data.BookDetails;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
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
    public Book findById(int id) {
       return jdbcTemplate.queryForObject(SqlQueries.selectBook, new BookRowMapper(jdbcTemplate), id);
    }

    @Override
    public Book retrieveRandomBook() {
        return jdbcTemplate.queryForObject(SqlQueries.selectRandomBook, new BookRowMapper(jdbcTemplate));
    }

}
