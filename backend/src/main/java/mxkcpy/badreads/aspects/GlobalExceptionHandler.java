package mxkcpy.badreads.aspects;

import mxkcpy.badreads.exceptions.InvalidBookIdException;
import mxkcpy.badreads.exceptions.NoBooksFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(InvalidBookIdException.class)
    public ResponseEntity<ErrorResponse> handleInvalidBookIdException(InvalidBookIdException ex) {
        ErrorResponse response =  new ErrorResponse(HttpStatus.NOT_FOUND, ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(NoBooksFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoBookReturned(NoBooksFoundException ex) {
        ErrorResponse response =  new ErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }

    final class ErrorResponse {
        private final HttpStatus status;
        private final String message;

        public ErrorResponse(HttpStatus status, String message) {
            this.status = status;
            this.message = message;
        }

        public int getStatus() {
            return status.value();
        }

        public String getMessage() {
            return message;
        }
    }


}
