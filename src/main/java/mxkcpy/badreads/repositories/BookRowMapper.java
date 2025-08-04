package mxkcpy.badreads.repositories;

import mxkcpy.badreads.data.Book;
import mxkcpy.badreads.data.BookDetails;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;

public class BookRowMapper implements RowMapper<Book> {
    private List<String> genres;

    public BookRowMapper(List<String> genres) {
        this.genres = genres;
    }

    @Override
    public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
        try {
            return getBook(rs, genres);
        } catch (DataFormatException e) {
            throw new RuntimeException(e);
        }
    }


    private Book getBook(ResultSet rs, List<String> categories) throws SQLException, DataFormatException {
        int id = rs.getInt("id");
        String isbn13 = rs.getString(2);
        String isbn10 = rs.getString(3);
        String title = rs.getString(4);
        String subtitle = rs.getString(5);
        BookDetails.Author author = new BookDetails.Author(rs.getString(6), rs.getString(7));
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
