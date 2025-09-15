package com.doyoucode.book_store.service.impl;

import com.doyoucode.book_store.dto.BookDto;
import com.doyoucode.book_store.entity.Book;
import com.doyoucode.book_store.mapper.BookMapper;
import com.doyoucode.book_store.repository.BookRepository;
import com.doyoucode.book_store.service.BookService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {

    BookRepository bookRepository;


    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }


    @Override
    public BookDto getBook(String bookId) {
        Book book = bookRepository.findBookByBookId(bookId);

        if (book == null)
            throw new IllegalArgumentException("Aucun livre trouvé 1!");

        if (! bookId.equals(book.bookId())){
            throw new IllegalArgumentException("Aucun livre trouvé !");
        }
        return BookMapper.toDto(book);
    }

    @Override
    public List<BookDto> getAllBooks() {

        List<Book> bookList = bookRepository.findAll();

        List<BookDto> bookDtoList = new ArrayList<>();
        for (Book book: bookList){
            bookDtoList.add(BookMapper.toDto(book));
        }
        return bookDtoList;
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = bookRepository.insert(BookMapper.toEntity(bookDto));

        return BookMapper.toDto(book);
    }

    @Override
    public BookDto updateByBookName(BookDto bookDto) {

        bookRepository.updateBookNameByBookId(bookDto.bookId(), bookDto.name());
        Book book = bookRepository.findBookByBookId(bookDto.bookId());

        return BookMapper.toDto(book);
    }

    @Override
    public void deleteBook(String bookId) {
        bookRepository.deleteBookByBookId(bookId);
    }
}
