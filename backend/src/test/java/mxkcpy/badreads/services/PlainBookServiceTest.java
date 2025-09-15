package mxkcpy.badreads.services;

import mxkcpy.badreads.data.Book;
import mxkcpy.badreads.exceptions.InvalidBookIdException;
import mxkcpy.badreads.exceptions.NoBooksFoundException;
import mxkcpy.badreads.repositories.BookRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Random;

import static org.mockito.BDDMockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PlainBookServiceTest {
    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private PlainBookService bookService;

    @Test
    void getRandomBooksHappyFlow() {
        Random random = new Random();
        given(bookRepository.retrieveRandomBook()).willReturn(new Book(5, Mockito.mock(Book.Author.class), Mockito.mock(Book.Metadata.class)));

        List<Book> result = bookService.getRandomBooks(1);
        assertEquals(1, result.size());
        assertEquals(5, result.get(0).id());
    }

    @Test
    void getBookByIdHappyFlow() {
        Book book = new Book(2, Mockito.mock(Book.Author.class), Mockito.mock(Book.Metadata.class));
        given(bookRepository.findById(book.id())).willReturn(book);

        Book result = bookService.getBookById(book.id());
        assertEquals(result.id(), book.id());
        assertEquals(book, result);
    }

    @Test
    void getRandomBookNotFound() {
        given(bookRepository.retrieveRandomBook()).willReturn(null);

        assertThrows(NoBooksFoundException.class, () -> bookService.getRandomBooks(5));
    }

    @Test
    void getBookByIdNotFound() {
        Book book = new Book(2, Mockito.mock(Book.Author.class), Mockito.mock(Book.Metadata.class));
        given(bookRepository.findById(book.id())).willReturn(book);
        given(bookRepository.findById(3)).willReturn(null);

        assertDoesNotThrow(() -> bookService.getBookById(book.id()));
        assertThrows(InvalidBookIdException.class, () -> bookService.getBookById(3));
    }


}
