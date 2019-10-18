package com.attacomsian.jpa.many2many.repositories;

import com.attacomsian.jpa.many2many.domains.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {

    List<Student> findByNameContaining(String name);
}
