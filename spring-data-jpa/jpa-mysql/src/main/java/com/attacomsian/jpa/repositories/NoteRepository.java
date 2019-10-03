package com.attacomsian.jpa.repositories;

import com.attacomsian.jpa.domains.Note;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NoteRepository extends CrudRepository<Note, Long> {

    List<Note> findByTitleContaining(String title);

}
