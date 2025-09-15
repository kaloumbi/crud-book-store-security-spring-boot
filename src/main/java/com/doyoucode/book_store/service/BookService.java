package com.doyoucode.book_store.service;

import com.doyoucode.book_store.dto.BookDto;

import java.util.List;

public interface BookService {

    public BookDto getBook(String bookId);

    public List<BookDto> getAllBooks();

    public BookDto createBook(BookDto bookDto);

    public BookDto updateByBookName(BookDto bookDto);

    public void deleteBook(String bookId);
}
