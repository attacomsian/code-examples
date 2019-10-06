package com.attacomsian.jpa.custom.repositories;

import com.attacomsian.jpa.custom.domains.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface NoteRepository extends CrudRepository<Note, Long> {

    // JPQL vs native query
    @Query("SELECT n FROM Note n WHERE n.featured = true")
    List<Note> findByActiveNotes();

    @Query(value = "SELECT * FROM Notes n WHERE n.featured = 1",
            nativeQuery = true)
    List<Note> findByFeaturedNotesNative();

    // positional based bind parameters
    @Query("SELECT n FROM Note n WHERE n.title = ?1")
    List<Note> findByTitlePositionalBind(String title);

    @Query("SELECT n FROM Note n WHERE n.title = ?1 AND n.featured = ?2")
    List<Note> findByTitleAndFeaturedPositionalBind(String title, boolean featured);

    // named based bind parameters
    @Query("SELECT n FROM Note n WHERE n.title = :title")
    List<Note> findByTitleNamedBind(@Param("title") String title);

    @Query("SELECT n FROM Note n WHERE n.title = :title AND n.featured = :featured")
    List<Note> findByTitleAndFeaturedNamedBind(@Param("featured") boolean featured,
                                               @Param("title") String title);

    // And / Or
    @Query("SELECT n FROM Note n WHERE n.title = ?1 AND n.featured = ?2 OR n.priority = ?3")
    List<Note> findByTitleAndFeaturedOrPriority(String title, boolean featured, int priority);

    // Equality
    @Query("SELECT n FROM Note n WHERE n.title = ?1")
    List<Note> findByTitle(String title);

    // Ignore Case
    @Query("SELECT n FROM Note n WHERE lower(n.title) = lower(?1) ")
    List<Note> findByTitleIgnoreCase(String title);

    // Not Equal
    @Query("SELECT n FROM Note n WHERE n.title <> ?1")
    List<Note> findByTitleNotEqual(String title);

    // Like / Contains / Starts With / Ends With
    @Query("SELECT n FROM Note n WHERE n.title LIKE ?1")
    List<Note> findByTitleLike(String pattern);

    // Less Than
    @Query("SELECT n FROM Note n WHERE n.priority < ?1")
    List<Note> findByPriorityLessThan(int priority);

    // Greater Than
    @Query("SELECT n FROM Note n WHERE n.priority > ?1")
    List<Note> findByPriorityGreaterThan(int priority);

    // Between
    @Query("SELECT n FROM Note n WHERE n.priority BETWEEN  ?1 AND ?2")
    List<Note> findByPriorityBetween(int start, int end);

    // Before
    @Query("SELECT n FROM Note n WHERE n.created < ?1")
    List<Note> findByCreatedBefore(Date before);

    // After
    @Query("SELECT n FROM Note n WHERE n.created > ?1")
    List<Note> findByCreatedAfter(Date before);

    // Null
    @Query("SELECT n FROM Note n WHERE n.title IS NULL")
    List<Note> findByTitleIsNull();

    // Not Null
    @Query("SELECT n FROM Note n WHERE n.title IS NOT NULL")
    List<Note> findByTitleIsNotNull();

    // In
    @Query("SELECT n FROM Note n WHERE n.priority IN ?1")
    List<Note> findByPriorityIn(Set<Integer> priorities);

    // static ordering
    @Query("SELECT n FROM Note n WHERE n.title = ?1 ORDER BY n.priority ASC")
    List<Note> findByTitleOrderByPriorityAsc(String title);

    @Query("SELECT n FROM Note n WHERE n.featured = ?1 ORDER BY n.created DESC")
    List<Note> findByFeaturedOrderByCreatedDesc(boolean featured);

    // dynamic sorting
    @Query("SELECT n FROM Note n WHERE n.title = ?1")
    List<Note> findByTitle(String title, Sort sort);

    // pagination
    @Query("SELECT n FROM Note n")
    Page<Note> findAllNotesWithPagination(Pageable pageable);

    // modifying annotation
    @Modifying
    @Query("UPDATE Note n SET n.title = ?1 WHERE n.id = ?2")
    int updateTitleById(String title, Long id);

    @Modifying
    @Query("DELETE FROM Note n WHERE n.title = ?1")
    void deleteByTitle(String title);

    @Modifying
    @Query("UPDATE Note n SET n.title = ?1 WHERE n.id IN ?2")
    int bulkUpdateTitle(String title, Set<Long> id);

    @Modifying
    @Query("DELETE FROM Note n WHERE n.featured = ?1 AND n.id IN ?2")
    void bulkDeleteByFeatured(boolean featured, Set<Long> id);

    // SpEL Expressions
    @Query("SELECT n from #{#entityName} n WHERE n.title = ?1")
    List<Note> findByTitleGeneric(String title);

    @Query("SELECT n FROM Note n WHERE lower(n.title) LIKE %?#{[0].toLowerCase()}%")
    List<Note> findByTitleIgnoreCaseSpEL(String title);
}
