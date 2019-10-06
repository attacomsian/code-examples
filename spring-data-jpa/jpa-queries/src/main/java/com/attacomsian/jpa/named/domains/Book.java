package com.attacomsian.jpa.named.domains;

import javax.persistence.*;
import java.util.Objects;

@Entity
@NamedQueries({
        @NamedQuery(name = "Book.findAllJPQL",
                query = "SELECT b FROM Book b ORDER BY b.title DESC"),
        @NamedQuery(name = "Book.findByTitleJPQL",
                query = "SELECT b FROM Book b WHERE b.title = ?1"),
        @NamedQuery(name = "Book.findByTitleAndPagesGreaterThanJPQL",
                query = "SELECT b FROM Book b WHERE b.title = :title AND b.pages > :pages")
})
@NamedNativeQueries({
        @NamedNativeQuery(name = "Book.findAllNative",
                query = "SELECT * FROM book b ORDER BY b.title DESC",
                resultClass = Book.class),
        @NamedNativeQuery(name = "Book.findByIsbnNative",
                query = "SELECT * FROM book b WHERE b.isbn = :isbn",
                resultClass = Book.class)
})
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    @Column(unique = true)
    private String isbn;
    private int pages;

    public Book() {
    }

    public Book(String title, String isbn, int pages) {
        this.title = title;
        this.isbn = isbn;
        this.pages = pages;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id.equals(book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", pages=" + pages +
                '}';
    }
}
