package mxkcpy.badreads.data;

public final class Book {

    private final BookDetails details;
    private final int id;

    public Book(BookDetails details) {
        this.details = details;
        id = details.getIsbn13().hashCode();
    }

    public Book(int id, BookDetails details) {
        this.id = id;
        this.details = details;
    }

    public BookDetails getDetails() {
        return details;
    }

    public int getId() {
        return id;
    }
}
