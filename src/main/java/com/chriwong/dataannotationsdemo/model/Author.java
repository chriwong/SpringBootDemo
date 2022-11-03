package com.chriwong.dataannotationsdemo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    private Integer birthYear;
    private String birthPlace;
    private Integer deathYear;
    private String deathPlace;
    private String education;
    private String contactInfo;
    private String workHistory;
    private String hairColor;
    private String eyeColor;
//    private String shoelaceColor;
    private int age;
    private String creditCardNumber;
    private String creditCardPIN;
    private String creditCardCVV;

    @ElementCollection
    private List<String> pseudonyms;

    @OneToMany(mappedBy = "author")
    private List<Book> books;


    public Author(String firstName, String lastName, Integer birthYear, String birthPlace) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.birthPlace = birthPlace;
    }

    public Author(String firstName, String lastName, Integer birthYear, String birthPlace, Integer deathYear, String deathPlace) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.birthPlace = birthPlace;
        this.deathYear = deathYear;
        this.deathPlace = deathPlace;
    }
}
