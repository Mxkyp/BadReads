package mxkcpy.badreads.exceptions;

public class InvalidBookIdException extends RuntimeException {
    public InvalidBookIdException(int bookId) {
        super(bookId + " is not a valid book id");
    }
}
