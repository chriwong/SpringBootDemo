package com.chriwong.dataannotationsdemo.dto;

import com.chriwong.dataannotationsdemo.model.Author;
import com.chriwong.dataannotationsdemo.model.Book;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class AuthorDto {

    private String firstName;
    private String lastName;
    private String displayName;
    private List<String> titles;

    public AuthorDto(Author author) {
        this.firstName = author.getFirstName();
        this.lastName = author.getLastName();
        this.displayName = author.getFirstName() + " " + author.getLastName();

        List<String> titleList = new ArrayList<>();
        List<Book> authorBooks = author.getBooks();

        for (int i=0; i < authorBooks.size(); i++) {
            titleList.add(authorBooks.get(i).getTitle());
        }
        this.titles = titleList;
    }

}
