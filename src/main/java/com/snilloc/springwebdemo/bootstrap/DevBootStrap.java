package com.snilloc.springwebdemo.bootstrap;

import com.snilloc.springwebdemo.model.Author;
import com.snilloc.springwebdemo.model.Book;
import com.snilloc.springwebdemo.repositories.AuthorRepository;
import com.snilloc.springwebdemo.repositories.BookRespository;
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

    public DevBootStrap(AuthorRepository authorRepository, BookRespository bookRespository) {
        this.authorRepository = authorRepository;
        this.bookRespository = bookRespository;
    }
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        // Initialize DEV DB
        initData();
    }

    private void initData() {
        Author eric = new Author("Eric", "Smitch");
        Book book = new Book("Domain Driven Design", "1234", "Harper Collins");
        eric.getBooks().add(book);
        book.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRespository.save(book);

        Author rod = new Author("Rod", "Johnson");
        Book book2 = new Book("J2EE Development without EJB", "1243", "Worx");

        rod.getBooks().add(book2);
        book2.getAuthors().add(rod);

        authorRepository.save(rod);
        bookRespository.save(book2);
    }


}
