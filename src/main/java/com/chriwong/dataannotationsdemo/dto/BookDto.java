package com.chriwong.dataannotationsdemo.dto;

import com.chriwong.dataannotationsdemo.model.Book;
import lombok.Data;

@Data
public class BookDto {

    private String title;
    private int publishYear;
    private String author;

    public BookDto(Book book) {
        this.title = book.getTitle();
        this.publishYear = book.getPublishYear();
        this.author = book.getAuthor().getFirstName() + " " + book.getAuthor().getLastName();
    }

}
