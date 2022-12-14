package com.chriwong.dataannotationsdemo.repository;

import com.chriwong.dataannotationsdemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    public Book findFirstByTitleContainsIgnoreCase(String searchText);          // get first
    public List<Book> findBooksByTitleContainingIgnoreCase(String searchText);  // get all

}
