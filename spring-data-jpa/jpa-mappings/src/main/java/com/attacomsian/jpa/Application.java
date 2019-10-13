package com.attacomsian.jpa;

import com.attacomsian.jpa.one2many.domains.Book;
import com.attacomsian.jpa.one2many.domains.Page;
import com.attacomsian.jpa.one2many.repositories.BookRepository;
import com.attacomsian.jpa.one2many.repositories.PageRepository;
import com.attacomsian.jpa.one2one.domains.Address;
import com.attacomsian.jpa.one2one.domains.User;
import com.attacomsian.jpa.one2one.repositories.AddressRepository;
import com.attacomsian.jpa.one2one.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner mappingDemo(BookRepository bookRepository,
                                         PageRepository pageRepository) {
        return args -> {

            // create a new book
            Book book = new Book("Java 101", "John Doe", "123456");

            // save the book
            bookRepository.save(book);

            // create and save new pages
            pageRepository.save(new Page(1, "Introduction contents", "Introduction", book));
            pageRepository.save(new Page(65, "Java 8 contents", "Java 8", book));
            pageRepository.save(new Page(95, "Concurrency contents", "Concurrency", book));
        };
    }
}
