package com.attacomsian.jpa;

import com.attacomsian.jpa.domains.Employee;
import com.attacomsian.jpa.repositories.EmployeeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Sort;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public CommandLineRunner sortingDemo(EmployeeRepository employeeRepository) {
        return args -> {
            // create new employees
            List<Employee> list = Arrays.asList(
                    new Employee("John", "Doe", 45, 8000),
                    new Employee("Mike", "Hassan", 55, 6500),
                    new Employee("Emma", "Doe", 35, 4580),
                    new Employee("Ali", "Obray", 21, 3200),
                    new Employee("Beanca", "Lee", 21, 3200)
            );
            employeeRepository.saveAll(list);

            // find all users
//            Iterable<Employee> emps = employeeRepository.findAll(Sort.by("age", "salary").descending());

            // find users by last name
//            Sort sort = Sort.by("salary").descending().and(Sort.by("firstName"));
//            List<Employee> employees = employeeRepository.findByLastName("Doe", sort);

            Sort sort = Sort.by("salary").descending().and(Sort.by("firstName"))
                    .and(Sort.by("age").descending()).and(Sort.by("lastName").ascending());
            List<Employee> employees = employeeRepository.findBySalaryRange(100, 10000, sort);

            // omit sorting
			Iterable<Employee> emps = employeeRepository.findAll(Sort.unsorted());

            // print employees
            employees.forEach(emp -> {
                System.out.println(emp.toString());
            });
        };
    }
}
