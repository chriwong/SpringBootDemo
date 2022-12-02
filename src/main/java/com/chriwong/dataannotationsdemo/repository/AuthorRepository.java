package com.chriwong.dataannotationsdemo.repository;

import com.chriwong.dataannotationsdemo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {

    public List<Author> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstName, String lastName);
    public List<Author> findByFirstNameContainingIgnoreCase(String firstName);
    public List<Author> findByLastNameContainingIgnoreCase(String lastName);


    // change "HairColor" to "ShoelaceColor" below and IntelliJ _should_ give a warning
    // uncomment shoelaceColor in Author.java and the warning should go away
    // IntelliJ is very smart!
    public Object findDistinctByHairColorIsNotAndEyeColorEndingWith(String hairColor, String eyeColor);

}
