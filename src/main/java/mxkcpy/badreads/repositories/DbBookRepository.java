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

    public Book findById(int id) {
        String sql = "SELECT id, (isbn).isbn13, (isbn).isbn10, title, subtitle,"
                + " (author).name, (author).surname, thumbnail,"
                + " description, published_year, average_rating, number_of_pages,"
                + " ratings_count FROM public.books WHERE id = " + id;
        List<String> categories = findAllCategories(id);

       return jdbcTemplate.queryForObject(sql, new BookRowMapper(categories));
    }

    public List<String> findAllCategories(int id) {
        String sql = "SELECT type from categories c"
                + " inner join books_categories b on c.id = b.category_id and b.book_id = " + id;

        RowMapper<String> categoryRowMapper = (rs, rowNum) -> {
            return rs.getString("type");
        };

        return jdbcTemplate.query(sql, categoryRowMapper);
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
