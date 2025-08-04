package mxkcpy.badreads.repositories;

public final class SqlQueries {
    private SqlQueries() {
        throw new IllegalStateException("Utility class");
    }

    public static final String getBookNumber = "SELECT COUNT(*) FROM books";
    public static final String selectBook = "SELECT id, (isbn).isbn13, (isbn).isbn10, title, subtitle,"
            + " (author).name, (author).surname, thumbnail,"
            + " description, published_year, average_rating, number_of_pages,"
            + " ratings_count FROM public.books WHERE id = ?";

    public static final String selectRandomBook = "SELECT id, (isbn).isbn13, (isbn).isbn10, title, subtitle,"
            + " (author).name, (author).surname, thumbnail,"
            + " description, published_year, average_rating, number_of_pages,"
            + " ratings_count FROM public.books ORDER BY RANDOM() LIMIT 1";

    public static final String selectBookCategories = "SELECT type from categories c"
            + " inner join books_categories b on c.id = b.category_id and b.book_id = ?";
}

