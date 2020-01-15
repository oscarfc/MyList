/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.esercizio.library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args)  {
        try {
            Library lib = new Library();
            Book a = new Book("a"), b = new Book("b"), c = new Book("c"),
                    d = new Book("d");    
            System.out.println(lib.addBook(a));
            System.out.println(lib.addBook(b));
            System.out.println(lib.addBook(c));
            System.out.println(lib.addBook(a));
            System.out.println(lib.loanBook(b));
            System.out.println(lib.loanBook(a));
            System.out.println(lib.loanBook(d)); // errore prestito
            //lib.returnBook(c); //errore restituzione
            lib.printLoans();
        } 
        catch (LibraryException ex) {
            System.out.println("sono nel gestore di Runtime Exception");
            System.out.println(ex.getMessage());
            System.out.println(ex.getBook());
            System.out.println("Il programma verrà terminato");
        }catch(IllegalArgumentException | NullPointerException ex){
            
        }

    }
}
