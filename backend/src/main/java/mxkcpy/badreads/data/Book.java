package mxkcpy.badreads.data;

public final class Book {

    private final BookDetails details;
    private final int id;

    public Book(int id, BookDetails details) {
        this.id = id;
        this.details = details;
    }

    public BookDetails getDetails() {
        return details;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Book)) {
            return false;
        }
        Book other = (Book) o;
        return this.id == other.id && this.details.equals(other.details);
    }

    public int getId() {
        return id;
    }
}
