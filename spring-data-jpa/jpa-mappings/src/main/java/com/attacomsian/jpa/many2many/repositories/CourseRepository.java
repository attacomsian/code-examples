package com.attacomsian.jpa.many2many.repositories;

import com.attacomsian.jpa.many2many.domains.Course;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CourseRepository extends CrudRepository<Course, Long> {

    List<Course> findByTitleContaining(String title);

    List<Course> findByFeeLessThan(double fee);
}
