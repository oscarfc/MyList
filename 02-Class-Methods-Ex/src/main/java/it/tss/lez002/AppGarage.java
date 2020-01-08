/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.lez002;

import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author tss
 */
public class AppGarage {

    public static void main(String[] args) {
        Garage garage = new Garage();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Dimmi il tipo di alimentazione per l'auto?");
        Auto.Alimentazione alimentazione = null;
        boolean invalid;
        do {
            invalid = false;
            try {
                alimentazione
                        = Auto.Alimentazione.valueOf(scanner.nextLine()
                                .toUpperCase());
            } catch (IllegalArgumentException ex) {
                invalid = true;
                System.out.println("alimentazione non valida..riprova");
            }
        } while (invalid);

        Auto auto = new Auto(4, alimentazione, "FIAT", 2000, 1000);
        Moto moto = new Moto("2 tempi", "Honda", 2018, 600);

        garage.entra(auto);
        garage.entra(moto);
        garage.situazione();
        garage.esci(0);
        garage.situazione();
    }
}

/**
 *
 * @author tss
 */
class Garage {

    private final Veicolo[] posti;

    public Garage() {
        posti = new Veicolo[15];
    }

    /**
     * inserire nel primo posto libero il veicolo, errore se non ci sono posti
     * liberi
     *
     * @param v
     */
    public void entra(Veicolo v) {
        int postoLibero = cercaPostoLibero();
        if (postoLibero == -1) {
            throw new RuntimeException("Il garage è pieno!!");
        }
        posti[postoLibero] = v;
    }

    /**
     * liberare il posto nell'array e ritornare il veicolo presente
     *
     * @param posto
     * @return
     */
    public Veicolo esci(int posto) {
        if (posto < 0 || posto >= posti.length) {
            throw new IllegalArgumentException("Il posto non esiste!!");
        }
        if (posti[posto] == null) {
            throw new IllegalArgumentException("Il posto è vuoto!!");
        }
        Veicolo veicolo = posti[posto];
        posti[posto] = null;
        return veicolo;
    }

    /**
     * Stampa in console la situazione del garage
     */
    public void situazione() {
        for (int i = 0; i < posti.length; i++) {
            Veicolo v = posti[i];
            System.out.print("----------------- posto numero " + i + " --------------------- ");
            System.out.println(v == null ? "LIBERO" : v);
        }
    }

    /**
     * Ritorna -1 se il garage è pieno altrimenti l'indice del primo posto
     * libero
     *
     * @return
     */
    private int cercaPostoLibero() {
        int result = -1;
        for (int i = 0; i < posti.length; i++) {
            if (posti[i] == null) {
                result = i;
                break;
            }
        }
        return result;
    }
}

/**
 *
 * @author tss
 */
class Veicolo {

    protected String marca;
    protected int anno, cilindrata;

    public Veicolo(String marca, int anno, int cilindrata) {
        this.marca = marca;
        this.anno = anno;
        this.cilindrata = cilindrata;
    }

    @Override
    public String toString() {
        return String.format("veicolo %s , %s, %s", marca, anno, cilindrata);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.marca);
        hash = 17 * hash + this.anno;
        hash = 17 * hash + this.cilindrata;
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
        final Veicolo other = (Veicolo) obj;
        if (this.anno != other.anno) {
            return false;
        }
        if (this.cilindrata != other.cilindrata) {
            return false;
        }
        return Objects.equals(this.marca, other.marca);
    }

}

/**
 *
 * @author tss
 */
class Auto extends Veicolo {

    public static enum Alimentazione {
        BENZINA, DIESEL
    }

    protected int porte;
    protected Alimentazione alimentazione;

    public Auto(int porte, Alimentazione alimentazione, String marca, int anno, int cilindrata) {
        super(marca, anno, cilindrata);
        this.porte = porte;
        this.alimentazione = alimentazione;

    }

    @Override
    public String toString() {
        return super.toString() + String.format(" auto %s , %s ", porte, alimentazione.name());
    }

}

/**
 *
 * @author tss
 */
class Moto extends Veicolo {

    protected String tempi;

    public Moto(String tempi, String marca, int anno, int cilindrata) {
        super(marca, anno, cilindrata);
        this.tempi = tempi;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" moto %s", tempi);
    }
}

/**
 *
 * @author tss
 */
class Furgone extends Veicolo {

    protected int capacita;

    public Furgone(int capacita, String marca, int anno, int cilindrata) {
        super(marca, anno, cilindrata);
        this.capacita = capacita;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" furgone %s", capacita);
    }

}
