package com.chriwong.dataannotationsdemo.service;

import com.chriwong.dataannotationsdemo.dto.AuthorDto;
import com.chriwong.dataannotationsdemo.model.Author;
import com.chriwong.dataannotationsdemo.model.Book;
import com.chriwong.dataannotationsdemo.repository.AuthorRepository;
import com.chriwong.dataannotationsdemo.repository.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class MyService {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    public boolean doUpdates() {
        Author thisShouldBeHemingway = authorRepository.findFirstByLastNameLikeIgnoreCase("hemingway");
        if (thisShouldBeHemingway == null) {
            log.error("Could not find Hemingway");
            return false;
        }

        Book thisShouldBeTheSunAlsoRises = bookRepository.findFirstByTitleContainsIgnoreCase("also rises");
        if (thisShouldBeTheSunAlsoRises == null) {
            log.error("Could not find The Sun Also Rises");
            return false;
        }

        Book thisShouldBeAFarewellToArms = bookRepository.findFirstByTitleContainsIgnoreCase("farewell");
        if (thisShouldBeAFarewellToArms == null) {
            log.error("Could not find A Farewell to Arms");
            return false;
        }

        Book thisShouldBeForWhomTheBellTolls = bookRepository.findFirstByTitleContainsIgnoreCase("tolls");
        if (thisShouldBeForWhomTheBellTolls == null) {
            log.error("Could not find For Whom the Bell Tolls");
            return false;
        }

        Book thisShouldBeOldManAndTheSea = bookRepository.findFirstByTitleContainsIgnoreCase("old");
        if (thisShouldBeOldManAndTheSea == null) {
            log.error("Could not find The Old Man and the Sea");
            return false;
        }

        thisShouldBeTheSunAlsoRises.setAuthor(thisShouldBeHemingway);
        thisShouldBeAFarewellToArms.setAuthor(thisShouldBeHemingway);
        thisShouldBeForWhomTheBellTolls.setAuthor(thisShouldBeHemingway);
        thisShouldBeOldManAndTheSea.setAuthor(thisShouldBeHemingway);
        thisShouldBeHemingway.getBooks().add(thisShouldBeTheSunAlsoRises);
        thisShouldBeHemingway.getBooks().add(thisShouldBeAFarewellToArms);
        thisShouldBeHemingway.getBooks().add(thisShouldBeForWhomTheBellTolls);
        thisShouldBeHemingway.getBooks().add(thisShouldBeOldManAndTheSea);
        authorRepository.save(thisShouldBeHemingway);
        bookRepository.save(thisShouldBeTheSunAlsoRises);
        bookRepository.save(thisShouldBeAFarewellToArms);
        bookRepository.save(thisShouldBeForWhomTheBellTolls);
        bookRepository.save(thisShouldBeOldManAndTheSea);
        log.info("Success - Hemingway and his books have been updated!");
        return true;
    }

    public AuthorDto getAuthor(String lastName) {
        Author singleAuthorWithLastName = authorRepository.findFirstByLastNameLikeIgnoreCase(lastName);
        if (singleAuthorWithLastName == null) {
            log.error("Could not find author with last name: " + lastName);
            return null;
        }
        return new AuthorDto(singleAuthorWithLastName);
    }


    public List<Author> getAllAuthors() {
        List<Author> authors = (List<Author>) this.authorRepository.findAll();
        log.info("Got authors from repository: " + authors);
        return authors;
    }

    public List<Book> getAllBooks() {
        List<Book> allBooks = this.bookRepository.findAll();
        log.info("Got books from repository: " + allBooks.stream().map(book -> book.getTitle() + " ").reduce("", String::concat));
        return allBooks;
    }
}
