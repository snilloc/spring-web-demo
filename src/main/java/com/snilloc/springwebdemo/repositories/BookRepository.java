package com.snilloc.springwebdemo.repositories;

import com.snilloc.springwebdemo.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {

}
