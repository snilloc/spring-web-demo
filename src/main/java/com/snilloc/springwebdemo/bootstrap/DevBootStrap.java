package com.snilloc.springwebdemo.bootstrap;

import com.snilloc.springwebdemo.model.Author;
import com.snilloc.springwebdemo.model.Book;
import com.snilloc.springwebdemo.model.Publisher;
import com.snilloc.springwebdemo.repositories.AuthorRepository;
import com.snilloc.springwebdemo.repositories.BookRespository;
import com.snilloc.springwebdemo.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

/**
 *
 */
@Component
public class DevBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRespository bookRespository;
    private PublisherRepository publisherRepository;

    public DevBootStrap(AuthorRepository authorRepository, BookRespository bookRespository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRespository = bookRespository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // Initialize DEV DB
        initData();
    }

    private void initData() {
        Author eric = new Author("Eric", "Smitch");
        Publisher publisher = new Publisher("Harper Collins", "123 washtingont dr");

        authorRepository.save(eric);
        Book book = new Book("Domain Driven Design", "1234", publisher );
        eric.getBooks().add(book);
        book.getAuthors().add(eric);
        bookRespository.save(book);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book book2 = new Book("J2EE Development without EJB", "1243", publisher);
        Publisher publisher2 = new Publisher("worx", "123 address");
        rod.getBooks().add(book2);
        book2.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRespository.save(book2);
        publisherRepository.save(publisher2);

    }


}
