package com.attacomsian.jpa;

import com.attacomsian.jpa.domains.Todo;
import com.attacomsian.jpa.repositories.TodoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner auditingDemo(TodoRepository todoRepository) {
        return args -> {

            // create new todos
            todoRepository.saveAll(Arrays.asList(
                    new Todo("Buy milk", false),
                    new Todo("Email John", false),
                    new Todo("Visit Emma", false),
                    new Todo("Call dad", true),
                    new Todo("Weekend walk", true),
                    new Todo("Write Auditing Tutorial", true)
            ));

            // retrieve all todos
            Iterable<Todo> todos = todoRepository.findAll();

            // print all todos
            todos.forEach(System.out::println);
        };
    }
}
