package com.chriwong.dataannotationsdemo.controller;

import com.chriwong.dataannotationsdemo.client.NobelPrize;
import com.chriwong.dataannotationsdemo.dto.AuthorDto;
import com.chriwong.dataannotationsdemo.dto.BookDto;
import com.chriwong.dataannotationsdemo.service.MyService;
import com.chriwong.dataannotationsdemo.service.NobelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class MyController {

    @Autowired
    private MyService myService;
    @Autowired
    private NobelService nobelService;

    /**
     * Attempts to "link" the database entries for Ernest Hemingway and the books he wrote
     * (The Sun Also Rises, A Farewell to Arms, For Whom the Bell Tolls, The Old Man and the Sea).
     * @return Success/failure message
     */
    @GetMapping("/update-models")
    public String updateModels() {
        boolean success = myService.doUpdates();
        return success
            ? "Successfully updated Ernest Hemingway with his books"
            : "Failed to update...";
    }

    /**
     * Gets the first author from the database with the given last name.
     * @param lastName last name of the desired author.
     * @return An <c>AuthorDto</c>
     */
    @GetMapping("/author")
    public AuthorDto getAuthor(@RequestParam String lastName) {
        AuthorDto dto = myService.getAuthor(lastName);
        log.info(String.format("Got author: %s", dto.getDisplayName()));
        return dto;
    }

    /**
     * Gets the first book from the database with the given title.
     * @param title title of the book.
     * @return A <c>BookDto</c>
     */
    @GetMapping("/book")
    public BookDto getBook(@RequestParam String title) {
        BookDto dto = myService.getBook(title);
        log.info(String.format("Got book: %s", dto.getTitle()));
        return dto;
    }

    @GetMapping("/nobel-prizes")
    public List<NobelPrize> getNBPrizes(
            @RequestParam(required = false, defaultValue = "1997") Integer year,
            @RequestParam(required = false, defaultValue = "phy") String category) {
        return nobelService.getNobelLaureates(year, category);
    }
}
