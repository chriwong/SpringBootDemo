package com.chriwong.dataannotationsdemo.model;

import com.chriwong.dataannotationsdemo.model.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int publishYear;

    private String publisher;

    private Integer reviewRating;

    private String reviewDescription;

    @ManyToOne
    private Author author;


    public Book(String title, int publishYear) {
        this.title = title;
        this.publishYear = publishYear;
    }

}
