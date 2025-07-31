package mxkcpy.badreads.data;

import mxkcpy.badreads.data.BookEnums.Genre;
import java.util.Date;
import java.util.List;
import java.util.zip.DataFormatException;

public final class BookDetails {

    private final String isbn13;
    private final String isbn10;
    private final String title;
    private final String subtitle;
    private final List<Author> authors;
    private final List<Genre> genres;
    private final String thumbnailUrl;
    private final String description;
    private final Date publishedDate;
    private final int pageNumber;

    public BookDetails(String isbn13, String isbn10, String title,
                       String subtitle, List<Author> authors,
                       List<Genre> genres, String thumbnailUrl, String description,
                       Date publishedDate, int pageNumber) throws DataFormatException {

        DataValidator.validateTitle(title);
        for (Author author : authors) {
            DataValidator.validateAuthor(author);
        }
        DataValidator.validateIsbn13(isbn13);
        DataValidator.validateIsbn10(isbn10);

        this.isbn13 = isbn13;
        this.isbn10 = isbn10;
        this.title = title;
        this.subtitle = subtitle;
        this.authors = authors;
        this.genres = genres;
        this.thumbnailUrl = thumbnailUrl;
        this.description = description;
        this.publishedDate = publishedDate;
        this.pageNumber = pageNumber;
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

        private static void validateIsbn10(String isbn10) throws DataFormatException {
            if (isbn10 == null || !isbn10.matches("^\\d{10}$")) {
                throw new DataFormatException("invalid Isbn");
            }
        }
    }

    public String getIsbn13() {
        return isbn13;
    }

    public String getIsbn10() {
        return isbn10;
    }

    public String getTitle() {
        return title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public String getDescription() {
        return description;
    }

    public Date getPublishedDate() {
        return publishedDate;
    }

    public int getPageNumber() {
        return pageNumber;
    }
}
