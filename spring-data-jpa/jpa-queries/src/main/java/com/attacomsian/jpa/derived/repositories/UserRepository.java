package com.attacomsian.jpa.derived.repositories;

import com.attacomsian.jpa.derived.domains.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {

    // Simple Methods
    List<User> findByName(String name);

    Optional<User> findByEmail(String email);

    // multiple parameters
    List<User> findByNameOrEmail(String name, String email);

    List<User> findByNameAndAge(String name, int age);

    List<User> findByActiveAndBirthDateOrNameAndAge(boolean active, Date dob, String name, int age);

    // equality condition keywords
    List<User> findByNameIs(String name);

    // OR
    List<User> findByNameEquals(String name);

    List<User> findByNameIsNot(String name);

    // OR
    List<User> findByNameNot(String name);

    List<User> findByEmailIsNull();

    List<User> findByEmailIsNotNull();

    List<User> findByActiveTrue();

    List<User> findByActiveFalse();

    // matching condition keywords
    List<User> findByNameStartingWith(String prefix);

    // OR
    List<User> findByNameIsStartingWith(String prefix);

    // OR
    List<User> findByNameStartsWith(String prefix);

    List<User> findByNameEndingWith(String suffix);

    List<User> findByNameContaining(String infix);

    List<User> findByEmailLike(String pattern);

    // comparison condition keywords
    List<User> findByAgeLessThan(int age);

    List<User> findByAgeLessThanEqual(int age);

    List<User> findByAgeGreaterThan(int age);

    List<User> findByAgeGreaterThanEqual(int age);

    List<User> findByAgeBetween(int start, int end);

    List<User> findByBirthDateBefore(Date before);

    List<User> findByBirthDateAfter(Date after);

    // distinct keyword
    List<User> findDistinctByEmail(String email);

    List<User> findDistinctPeopleByNameOrEmail(String name, String email);

    // ignore case keyword
    List<User> findByNameIgnoreCase(String name);

    List<User> findByNameOrEmailAllIgnoreCase(String name, String email);

    // sorting the results
    List<User> findByNameContainingOrderByName(String name);

    // OR
    List<User> findByNameContainingOrderByNameAsc(String name);

    List<User> findByNameContainingOrderByNameDesc(String name);

    List<User> findByNameContaining(String name, Sort sort);

    // limiting the results
    User findFirstByOrderByName();

    User findTopByOrderByAgeDesc();

    List<User> findFirst5ByEmail(String email);

    List<User> findDistinctTop3ByAgeLessThan(int age);

    // pagination
    Page<User> findByActive(boolean active, Pageable pageable);

    // custom named bind parameter
    @Query("SELECT u FROM User u WHERE " +
            "lower(u.name) LIKE lower(CONCAT('%', :keyword, '%')) OR " +
            "lower(u.email) LIKE lower(CONCAT('%', :keyword, '%'))")
    List<User> searchUsers(@Param("keyword") String keyword);

    // delete queries
    void deleteByName(String name);

    void deleteAllByActive(boolean active);
}
