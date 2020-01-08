/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.lez004;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) {
        ArrayList<Anagrafica> contatti = new ArrayList<>();
        contatti.add(new Anagrafica("mario", "rossi", 20));
        contatti.add(new Anagrafica("vittorio", "verdi", 39));
        contatti.add(new Anagrafica("marco", "bianchi", 41));
        contatti.add(new Anagrafica("giovanni", "rossi", 18));
        ordina(contatti);
        System.out.println(contatti);

        ArrayList<Calciatore> calciatori = new ArrayList<>();
        calciatori.add(new Calciatore("mario", "rossi", 20, "difensore", 10000));
        calciatori.add(new Calciatore("vittorio", "verdi", 39, "attaccante", 12000));
        calciatori.add(new Calciatore("marco", "bianchi", 41, "attaccante", 5000));
        calciatori.add(new Calciatore("giovanni", "rossi", 18, "difensore", 2000));
        ordina(calciatori);
        System.out.println(calciatori);

        System.out.println("--------------ordinamento con librerie standard --------------------");

        Collections.sort(contatti);
        System.out.println(contatti);
        Collections.sort(calciatori);
        System.out.println(calciatori);
    }

    /**
     * ordina la lista bubble sort
     *
     * @param list
     */
    private static <T extends Anagrafica> void ordina(ArrayList<T> list) {
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

class Anagrafica implements Comparable<Anagrafica> {

    String nome, cognome;
    int eta;

    public Anagrafica(String nome, String cognome, int eta) {
        this.nome = nome;
        this.cognome = cognome;
        this.eta = eta;
    }

    @Override
    public int compareTo(Anagrafica a) {
        if (this.eta == a.eta) {
            return 0;
        } else if (this.eta > a.eta) {
            return 1;
        }
        return -1;
    }

    /**
     * numero < 0 se sono piu piccolo, 0 se sono uguale, numero > 0 se sono piu
     * grande
     *
     * @param a
     * @return
     */
    int confrontaCon(Anagrafica a) {
        if (this.eta == a.eta) {
            return 0;
        } else if (this.eta > a.eta) {
            return 1;
        }
        return -1;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.nome);
        hash = 17 * hash + Objects.hashCode(this.cognome);
        hash = 17 * hash + this.eta;
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
        final Anagrafica other = (Anagrafica) obj;
        if (this.eta != other.eta) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.cognome, other.cognome);
    }

    @Override
    public String toString() {
        return "Anagrafica{" + "nome=" + nome + ", cognome=" + cognome + ", eta=" + eta + '}';
    }

}

class Calciatore extends Anagrafica {

    String ruolo;
    int valutazione;

    public Calciatore(String nome, String cognome, int eta, String ruolo, int valutazione) {
        super(nome, cognome, eta);
        this.ruolo = ruolo;
        this.valutazione = valutazione;
    }

    @Override
    public String toString() {
        return super.toString() + " -> Calciatore{" + "ruolo=" + ruolo + ", valutazione=" + valutazione + '}';
    }

    @Override
    public int compareTo(Anagrafica a) {
        if (a instanceof Calciatore) {
            Calciatore calciatore = (Calciatore) a;
            if (this.valutazione == calciatore.valutazione) {
                return 0;
            } else if (this.valutazione > calciatore.valutazione) {
                return 1;
            }
            return -1;
        }
        throw new IllegalArgumentException("a non è un Calciatore");
    }

    @Override
    int confrontaCon(Anagrafica a) {
        if (a instanceof Calciatore) {
            Calciatore calciatore = (Calciatore) a;
            if (this.valutazione == calciatore.valutazione) {
                return 0;
            } else if (this.valutazione > calciatore.valutazione) {
                return 1;
            }
            return -1;
        }
        throw new IllegalArgumentException("a non è un Calciatore");
    }

}
