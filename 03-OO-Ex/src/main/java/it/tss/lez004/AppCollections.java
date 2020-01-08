/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.lez004;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author tss
 */
public class AppCollections {

    public static void main(String[] args) {

        Map<Integer, Anagrafica1> rubrica = new HashMap<>();

        rubrica.put(111111, new Anagrafica1("rossi"));
        rubrica.put(222222, new Anagrafica1("bianchi"));

        System.out.println(rubrica.get(222222));
        
        Coda<Integer> coda = new Coda<>();
        coda.entra(11);
        coda.entra(20);
        System.out.println(coda);
        
        List<Integer> list = coda.getCoda();
        list.add(0, 50);
        System.out.println(coda);
    }
}

class Anagrafica1 {

    String cognome;

    public Anagrafica1(String cognome) {
        this.cognome = cognome;
    }

    @Override
    public String toString() {
        return "Anagrafica{" + "cognome=" + cognome + '}';
    }

}
//FIFO

class Coda<T> {

    private final List<T> coda = new LinkedList<>();

    public T esci() {
        return coda.remove(0);
    }

    public void entra(T elemento) {
        coda.add(elemento);
    }

    public T testa() {
        return coda.get(0);
    }

    public List<T> getCoda() {
        return this.coda;
    }

    @Override
    public String toString() {
        return coda.toString();
    }
    
    
}

//LIFO
class Pila<T> {

    private List<T> coda = new LinkedList<>();

    public T esci() {
        return coda.remove(coda.size() - 1);
    }

    public void entra(T elemento) {
        coda.add(elemento);
    }

    public T testa() {
        return coda.get(coda.size() - 1);
    }

}
