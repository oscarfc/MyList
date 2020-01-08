/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.lez004;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tss
 */
public class InterfaceEsempio {

    public static void main(String[] args) {
        List<Computer> c = new ArrayList<>();
        Computer computer = new Computer(2048);
        //computer.confrontaCon("ciao"); error
    }

    /**
     * ordina la lista bubble sort
     *
     * @param list
     */
    private static void ordina(ArrayList<Sortable> list) {
        boolean ordinato;
        do {
            ordinato = true;
            for (int i = 0; i < list.size() - 1; i++) {
                Sortable corrente = list.get(i);
                Sortable successiva = list.get(i + 1);
                if (corrente.confrontaCon(successiva) > 0) {
                    list.set(i, successiva);
                    list.set(i + 1, corrente);
                    ordinato = false;
                }
            }
        } while (!ordinato);
    }
}

interface Sortable<T> {

    int confrontaCon(T o);

}

class Computer implements Sortable<Computer>, Noleggiabile {

    int ram;

    public Computer(int ram) {
        this.ram = ram;
    }

    @Override
    public int confrontaCon(Computer o) {
        if (this.ram == o.ram) {
            return 0;
        } else if (this.ram > o.ram) {
            return 1;
        }
        return -1;
    }

    @Override
    public void m1() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void m2() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void m3() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
        
interface Noleggiabile{
    void m1();
    void m2();
    void m3();
}

interface NoleggiabileExtended extends Noleggiabile{
    void m4();
    void m5();
    void m6();
}