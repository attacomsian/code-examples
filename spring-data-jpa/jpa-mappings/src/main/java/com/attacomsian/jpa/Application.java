package com.attacomsian.jpa;

import com.attacomsian.jpa.composite.domains.Account;
import com.attacomsian.jpa.composite.domains.AccountId;
import com.attacomsian.jpa.composite.domains.Employee;
import com.attacomsian.jpa.composite.domains.EmployeeId;
import com.attacomsian.jpa.composite.repositories.AccountRepository;
import com.attacomsian.jpa.composite.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner mappingDemo(AccountRepository accountRepository,
                                         EmployeeRepository employeeRepository) {
        return args -> {

            // ======= `@IdClass` Annotation =======

            // create new accounts
            accountRepository.save(new Account("458666", "Checking", 4588));
            accountRepository.save(new Account("458689", "Checking", 2500));
            accountRepository.save(new Account("424265", "Saving", 100000));

            // fetch accounts by a given type
            List<Account> accounts = accountRepository.findByAccountType("Checking");
            accounts.forEach(System.out::println);

            // fetch account by composite key
            Optional<Account> account = accountRepository.findById(new AccountId("424265", "Saving"));
            account.ifPresent(System.out::println);

            // ======= `@EmbeddedId` Annotation =======

            // create new employees
            employeeRepository.save(new Employee(new EmployeeId(100L, 10L),
                    "John Doe", "john@example.com", "123456"));
            employeeRepository.save(new Employee(new EmployeeId(101L, 20L),
                    "Emma Ali", "emma@example.com", "654321"));

            // fetch employees by a given department id
            List<Employee> employees = employeeRepository.findByEmployeeIdDepartmentId(20L);
            employees.forEach(System.out::println);

            // fetch employee by composite key
            Optional<Employee> employee = employeeRepository.findById(new EmployeeId(100L, 10L));
            employee.ifPresent(System.out::println);
        };
    }
}
