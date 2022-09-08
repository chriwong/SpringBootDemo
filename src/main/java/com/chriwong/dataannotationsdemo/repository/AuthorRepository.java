package com.chriwong.dataannotationsdemo.repository;

import com.chriwong.dataannotationsdemo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    public List<Author> findByLastName(String lastName);
    public Author findFirstByLastNameLikeIgnoreCase(String lastName);

}
