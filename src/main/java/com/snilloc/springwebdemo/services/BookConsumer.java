package com.snilloc.springwebdemo.services;

import com.snilloc.springwebdemo.model.Book;

public class BookConsumer {

    boolean checkout = false;

    public BookConsumer() {

    }

    public void checkout(Book book) {
        try {
            synchronized(book) {
                while (!checkout) {
                    book.wait();
                }
            }

            // Checkout book
            checkout = true;

        } catch (InterruptedException ex) {

        }
    }


}
