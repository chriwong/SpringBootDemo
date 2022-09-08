package com.chriwong.dataannotationsdemo;

import com.chriwong.dataannotationsdemo.model.Author;
import com.chriwong.dataannotationsdemo.model.Book;
import com.chriwong.dataannotationsdemo.repository.AuthorRepository;
import com.chriwong.dataannotationsdemo.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DataAnnotationsDemoApplication {

	private static final Logger log = LoggerFactory.getLogger(DataAnnotationsDemoApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(DataAnnotationsDemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(AuthorRepository authorRepository, BookRepository bookRepository) {
		return (args) -> {
			List<Author> authorSeeder = new ArrayList<>(7);
			authorSeeder.add(new Author("Harper", "Lee", 1926, "Monroeville, Alabama", 2016, "Monroeville, Alabama"));
			authorSeeder.add(new Author("Ernest", "Hemingway", 1899,  "Oak Park, Illinois", 1961, "Ketchum, Idaho"));
			authorSeeder.add(new Author("Ted", "Chiang", 1967, "Port Jefferson, New York"));
			authorSeeder.add(new Author("Anthony", "Doerr", 1973, "Cleveland, Ohio"));
			authorSeeder.add(new Author("Kazuo", "Ishiguro", 1954, "Nagasaki, Japan"));
			authorSeeder.add(new Author("Emily", "Bronte", 1818, "Thornton, Yorkshire, England", 1848, "Haworth, Yorkshire, England"));
			authorSeeder.add(new Author("Charlotte", "Bronte", 1816,  "Thornton, Yorkshire, England", 1855, "Haworth, Yorkshire, England"));
			authorRepository.saveAll(authorSeeder);
			log.info("Finished seeding Authors.\n");

			List<Book> bookSeeder = new ArrayList<>(20);
			bookSeeder.add(new Book("To Kill a Mockingbird", 1960));
			bookSeeder.add(new Book("Go Set a Watchman", 2015));
			bookSeeder.add(new Book("The Sun Also Rises", 1926));
			bookSeeder.add(new Book("A Farewell to Arms", 1929));
			bookSeeder.add(new Book("For Whom the Bell Tolls", 1940));
			bookSeeder.add(new Book("The Old Man and the Sea", 1952));
			bookSeeder.add(new Book("Stories of Your Life and Others", 2002));
			bookSeeder.add(new Book("Exhalation", 2019));
			bookSeeder.add(new Book("All the Light We Cannot See", 2014));
			bookSeeder.add(new Book("Cloud Cuckoo Land", 2021));
			bookSeeder.add(new Book("The Remains of the Day", 1989));
			bookSeeder.add(new Book("Never Let Me Go", 2005));
			bookSeeder.add(new Book("Klara and the Sun", 2021));
			bookSeeder.add(new Book("Wuthering Heights", 1847));
			bookSeeder.add(new Book("Jane Eyre", 1847));
			bookSeeder.add(new Book("Shirley", 184));
			bookSeeder.add(new Book("Villette", 1853));
			bookRepository.saveAll(bookSeeder);
			log.info("Finished seeding Books.\n");
		};
	}
}
