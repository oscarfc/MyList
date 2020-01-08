/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.lez004;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 *
 * @author tss
 */
public class AppRubrica {

    public static void main(String[] args) {

        
        Contatto c = new Contatto.Builder(3)
                .professione("a")
                .build();
        
        Numeri n = new Numeri(1, 2);
        System.out.println(n.getX());

        Rubrica r = new Rubrica();
        r.add(new Contatto.Builder(1)
                .cognome("rossi")
                .telefono("123456789")
                .build());
        r.add(new Contatto.Builder(2)
                .cognome("bianchi")
                .citta("torino")
                .telefono("345611111")
                .build());

        System.out.println("------------------- rubrica -----------------");

        r.stampa();

    }
}

class Rubrica {

    private final List<Contatto> contatti = new ArrayList<>();

    public void add(Contatto c) {
        contatti.add(c);
    }

    public void update(Contatto c) {
        int idx = contatti.indexOf(c);
        if (idx != -1) {
            contatti.set(idx, c);
        }
    }

    public List<Contatto> cerca(String ricerca) {
        return contatti.stream()
                .filter(c -> c.getCognome().contains(ricerca)
                || c.getEmail().contains(ricerca)
                || c.getTelefono().contains(ricerca))
                .collect(Collectors.toList());
    }

    public void delete(Contatto c) {
        contatti.remove(c);
    }

    public Optional<Contatto> find(long id) {
        return contatti.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
    }

    public List<Contatto> getContatti() {
        return new ArrayList<>(contatti);

        //return Collections.unmodifiableList(contatti);
    }

    public void stampa() {
        contatti.stream().forEach(c -> System.out.println(c));
    }
}

class Contatto {

    private final String cognome, nome, titolo, email, telefono, indirizzo, citta, provincia, professione;
    private final long id;

    private Contatto(Builder b) {
        this.cognome = b.cognome;
        this.nome = b.nome;
        this.titolo = b.titolo;
        this.email = b.email;
        this.telefono = b.telefono;
        this.indirizzo = b.indirizzo;
        this.citta = b.citta;
        this.provincia = b.provincia;
        this.professione = b.professione;
        this.id = b.id;
    }

    public String getCognome() {
        return cognome;
    }

    public String getNome() {
        return nome;
    }

    public String getTitolo() {
        return titolo;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public String getCitta() {
        return citta;
    }

    public String getProvincia() {
        return provincia;
    }

    public String getProfessione() {
        return professione;
    }

    public long getId() {
        return id;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + (int) (this.id ^ (this.id >>> 32));
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
        final Contatto other = (Contatto) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return "Contatto{" + "cognome=" + cognome + ", email=" + email + ", telefono=" + telefono + ", id=" + id + '}';
    }

    static class Builder {

        private String cognome, nome, titolo, email, telefono, indirizzo, citta, provincia, professione;
        private long id;

        /**
         * costruttore con le proprieta obbligatorie
         *
         * @param id
         */
        public Builder(long id) {
            this.id = id;
        }

        public Builder cognome(String cognome) {
            this.cognome = cognome;
            return this;
        }

        public Builder nome(String nome) {
            this.nome = nome;
            return this;
        }

        public Builder titolo(String titolo) {
            this.titolo = titolo;
            return this;
        }

        public Builder email(String email) {
            this.email = email;
            return this;
        }

        public Builder telefono(String telefono) {
            this.telefono = telefono;
            return this;
        }

        public Builder indirizzo(String indirizzo) {
            this.indirizzo = indirizzo;
            return this;
        }

        public Builder citta(String citta) {
            this.citta = citta;
            return this;
        }

        public Builder provincia(String provincia) {
            this.provincia = provincia;
            return this;
        }

        public Builder professione(String professione) {
            this.professione = professione;
            return this;
        }

        public Contatto build() {
            return new Contatto(this);
        }

    }
}

class Numeri {

    private int x, y;

    public Numeri(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

}

class Contatti {

    private Contatto c1, c2;

    public Contatti(Contatto c1, Contatto c2) {
        this.c1 = c1;
        this.c2 = c2;
    }

    public Contatto getC1() {
        return c1;
    }

    public Contatto getC2() {
        return c2;
    }

}
