/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.esercizio.library;

/**
 *
 * @author tss
 */
public class LibraryException extends RuntimeException{

    private final Book book;

    public LibraryException(String message, Book b) {
        super(message);
        this.book = b;
    }

    public Book getBook() {
        return book;
    }
    
    
}
