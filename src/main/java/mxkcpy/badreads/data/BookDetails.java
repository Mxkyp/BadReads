package mxkcpy.badreads.data;

import mxkcpy.badreads.data.BookEnums.Genre;
import mxkcpy.badreads.data.BookEnums.CoverType;
import mxkcpy.badreads.data.BookEnums.Publisher;

import java.util.List;
import java.util.zip.DataFormatException;

public final class BookDetails {

    private final int pageNumber;
    private final CoverType coverType;
    private final String title;
    private final Author author;
    private final Publisher publisher;
    private final String isbn13;
    private final List<Genre> genres;

    public BookDetails(int pageNumber, CoverType coverType, String title, Author author, Publisher publisher,
                       String isbn13, List<Genre> genres) throws DataFormatException {

        DataValidator.validateTitle(title);
        DataValidator.validateAuthor(author);
        DataValidator.validateIsbn13(isbn13);

        this.pageNumber = pageNumber;
        this.coverType = coverType;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.isbn13 = isbn13;
        this.genres = genres;
    }


    public record Author(String Name, String Surname) { }

    private static final class DataValidator {

        DataValidator() {
            throw new UnsupportedOperationException("DataValidator is a utility class and cannot be instantiated");
        }

        private static void validateTitle(String title) throws DataFormatException {
            if (title == null || title.isEmpty() || title.length() > 100) {
                throw new DataFormatException("invalid Title");
            }
        }

        private static void validateAuthor(Author author) throws DataFormatException {
            if (author == null || !author.Name.matches("^[A-Z][a-z]{3,15}$") || !author.Surname.matches("^([A-Z]'[A-Z][a-z]{2,15})|(A-Z][a-z]{3,15}-[A-Z][a-z]{2,15})|([A-Z][a-z]{2,15})$")) {
                throw new DataFormatException("invalid author");
            }
        }

        private static void validateIsbn13(String isbn13) throws DataFormatException {
            if (isbn13 == null || !isbn13.matches("^\\d{13}$")) {
                throw new DataFormatException("invalid Isbn");
            }
        }
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public CoverType getCoverType() {
        return coverType;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public String getIsbn13() {
        return isbn13;
    }

    public List<Genre> getGenres() {
        return genres;
    }
}
