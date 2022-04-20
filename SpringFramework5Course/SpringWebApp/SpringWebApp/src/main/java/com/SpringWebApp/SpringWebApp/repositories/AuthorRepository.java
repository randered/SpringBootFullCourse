package com.SpringWebApp.SpringWebApp.repositories;

import com.SpringWebApp.SpringWebApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long > {

}
