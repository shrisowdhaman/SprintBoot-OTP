package com.shri.repo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

import com.shri.model.Book;

/**
 * @author shrisowdhaman
 * Dec 14, 2017
 */
public interface BookRepository extends CrudRepository<Book, Long> {

    List<Book> findByTitle(String title);

    Optional<Book> findOne(long id);
}
