/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.tsslibrary;

/**
 *
 * @author tss
 */
public class Contatore {

    private int valore;
    private final int passo;
    private final int inizio;

    public Contatore() {
        this(0, 1);
    }

    public Contatore(int inizio, int passo) {
        this.passo = passo;
        this.inizio = inizio;
        valore = inizio;
    }

    public void reset() {
        valore = inizio;
    }

    public void incrementa() {
        System.out.println(this.getValore());
        valore += passo;
    }

    public int getValore() {
        return valore;
    }

    @Override
    public String toString() {
        return String.format("Sono un contatore che parte da %s con passo %s e ora valgo %s",
                this.inizio, this.passo, this.valore);
    }

}
