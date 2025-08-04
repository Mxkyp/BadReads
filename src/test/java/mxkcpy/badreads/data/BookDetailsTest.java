package mxkcpy.badreads.data;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.zip.DataFormatException;

import static org.junit.jupiter.api.Assertions.*;

class BookDetailsTest {
    protected static BookDetails simpleCorrectBookDetails;

    private static final String isbn13 = "9781234567890";
    private static final String isbn10 = "9781234567";
    private static final String title = "Winds of Freedom";
    private static final String subtitle = null;
    private static final List<BookDetails.Author> authors = List.of(new BookDetails.Author("John", "Smith"));
    private static final List<Genre> genres = List.of(BookEnums.Genre.HISTORICAL_FICTION, BookEnums.Genre.FICTION);
    private static final String thumbnailUrl = "url";
    private static final String description = "haha";
    private static final Date publishedDate = new Date();
    private static final int pageNumber = 5;


    protected static void setUp() throws DataFormatException {
        simpleCorrectBookDetails = new BookDetails(isbn13, isbn10, title, subtitle, authors, genres, thumbnailUrl, description, publishedDate, pageNumber);
    }

    @Test
    void testIsbnValidation() {
        Random random = new Random();
        final String validIsbn13 = RandomStringUtils.random(13, 0, 0 ,false, true, null , random);
        final String invalidIsbn13 = RandomStringUtils.random(random.nextInt(0,10000), 0, 0 ,false, true, null , random);

        assertThrows(DataFormatException.class, () -> {
            simpleCorrectBookDetails = new BookDetails(invalidIsbn13, isbn10, title, subtitle, authors, genres, thumbnailUrl, description, publishedDate, pageNumber);
        });

        assertDoesNotThrow(() -> {
            simpleCorrectBookDetails = new BookDetails(validIsbn13, isbn10, title, subtitle, authors, genres, thumbnailUrl, description, publishedDate, pageNumber);
        });
    }

    @Test
    void testTitleValidation() {
        Random random = new Random();

        final String invalidTitle = RandomStringUtils.random(101, 0, 0 , true, false, new char[]{'a', 'b', 'c'}, random);
        final String validTitle = "Narnia";
        assertThrows(DataFormatException.class, () -> {
            simpleCorrectBookDetails = new BookDetails(isbn13, isbn10, invalidTitle, subtitle, authors, genres, thumbnailUrl, description, publishedDate, pageNumber);
        });

        assertDoesNotThrow(() -> {
            simpleCorrectBookDetails = new BookDetails(isbn13, isbn10, validTitle, subtitle, authors, genres, thumbnailUrl, description, publishedDate, pageNumber);
        });
    }

    @Test
    void testAuthorValidation() {
        Random random = new Random();

        final String invalidName = RandomStringUtils.random(13, 0, 0 , true, false, new char[]{'a', 'b', 'c'}, random);
        final BookDetails.Author invalidAuthor = new BookDetails.Author(invalidName, "ac");
        final BookDetails.Author validAuthor = new BookDetails.Author("Sinead", "O'Connor");

        assertThrows(DataFormatException.class, () -> {
            simpleCorrectBookDetails = new BookDetails(isbn13, isbn10, title, subtitle, List.of(invalidAuthor), genres, thumbnailUrl, description, publishedDate, pageNumber);
        });

        assertDoesNotThrow(() -> {
            simpleCorrectBookDetails = new BookDetails(isbn13, isbn10, title, subtitle, List.of(validAuthor), genres, thumbnailUrl, description, publishedDate, pageNumber);
        });
    }

}