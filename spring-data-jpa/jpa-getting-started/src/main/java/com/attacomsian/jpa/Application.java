package com.attacomsian.jpa;

import com.attacomsian.jpa.domains.User;
import com.attacomsian.jpa.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner userDemo(UserRepository userRepository) {
        return (args) -> {

            // create users
            userRepository.save(new User("John Doe", "john.doe@example.com"));
            userRepository.save(new User("Emma Watson", "emma.watson@example.com"));
            userRepository.save(new User("Seno Reta", "seno.reta@example.com"));
            userRepository.save(new User("Mike Hassan", "mike.hassan@example.com"));

            // fetch all users
            log.info("Users found with findAll():");
            log.info("---------------------------");
            for (User user : userRepository.findAll()) {
                log.info(user.toString());
            }
            log.info("");

            // fetch user by id
            User user = userRepository.findById(1L).get();
            log.info("User found with findById(1L):");
            log.info("-----------------------------");
            log.info(user.toString());
            log.info("");

            // fetch user by email address
            User userWithEmail = userRepository.findByEmail("john.doe@example.com");
            log.info("User found with findByEmail('john.doe@example.com'):");
            log.info("----------------------------------------------------");
            log.info(userWithEmail.toString());
            log.info("");

            // delete all users
            userRepository.deleteAll();

            // confirm users deletion
            log.info("Total users after deletion with :");
            log.info("--------------------------");
            log.info(userRepository.count() + " users are in DB");
            log.info("");
        };
    }
}
