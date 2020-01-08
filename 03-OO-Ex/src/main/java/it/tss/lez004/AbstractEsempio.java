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
public class AbstractEsempio {

    public static void main(String[] args) {
        ArrayList<Veicolo> v = new ArrayList<>();
        v.add(new Veicolo(2019));
        v.add(new Veicolo(2010));
        ordina(v);
        System.out.println(v);
        
        ArrayList<Phone> p = new ArrayList<>();
        p.add(new Phone(55555555));
        p.add(new Phone(11111));
        ordina(p);
        System.out.println(p);
    }

    /**
     * ordina la lista bubble sort
     *
     * @param list
     */
    private static <T extends Ordinabile> void ordina(ArrayList<T> list) {
        boolean ordinato;
        do {
            ordinato = true;
            for (int i = 0; i < list.size() - 1; i++) {
                T corrente = list.get(i);
                T successiva = list.get(i + 1);
                if (corrente.confrontaCon(successiva) > 0) {
                    list.set(i, successiva);
                    list.set(i + 1, corrente);
                    ordinato = false;
                }
            }
        } while (!ordinato);
    }
}

abstract class Ordinabile {

    public abstract int confrontaCon(Object o);

}

class Veicolo extends Ordinabile {

    int anno;

    public Veicolo(int anno) {
        this.anno = anno;
    }

    @Override
    public int confrontaCon(Object o) {
        if (o instanceof Veicolo) {
            Veicolo veicolo = (Veicolo) o;
            if (this.anno == veicolo.anno) {
                return 0;
            } else if (this.anno > veicolo.anno) {
                return 1;
            }
            return -1;
        }
        throw new IllegalArgumentException("Tipo errato");
    }

    @Override
    public String toString() {
        return "Veicolo{" + "anno=" + anno + '}';
    }

}

class Phone extends Ordinabile {

    int num;

    public Phone(int num) {
        this.num = num;
    }

    @Override
    public int confrontaCon(Object o) {
        if (o instanceof Phone) {
            Phone phone = (Phone) o;
            if (this.num == phone.num) {
                return 0;
            } else if (this.num > phone.num) {
                return 1;
            }
            return -1;
        }
        throw new IllegalArgumentException("Tipo errato");
    }

    @Override
    public String toString() {
        return "Phone{" + "num=" + num + '}';
    }

}
