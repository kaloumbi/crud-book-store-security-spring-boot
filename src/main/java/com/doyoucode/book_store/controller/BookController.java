package com.doyoucode.book_store.controller;

import com.doyoucode.book_store.dto.BookDto;
import com.doyoucode.book_store.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/book-store")
@EnableMethodSecurity
public class BookController {

    BookService bookService;

    public BookController(BookService bookService){
        this.bookService = bookService;
    }

    @GetMapping("/welcome")
    public ResponseEntity<String> welcomeMessage(){
        return new ResponseEntity<>("Welcome to my application !", HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    @PreAuthorize("hasRole('USER')")
    public ResponseEntity<BookDto> getBook(@PathVariable String bookId){

        BookDto bookDto = bookService.getBook(bookId);

        return new ResponseEntity<>(bookDto, HttpStatus.OK);
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<BookDto>> getAllBooks(){

        List<BookDto> bookDtoList = bookService.getAllBooks();

        return new ResponseEntity<>(bookDtoList, HttpStatus.OK);
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BookDto> createBooks(@RequestBody BookDto bookDto){

        BookDto bookDtoBack = bookService.createBook(bookDto);
        return new ResponseEntity<>(bookDtoBack, HttpStatus.OK);
    }

    @PutMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto){

        BookDto bookDtoBack = bookService.updateByBookName(bookDto);
        return new ResponseEntity<>(bookDtoBack, HttpStatus.OK);
    }

    @DeleteMapping("/{bookId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> deleteBook(@PathVariable String bookId){
        bookService.deleteBook(bookId);
        return new ResponseEntity<>("Book deleted successfully !" + bookId, HttpStatus.OK);
    }
}
