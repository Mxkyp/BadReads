package mxkcpy.badreads.repositories;

import mxkcpy.badreads.data.Book;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookRowMapper implements RowMapper<Book> {
    private final JdbcTemplate jdbcTemplate;

    public BookRowMapper(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        return extractBookFrom(rs);
    }

    private List<String> findAllCategories(int bookId) {
        RowMapper<String> categoryRowMapper = (rs, rowNum) -> {
            return rs.getString("type");
        };

        return jdbcTemplate.query(SqlQueries.selectBookCategories, categoryRowMapper, bookId);
    }

    private Book.Metadata extractMetadataFrom(final ResultSet rs, final int id) throws SQLException {
        String isbn13 = rs.getString(2);
        String isbn10 = rs.getString(3);
        String title = rs.getString(4);
        String subtitle = rs.getString(5);
        String thumbnail = rs.getString(8);
        List<String> categories = findAllCategories(id);
        String description = rs.getString(9);
        String publishedYear = rs.getString(10);
        double averageRating = rs.getDouble(11);
        int numberOfPages = rs.getInt(12);

        return new Book.Metadata(isbn13, isbn10, title,
                                subtitle,categories, thumbnail,
                                description, publishedYear, averageRating, numberOfPages);
    }

    private Book extractBookFrom(final ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        Book.Author author = new Book.Author(rs.getString(6), rs.getString(7));
        Book.Metadata metadata = extractMetadataFrom(rs, id);

        return new Book(id, author, metadata);
    }
}
