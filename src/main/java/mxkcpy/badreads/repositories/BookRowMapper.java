package mxkcpy.badreads.repositories;

import mxkcpy.badreads.data.Book;
import mxkcpy.badreads.data.BookDetails;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.zip.DataFormatException;

public class BookRowMapper implements RowMapper<Book> {
    JdbcTemplate jdbcTemplate;

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

    private Book extractBookFrom(ResultSet rs) throws SQLException {
        int id = rs.getInt("id");
        String isbn13 = rs.getString(2);
        String isbn10 = rs.getString(3);
        String title = rs.getString(4);
        String subtitle = rs.getString(5);
        BookDetails.Author author = new BookDetails.Author(rs.getString(6), rs.getString(7));
        List<String> categories = findAllCategories(id);
        String thumbnail = rs.getString(8);
        String description = rs.getString(9);
        String publishedYear = rs.getString(10);
        double averageRating = rs.getDouble(11);
        int numberOfPages = rs.getInt(12);

        return new Book(id, new BookDetails(isbn13, isbn10, title, subtitle,
                author, categories, thumbnail,
                description, publishedYear, averageRating, numberOfPages));
    }
}
