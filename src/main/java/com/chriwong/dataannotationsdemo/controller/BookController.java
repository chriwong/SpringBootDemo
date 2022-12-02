package com.chriwong.dataannotationsdemo.controller;

import com.chriwong.dataannotationsdemo.dto.BookDto;
import com.chriwong.dataannotationsdemo.repository.BookRepository;
import com.chriwong.dataannotationsdemo.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/book/{title}")
    public BookDto getBook(@PathVariable String title) {
        return this.bookService.getBookByTitle(title);
    }

    @GetMapping("/book")
    public BookDto findBook(@RequestParam String title) {
        return this.bookService.getBookByTitle(title);
    }

    @PostMapping("/book")
    public void createBook(@RequestBody BookDto bookToCreate) {

    }

    @DeleteMapping(value = "/book")
    public void deleteABook() {

    }

    @GetMapping("/books")
    public List<String> getSomeBooks(String titleContains) {

        // TODO - implementation
        return null;
    }
}
