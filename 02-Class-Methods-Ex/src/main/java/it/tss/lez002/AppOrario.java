/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.lez002;

import java.security.InvalidParameterException;

/**
 *
 * @author tss
 */
public class AppOrario {

    public static void main(String[] args) {
        Orario orario = new Orario(0, 0, 0);
        System.out.println(orario);
        orario.somma(12,10,30); //12:10:30
        System.out.println(orario);
        orario.somma(10,20,30); //22:31:00
        System.out.println(orario);
        orario.somma(10,30,45); //09:01:45
        System.out.println(orario);
        orario.sottrai(10,30,30); //1:31:15
        System.out.println(orario);
    }

}


class Orario {

    private int h, m, s;

    public Orario(int h, int m, int s) {
        valida(h, m, s);
        this.h = h;
        this.m = m;
        this.s = s;
    }

    public static boolean valido(int h, int m, int s) {
        return h >= 0 && h <= 23 && m >= 0 && m <= 59 && s >= 0 && s <= 59;
    }

    private void valida(int h, int m, int s) {
        if (!valido(h, m, s)) {
            throw new InvalidParameterException(String.format("Orario non valido: %s:%s:%s", h, m, s));
        }
    }

    public void somma(int h, int m, int s) {
        valida(h, m, s);
        this.s += s;
        if (this.s > 59) {
            this.s = this.s % 60;
            this.m++;
        }
        this.m += m;
        if (this.m > 59) {
            this.m = this.m % 60;
            this.h++;
        }
        this.h += h;
        if (this.h > 23) {
            this.h = this.h % 24;
        }
    }

    public void sottrai(int h, int m, int s) {
        valida(h, m, s);
        this.s -= s;
        if (this.s < 0) {
            this.s += 60;
            this.m--;
        }
        this.m -= m;
        if (this.m < 0) {
            this.m += 60;
            this.h--;
        }
        this.h -= h;
        if (this.h < 0) {
            this.h += 24;
        }
    }

    @Override
    public String toString() {
        return String.format("%s:%s:%s", h, m, s);
    }

    
}
