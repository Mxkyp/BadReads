package mxkcpy.badreads.data;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;
import java.util.zip.DataFormatException;

import static org.junit.jupiter.api.Assertions.*;

class BookDetailsTest {
    protected static BookDetails simpleCorrectBookDetails;

    private static final int pageNumber = 500;
    private static final CoverType coverType = CoverType.HARD_COVER;
    private static final String title = "Alice in Wonderland";
    private static final BookDetails.Author author = new BookDetails.Author("Lewis", "Carrol");
    private static final Publisher publisher = Publisher.MACMILLAN;
    private static final String isbn13 = "0123456789223";
    private static final List<Genre> genres = List.of(new Genre[]{Genre.FICTION, Genre.NOVEL});


    protected static void setUp() throws DataFormatException {
        simpleCorrectBookDetails = new BookDetails(pageNumber, coverType, title, author, publisher, isbn13, genres);
    }

    @Test
    void testIsbnValidation() {
        Random random = new Random();
        final String validIsbn = RandomStringUtils.random(13, 0, 0 ,false, true, null , random);
        final String invalidIsbn = RandomStringUtils.random(random.nextInt(0,10000), 0, 0 ,false, true, null , random);

        assertThrows(DataFormatException.class, () -> { new BookDetails(pageNumber, coverType, title, author, publisher, invalidIsbn, genres); });
        assertThrows(DataFormatException.class, () -> { new BookDetails(pageNumber, coverType, title, author, publisher, invalidIsbn, genres); });
        assertDoesNotThrow(() -> { new BookDetails(pageNumber, coverType, title, author, publisher, validIsbn, genres); });
    }

    @Test
    void testTitleValidation() {
        Random random = new Random();

        final String invalidTitle = RandomStringUtils.random(101, 0, 0 , true, false, new char[]{'a', 'b', 'c'}, random);
        final String validTitle = "Narnia";
        assertThrows(DataFormatException.class, () -> { new BookDetails(pageNumber, coverType, invalidTitle, author, publisher, isbn13, genres); } );
        assertDoesNotThrow(() -> { new BookDetails(pageNumber, coverType, validTitle, author, publisher, isbn13, genres); });
    }

    @Test
    void testAuthorValidation() {
        Random random = new Random();

        final String invalidName = RandomStringUtils.random(13, 0, 0 , true, false, new char[]{'a', 'b', 'c'}, random);
        final BookDetails.Author invalidAuthor = new BookDetails.Author(invalidName, "ac");
        final BookDetails.Author validAuthor = new BookDetails.Author("Sinead", "O'Connor");

        assertThrows(DataFormatException.class, () -> { new BookDetails(pageNumber, coverType, title, invalidAuthor, publisher, isbn13, genres); } );
        assertDoesNotThrow(() -> { new BookDetails(pageNumber, coverType, title, validAuthor, publisher, isbn13, genres); });
    }

}