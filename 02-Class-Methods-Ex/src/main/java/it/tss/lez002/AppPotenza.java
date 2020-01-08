/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.lez002;

/**
 *
 * @author tss
 */
public class AppPotenza {

    public static void main(String[] args) {
        Potenza potenza = new Potenza(10);
        potenza.pow();
        potenza.cambioBase(8);
        potenza.pow();
    }
}

class Potenza {

    int base;
    private static final int ESPONENTE = 3;

    public Potenza(int base) {
        this.base = base;
    }

    public void pow() {
        int result = 1;
        for (int i = 0; i < ESPONENTE; i++) {
            result *= base;
        }
        System.out.println(result);
    }

    public void cambioBase(int base) {
        this.base = base;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.base;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Potenza other = (Potenza) obj;
        return this.base == other.base;
    }

    @Override
    public String toString() {
        return "base: " + base;
    }

}
