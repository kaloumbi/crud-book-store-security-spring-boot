package com.doyoucode.book_store.dto;

public record BookDto(
        String bookId,
        String name,
        String author,
        String price,
        String description
) {
}
