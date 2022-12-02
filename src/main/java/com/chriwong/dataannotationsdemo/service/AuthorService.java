package com.chriwong.dataannotationsdemo.service;

import com.chriwong.dataannotationsdemo.dto.AuthorDto;
import com.chriwong.dataannotationsdemo.model.Author;
import com.chriwong.dataannotationsdemo.repository.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.NotImplementedException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    private List<AuthorDto> searchAuthors(String firstName, String lastName) {
        return this.authorRepository.findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(firstName, lastName)
                .stream()
                .map(AuthorDto::new)
                .collect(Collectors.toList());
    }
    private List<AuthorDto> searchAuthorsFirstName(String firstName) {
        return this.authorRepository.findByFirstNameContainingIgnoreCase(firstName)
                .stream()
                .map(AuthorDto::new)
                .collect(Collectors.toList());
    }
    private List<AuthorDto> searchAuthorsLastName(String lastName) {
        return this.authorRepository.findByLastNameContainingIgnoreCase(lastName)
                .stream()
                .map(AuthorDto::new)
                .collect(Collectors.toList());
    }

    public List<AuthorDto> getAuthors(String firstName, String lastName) {
        List<AuthorDto> searchResults = null;

        if (StringUtils.isNotBlank(firstName) && StringUtils.isNotBlank(lastName)) {
            searchResults = this.searchAuthors(firstName, lastName);
        } else if (StringUtils.isNotBlank(lastName)) {
            searchResults  = this.searchAuthorsLastName(lastName);
        } else if (StringUtils.isNotBlank(firstName)) {
            searchResults = this.searchAuthorsFirstName(firstName);
        } else {
            searchResults = Collections.emptyList();
        }
        return searchResults;
    }

    public void addAuthor(AuthorDto authorDto) {
        Author author = new Author();
        author.setFirstName(authorDto.getFirstName());
        author.setLastName(authorDto.getLastName());
        this.authorRepository.save(author);
    }

    public void addAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        this.authorRepository.save(author);
    }
}
