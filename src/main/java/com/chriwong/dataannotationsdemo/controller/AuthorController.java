package com.chriwong.dataannotationsdemo.controller;

import com.chriwong.dataannotationsdemo.dto.AuthorDto;
import com.chriwong.dataannotationsdemo.service.AuthorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class AuthorController {

    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    /**
     * Gets any authors whose name fields (first, last) match the provided parameters.
     */
    @GetMapping("/authors")
    public List<AuthorDto> getAuthors(@RequestParam(required = false) String lastName,
                                      @RequestParam(required = false) String firstName) {
        List<AuthorDto> authors = authorService.getAuthors(firstName, lastName);
        log.info(String.format("Got authors: %s", authors));
        return authors;
    }

}
