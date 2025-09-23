package mxkcpy.badreads.exceptions;

public class NoBooksFoundException extends RuntimeException {
    public NoBooksFoundException() {
        super("Could not find the desired number of books");
    }
}
