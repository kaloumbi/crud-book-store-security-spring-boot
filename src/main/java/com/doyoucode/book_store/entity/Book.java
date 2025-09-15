package com.doyoucode.book_store.entity;

public record Book(
        String bookId,
        String name,
        String author,
        String price,
        String description
) {
}
