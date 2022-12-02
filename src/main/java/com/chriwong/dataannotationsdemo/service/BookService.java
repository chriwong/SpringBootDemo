package com.chriwong.dataannotationsdemo.service;

import com.chriwong.dataannotationsdemo.dto.BookDto;
import com.chriwong.dataannotationsdemo.model.Book;
import com.chriwong.dataannotationsdemo.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookDto getBookByTitle(String title) {
        Book book = this.bookRepository.findFirstByTitleContainsIgnoreCase(title);
        return new BookDto(book);
    }
}
