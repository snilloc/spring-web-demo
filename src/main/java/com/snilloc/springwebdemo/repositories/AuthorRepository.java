package com.snilloc.springwebdemo.repositories;

import com.snilloc.springwebdemo.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {



}
