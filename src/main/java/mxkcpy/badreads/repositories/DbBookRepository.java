package mxkcpy.badreads.repositories;

import mxkcpy.badreads.data.Book;
import mxkcpy.badreads.data.BookDetails;
import mxkcpy.badreads.data.BookEnums;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;
import java.util.zip.DataFormatException;

@Repository
public class DbBookRepository implements BookRepository {
    List<Book> books;

    @Override
    public Book findById(long id) {
        return null;
    }

    @Override
    public List<Book> getAll() throws DataFormatException {
        Book book1 = new Book(new BookDetails(
                320,
                BookEnums.CoverType.HARD_COVER,
                "Winds of Freedom",
                new BookDetails.Author("John", "Smith"),
                BookEnums.Publisher.MACMILLAN,
                "9781234567890",
                List.of(BookEnums.Genre.HISTORICAL_FICTION, BookEnums.Genre.FICTION)
        ));

        Book book2 = new Book(new BookDetails(
                210,
                BookEnums.CoverType.SOFT_COVER,
                "Love in Autumn",
                new BookDetails.Author("Anna", "Taylor"),
                BookEnums.Publisher.MACMILLAN,
                "9780987654321",
                List.of(BookEnums.Genre.ROMANCE)
        ));

        Book book3 = new Book(new BookDetails(
                400,
                BookEnums.CoverType.HARD_COVER,
                "The Hidden Truth",
                new BookDetails.Author("Mark", "O'Neill"),
                BookEnums.Publisher.MACMILLAN,
                "9781112223334",
                List.of(BookEnums.Genre.THRILLER, BookEnums.Genre.NOVEL)
        ));

        Book book4 = new Book(new BookDetails(
                150,
                BookEnums.CoverType.EBOOK,
                "Mindset Reset",
                new BookDetails.Author("Liam", "Clark"),
                BookEnums.Publisher.MACMILLAN,
                "9789998887776",
                List.of(BookEnums.Genre.SELF_HELP)
        ));

        Book book5 = new Book(new BookDetails(
                500,
                BookEnums.CoverType.SOFT_COVER,
                "Echoes of the Past",
                new BookDetails.Author("Grace", "Anderson"),
                BookEnums.Publisher.MACMILLAN,
                "9784445556667",
                List.of(BookEnums.Genre.HISTORICAL)
        ));

        Book[] bookArr = new Book[]{book1, book2, book3, book4, book5};

        books = Arrays.asList(bookArr);
        return books;
    }
}
