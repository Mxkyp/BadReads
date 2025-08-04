package mxkcpy.badreads.repositories;

import mxkcpy.badreads.data.Book;
import mxkcpy.badreads.data.BookDetails;
import mxkcpy.badreads.data.BookEnums;
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

    public List<Book> findById(int id) {
        String sql = "SELECT (isbn).isbn13, (isbn).isbn10, title, subtitle,"
                + " authors[1].name, authors[1].surname, categories, thumbnail,"
                + " description, published_year, average_rating, number_of_pages,"
                + " ratings_count FROM public.books WHERE id = " + id;

        RowMapper<Book> bookRowMapper = (rs, rowNum) -> {
            try {
                BookDetails details = getBookDetails(rs);
                return new Book(id, details);
            } catch (DataFormatException e) {
                throw new RuntimeException(e);
            }
        };
       return jdbcTemplate.query(sql, bookRowMapper);
    }

    public BookDetails getBookDetails(ResultSet rs) throws SQLException, DataFormatException {
        String isbn13 = rs.getString(1);
        String isbn10 = rs.getString(2);
        String title = rs.getString(3);
        String subtitle = rs.getString(4);
        BookDetails.Author author = new BookDetails.Author(rs.getString(5), rs.getString(6));
        String categories = rs.getString(7);
        String thumbnail = rs.getString(8);
        String description = rs.getString(9);
        String publishedYear = rs.getString(10);
        double averageRating = rs.getDouble(11);
        int numberOfPages = rs.getInt(12);

        return new BookDetails(isbn13, isbn10, title, subtitle,
                List.of(author), List.of(BookEnums.Genre.ROMANCE), thumbnail,
                description, new Date(), averageRating, numberOfPages);
    }

    @Override
    public void getAll() throws DataFormatException {
       /* Book book1 = new Book(new BookDetails("9781234567890", "9781234567",
                "Winds of Freedom", null, List.of(new BookDetails.Author("John", "Smith")),
                List.of(BookEnums.Genre.HISTORICAL_FICTION, BookEnums.Genre.FICTION), "Url", "haha", new Date(),5));

        Book[] bookArr = new Book[]{book1};

        books = new HashMap<>(bookArr.length);

        for (Book b : bookArr) {
            books.put(b.getId(), b);
        }
        return books;
    }
        */
    }
}
