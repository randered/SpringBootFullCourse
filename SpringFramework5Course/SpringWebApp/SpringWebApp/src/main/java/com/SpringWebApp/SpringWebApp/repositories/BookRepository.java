package com.SpringWebApp.SpringWebApp.repositories;

import com.SpringWebApp.SpringWebApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
