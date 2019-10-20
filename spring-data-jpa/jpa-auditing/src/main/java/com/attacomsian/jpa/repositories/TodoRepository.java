package com.attacomsian.jpa.repositories;

import com.attacomsian.jpa.domains.Todo;
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Long> {

    // TODO: add queries
}
