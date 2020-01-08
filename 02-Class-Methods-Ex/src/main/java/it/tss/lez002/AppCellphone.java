/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.lez002;

import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author tss
 */
public class AppCellphone {

    public static void main(String[] args) {
        Cellphone a = new Cellphone("TIM", "123456789"),
                b = new Cellphone("TRE", "987654321"),
                c = new Cellphone("WIND", "11223344");

        Cellphone.setCost("TIM", "WIND", 0.5);
        System.out.println("costo -> " + a.getCost(c, 10));

    }
}

class Cellphone {

    private static final ArrayList<Tariffa> tariffario = new ArrayList<>();

    private final String operatore;
    private final String numero;

    public Cellphone(String operatore, String numero) {
        this.operatore = operatore;
        this.numero = numero;
    }

    /**
     * Calcola costo telefonata
     *
     * cerca nel tariffario la voce corrispondente ai due gestori coinvolti se
     * non la trova genera una eccezione altrimenti torna il costo
     *
     * @param to
     * @param min
     * @return
     */
    public double getCost(Cellphone to, int min) {

        for (int i = 0; i < tariffario.size(); i++) {
            Tariffa t = tariffario.get(i);
            if (t.from.equals(this.operatore) && t.to.equals(to.operatore)) {
                return t.cost * min;
            }
        }
        for (Tariffa t : tariffario) {
            if (t.from.equals(this.operatore) && t.to.equals(to.operatore)) {
                return t.cost * min;
            }
        }
        
        tariffario.forEach(t -> {
            if (t.from.equals(this.operatore) && t.to.equals(to.operatore)) {
                //return t.cost * min;
            }
        });
        
        return tariffario.stream()
                .filter(t -> t.equals(new Tariffa(this.operatore, to.operatore, 0)))
                .findFirst().orElseThrow()
                .cost * min;
        
        //throw new IllegalArgumentException("Tariffario non disponibile...");
        /*
        Tariffa t = new Tariffa(this.operatore, to.operatore, 0);
        if (!tariffario.contains(t)) {
            throw new IllegalArgumentException("Tariffario non disponibile...");
        }
        return tariffario.get(tariffario.indexOf(t)).cost * min;
         */
    }

    /**
     * Aggiunge una voce al tariffario
     *
     * @param from
     * @param to
     * @param cost
     */
    public static void setCost(String from, String to, double cost) {
        tariffario.add(new Tariffa(from, to, cost));
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.numero);
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
        final Cellphone other = (Cellphone) obj;
        return Objects.equals(this.numero, other.numero);
    }

    @Override
    public String toString() {
        return "Cellphone{" + "operatore=" + operatore + ", numero=" + numero + '}';
    }

    /**
     * memorizza il costo al minuto di una chiamata da un operatore ad un'altro
     *
     * @author tss
     */
    private static class Tariffa {

        private String from;
        private String to;
        private double cost;

        public Tariffa(String from, String to, double cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        @Override
        public int hashCode() {
            int hash = 5;
            hash = 13 * hash + Objects.hashCode(this.from);
            hash = 13 * hash + Objects.hashCode(this.to);
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
            final Tariffa other = (Tariffa) obj;
            if (!Objects.equals(this.from, other.from)) {
                return false;
            }
            return Objects.equals(this.to, other.to);
        }

        @Override
        public String toString() {
            return "Tariffa{" + "from=" + from + ", to=" + to + ", cost=" + cost + '}';
        }

    }
}
