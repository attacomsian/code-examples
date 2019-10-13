package com.attacomsian.jpa.one2many.repositories;

import com.attacomsian.jpa.one2many.domains.Book;
import com.attacomsian.jpa.one2many.domains.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PageRepository extends CrudRepository<Page, Long> {

    List<Page> findByBook(Book book, Sort sort);
}
