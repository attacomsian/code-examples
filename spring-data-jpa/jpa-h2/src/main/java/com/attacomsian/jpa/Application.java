package com.attacomsian.jpa;

import com.attacomsian.jpa.domains.Book;
import com.attacomsian.jpa.repositories.BookRepository;
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
    public CommandLineRunner bookDemo(BookRepository bookRepository) {
        return (args) -> {

        	// create books
			bookRepository.save(new Book("Thinking in Java", "0136597238"));
			bookRepository.save(new Book("Beginning Java 2", "1861002238"));
			bookRepository.save(new Book("Java Gently", "0201342979"));
			bookRepository.save(new Book("Java 2 Platform Unleashed", "0672316315"));

			// fetch all books
			System.out.println("Books found with findAll():");
			System.out.println("---------------------------");
			for (Book book : bookRepository.findAll()) {
				System.out.println(book.toString());
			}
			System.out.println();

			// fetch book by id
			Book book = bookRepository.findById(1L).get();
			System.out.println("Book found with findById(1L):");
			System.out.println("-----------------------------");
			System.out.println(book.toString());
			System.out.println();

			// fetch book by ISBN
			Book bookWithIBSN = bookRepository.findByIsbn("0201342979");
			System.out.println("Book found with findByEmail('0201342979'):");
			System.out.println("------------------------------------------");
			System.out.println(bookWithIBSN.toString());
			System.out.println();

			// fetch all books that contain keyword `java`
			System.out.println("Books that contain keyword 'java':");
			System.out.println("----------------------------------");
			for (Book b : bookRepository.findByTitleContaining("java")) {
				System.out.println(b.toString());
			}
			System.out.println();

			// update book title
			Book bookUpdate = bookRepository.findById(2L).get();
			bookUpdate.setTitle("Java Gently 2nd Edition");
			bookRepository.save(bookUpdate);
			System.out.println("Update book title:");
			System.out.println("------------------");
			System.out.println(bookUpdate.toString());
			System.out.println();

			// total books in DB
			System.out.println("Total books in DB:");
			System.out.println("------------------");
			System.out.println(bookRepository.count());
			System.out.println();

			// delete all books
			bookRepository.deleteAll();
		};
    }
}
