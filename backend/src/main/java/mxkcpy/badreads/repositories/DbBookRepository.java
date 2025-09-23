package mxkcpy.badreads.repositories;

import mxkcpy.badreads.data.Book;
import org.springframework.context.annotation.Lazy;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DbBookRepository implements BookRepository {
    private final JdbcTemplate jdbcTemplate;

    public DbBookRepository(@Lazy JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Book findById(int id) {
       try {
           return jdbcTemplate.queryForObject(SqlQueries.selectBook, new BookRowMapper(jdbcTemplate), id);
       } catch (DataAccessException e) {
           return null;
       }
    }

    @Override
    public List<Book> retrieveNRandomBooks(int n) {
        try {
            return jdbcTemplate.query(SqlQueries.selectNRandomBooks, new BookRowMapper(jdbcTemplate), n);
        }
        catch (DataAccessException e) {
            return null;
        }
    }

}
