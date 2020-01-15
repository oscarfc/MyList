/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.esercizio.library;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 * @author tss
 */
public class Library {

    private final Set<Book> books = new HashSet<>();
    private final List<Book> loans = new ArrayList<>();

    /**
     * aggiunge il libro a Library se non esiste e torna true altrimenti non
     * aggiunge e torna false
     *
     * @param b
     * @return
     */
    public boolean addBook(Book b) {
        if (books.contains(b)) {
            return false;
        }
        books.add(b);
        return true;
    }

    /**
     * prende un libro come argomento e lo dà in prestito, a patto che sia
     * disponibile. Se quel libro è già in prestito, restituisce false. Se quel
     * libro non è mai stato inserito nella biblioteca, lancia un'eccezione.
     *
     * @param b
     * @return
     */
    public boolean loanBook(Book b) {
        try {
            checkBookExist(b);
            boolean result = false;
            if (!loans.contains(b)) {
                result = loans.add(b);
            }
            return result;
        } catch (Exception ex) {
            throw new LibraryException("Il libro non esiste", b);
        } finally{
            System.out.println("Chiamata al metodo loanBook() del: " + 
                    LocalDateTime.now());
        }
    }

    /**
     * prende un libro come argomento e restituisce quel libro alla biblioteca.
     * Se quel libro non era stato prestato col metodo loanBook, il metodo
     * returnBook lancia un'eccezione.
     *
     * @param b
     */
    public void returnBook(Book b) {
        checkLoanExist(b);
        loans.remove(b);
    }

    /**
     * stampa i prestiti
     *
     */
    public void printLoans() {
        loans.forEach(System.out::println);
    }

    /**
     * controlla se il libro esiste in Library se no errore
     *
     * @param b
     */
    private void checkBookExist(Book b) throws Exception {
        if (!books.contains(b)) {
            throw new Exception("Il libro non esiste in Library");
        }
    }

    /**
     * controlla se il libro esiste in Prestiti se no errore
     *
     * @param b
     */
    private void checkLoanExist(Book b) {
        if (!loans.contains(b)) {
            throw new LibraryException("Il libro restituito non era in prestito..", b);
        }
    }

}
