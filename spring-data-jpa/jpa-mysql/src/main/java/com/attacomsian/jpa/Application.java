package com.attacomsian.jpa;

import com.attacomsian.jpa.domains.Note;
import com.attacomsian.jpa.repositories.NoteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public CommandLineRunner noteDemo(NoteRepository noteRepository) {
		return (args) -> {

			// create notes
			noteRepository.save(new Note("Welcome to Spring Boot", "Basic Introduction", new Date()));
			noteRepository.save(new Note("Learn Spring Data JPA", "Java Persistence Layer", new Date()));
			noteRepository.save(new Note("Learn Spring Security", "Build Secure Web Apps", new Date()));

			// fetch all notes
			System.out.println("Notes found with findAll():");
			System.out.println("---------------------------");
			for (Note note : noteRepository.findAll()) {
				System.out.println(note.toString());
			}
			System.out.println();

			// fetch note by id
			Note note = noteRepository.findById(1L).get();
			System.out.println("Note found with findById(1L):");
			System.out.println("-----------------------------");
			System.out.println(note.toString());
			System.out.println();

			// fetch all notes that contain keyword `learn`
			System.out.println("Notes that contain keyword 'learn':");
			System.out.println("-----------------------------------");
			for (Note n : noteRepository.findByTitleContaining("learn")) {
				System.out.println(n.toString());
			}
			System.out.println();

			// update note title
			Note noteUpdate = noteRepository.findById(2L).get();
			noteUpdate.setTitle("Understanding Spring Data JPA");
			noteRepository.save(noteUpdate);
			System.out.println("Update note title:");
			System.out.println("------------------");
			System.out.println(noteUpdate.toString());
			System.out.println();

			// total notes in DB
			System.out.println("Total notes in DB:");
			System.out.println("------------------");
			System.out.println(noteRepository.count());
			System.out.println();

			// delete all notes
			noteRepository.deleteAll();
		};
	}
}
