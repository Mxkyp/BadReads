package mxkcpy.badreads.data;

import java.util.List;

public class FreeUser implements User {

    String name;
    List<Book> booksRead;

    @Override
    public String getStats() {
        return "";
    }

    @Override
    public List<Book> getBooksRead() {
        return List.of();
    }

    @Override
    public String getUsername() {
        return "";
    }
}
