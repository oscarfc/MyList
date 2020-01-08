/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.lez002;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tss
 */
public class AppContoCorrente {

    public static void main(String[] args) {
        try {
            CC cc = new CC();
            cc.versamento(100);
            cc.versamento(50);
            cc.ultimiMovimenti(); //{100,50} 150
            cc.prelievo(200); //errore
            cc.prelievo(20);
            cc.prelievo(30);
            cc.versamento(100);
            cc.ultimiMovimenti(); //{100,50,-20,-30,100} 200
            cc.versamento(45);
            cc.versamento(55); //{-20,-30,100,45,55} 300
            cc.ultimiMovimenti();
        } catch (Exception ex) {
            System.out.println("Si è verificato il seguente errore: " + ex.getMessage());
            System.out.println("Qualcosa è andato storto, il programma sarà terminato!!");
        }
    }
}

class CC {

    private double saldo;
    private final ArrayList<Double> movimenti;

    public CC() {
        saldo = 0;
        movimenti = new ArrayList<>();
    }

    public double getSaldo() {
        return saldo;
    }

    /**
     *
     * @param somma
     */
    public void versamento(double somma) {
        checkVersamento(somma);
        saldo += somma;
        storicizza(somma);
    }

    /**
     *
     * @param somma
     */
    public void prelievo(int somma) {
        checkPrelievo(somma);
        saldo -= somma;
        storicizza(-somma);
    }

    /**
     *
     */
    public void ultimiMovimenti() {
        System.out.println("Saldo: " + saldo);
        System.out.println(movimenti);
    }

    /**
     * inserire il nuovo movimento in movimenti
     *
     * @param somma
     */
    private void storicizza(double somma) {
        if (movimenti.size() == 5) {
            movimenti.remove(0);
        }
        movimenti.add(somma);
    }

    /**
     *
     * @param somma
     */
    private void checkVersamento(double somma) {
        if (somma <= 0) {
            throw new IllegalArgumentException("somma versamento non valida: " + somma);
        }
    }

    private void checkPrelievo(int somma) {
        if (somma <= 0) {
            throw new IllegalArgumentException("somma prelievo non valida: " + somma);
        }
        if (saldo < somma) {
            throw new IllegalArgumentException("somma prelievo non disponibile: " + somma);
        }
    }
}
