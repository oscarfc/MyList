/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.lez004;

import java.util.ArrayList;

/**
 *
 * @author tss
 */
public class Generics {

    public static void main(String[] args) {

        //Box<Test1, Test> box = new Box(new Test("abcd"), 10);
        System.out.println(Matematica.somma(20.5, 10.8));
    }
}

class Test {

    String cognome;

    public Test(String cognome) {
        this.cognome = cognome;
    }

    @Override
    public String toString() {
        return "Test{" + "cognome=" + cognome + '}';
    }

}

class Test1 extends Test {

    public Test1(String valore) {
        super(valore);
    }

    @Override
    public String toString() {
        return "Test1{" + "cognome=" + cognome + '}';
    }

}

class Prova {

}

class Box<T extends K, K> {

    private T contenuto;
    private K contenuto1;

    public Box(T contenuto, K contenuto1) {
        this.contenuto = contenuto;
        this.contenuto1 = contenuto1;
    }

    public T getContenuto() {
        return contenuto;
    }

    public K getContenuto1() {
        return contenuto1;
    }
}

class Matematica {

    public static <T extends Number> Double somma(T op1, T op2) {
        return op1.doubleValue() + op2.doubleValue();
    }
}
