package com.doyoucode.book_store.mapper;

import com.doyoucode.book_store.dto.BookDto;
import com.doyoucode.book_store.entity.Book;

public class BookMapper {

    public static BookDto toDto(Book book){

        return new BookDto(
                book.bookId(),
                book.name(),
                book.price(),
                book.author(),
                book.description()
        );
    }

    public static Book toEntity(BookDto bookDto){

        return new Book(
                bookDto.bookId(),
                bookDto.name(),
                bookDto.price(),
                bookDto.author(),
                bookDto.description()
        );
    }
}
