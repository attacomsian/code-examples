package com.attacomsian.jpa.one2many.repositories;

import com.attacomsian.jpa.one2many.domains.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

    Book findByIsbn(String isbn);
}
