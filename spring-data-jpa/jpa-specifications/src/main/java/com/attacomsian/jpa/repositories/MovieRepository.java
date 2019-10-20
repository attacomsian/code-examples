package com.attacomsian.jpa.repositories;

import com.attacomsian.jpa.domains.Movie;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Long>,
        JpaSpecificationExecutor<Movie> {

    // TODO: add queries
}
