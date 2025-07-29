package mxkcpy.badreads.data;

import java.util.List;

public interface User {

    String getUsername();

    String getStats();

    List<Book> getBooksRead();
}
