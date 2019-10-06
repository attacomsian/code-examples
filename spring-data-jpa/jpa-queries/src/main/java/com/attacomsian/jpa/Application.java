package com.attacomsian.jpa;

import com.attacomsian.jpa.custom.domains.Note;
import com.attacomsian.jpa.custom.repositories.NoteRepository;
import com.attacomsian.jpa.derived.domains.User;
import com.attacomsian.jpa.derived.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.JpaSort;

import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner runner(UserRepository userRepository, NoteRepository noteRepository) {
        return args -> {
            // Like pattern
//            String pattern = "%atta%@gmail%";
//            List<User> users = userRepository.findByEmailLike(pattern);

            // pagination
//            Pageable pageable = PageRequest.of(0, 10, Sort.by("name").descending());
//            Page<User> userPage = userRepository.findByActive(true, pageable);

            // notes sorting
            List<Note> startupNotes = noteRepository.findByTitle("startup", Sort.by("title").ascending());

            List<Note> techNotes = noteRepository.findByTitle("tech", Sort.by("priority").descending());

            List<Note> lengthyNotes = noteRepository.findByTitle("tech", JpaSort.unsafe("LENGTH(title)"));

            // notes pagination
            Pageable pageable = PageRequest.of(0, 10, Sort.by("title").descending());
            Page<Note> notePage = noteRepository.findAllNotesWithPagination(pageable);
        };
    }

}
