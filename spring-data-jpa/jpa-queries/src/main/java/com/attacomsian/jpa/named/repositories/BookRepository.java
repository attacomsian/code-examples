package com.attacomsian.jpa.named.repositories;

import com.attacomsian.jpa.named.domains.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends CrudRepository<Book, Long> {

    // named queries declared in `jpa-named-queries.properties` file

    List<Book> findAllNamedFile();

    List<Book> findByTitleNamedFile(String title);

    Book findByIsbnNamedFile(String isbn);

    @Query(nativeQuery = true)
    List<Book> findByTitleNativeNamedFile(@Param("title") String title);

    // named queries declared in `orm.xml` file

    List<Book> findAllXML();

    List<Book> findByTitleContainingXML(String title);

    @Query(nativeQuery = true)
    List<Book> findByIsbnNativeXML(@Param("isbn") String isbn);

    // named queries declared with `@NamedQuery`

    List<Book> findAllJPQL();

    List<Book> findByTitleJPQL(String title);

    List<Book> findByTitleAndPagesGreaterThanJPQL(@Param("title") String title, @Param("pages") int pages);

    // named queries declared with `@NamedNativeQuery`

    @Query(nativeQuery = true)
    List<Book> findAllNative();

    @Query(nativeQuery = true)
    List<Book> findByIsbnNative(@Param("isbn") String isbn);
}
