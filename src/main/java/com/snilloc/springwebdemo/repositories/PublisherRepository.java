package com.snilloc.springwebdemo.repositories;

import com.snilloc.springwebdemo.model.Publisher;
import org.springframework.data.repository.CrudRepository;


public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
