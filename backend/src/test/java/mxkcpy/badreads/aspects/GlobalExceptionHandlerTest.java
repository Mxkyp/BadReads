package mxkcpy.badreads.aspects;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.http.HttpStatus.*;
import mxkcpy.badreads.exceptions.InvalidBookIdException;
import mxkcpy.badreads.exceptions.NoBooksFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.ResponseEntity;

public class GlobalExceptionHandlerTest {

    private GlobalExceptionHandler exceptionHandler;

    @BeforeEach
    void setUp() {
        exceptionHandler = new GlobalExceptionHandler();
    }

    @Test
    void handleInvalidBookIdException_ShouldReturnNotFoundResponse() {
        int bookId = 2;
        InvalidBookIdException ex = new InvalidBookIdException(bookId);
        String errorMessage = bookId + " is not a valid book id";

        ResponseEntity<?> responseEntity = exceptionHandler.handleInvalidBookIdException(ex);

        assertEquals(NOT_FOUND, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        GlobalExceptionHandler.ErrorResponse body = (GlobalExceptionHandler.ErrorResponse) responseEntity.getBody();

        assertEquals(NOT_FOUND.value(), body.getStatus());
        assertEquals(errorMessage, body.getMessage());
    }

    @Test
    void handleNoBookReturned_ShouldReturnInternalServerErrorResponse() {
        String errorMessage = "Could not find any books";
        NoBooksFoundException ex = new NoBooksFoundException();

        ResponseEntity<?> responseEntity = exceptionHandler.handleNoBookReturned(ex);

        assertEquals(INTERNAL_SERVER_ERROR, responseEntity.getStatusCode());
        assertNotNull(responseEntity.getBody());
        GlobalExceptionHandler.ErrorResponse body = (GlobalExceptionHandler.ErrorResponse) responseEntity.getBody();

        assertEquals(INTERNAL_SERVER_ERROR.value(), body.getStatus());
        assertEquals(errorMessage, body.getMessage());
    }
}
