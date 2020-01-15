/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.esercizio.product;

import java.util.Comparator;
import java.util.Objects;

/**
 *
 * @author tss
 */
public class Product implements Comparable<Product> {

    private final String descrizione;
    private final double prezzo;
    private static Product mostExpensive;
    public static Comparator<Product> comparatorByPrice
            = (Product p1, Product p2) -> p1.getPrezzo() == p2.getPrezzo() ? 0
            : p1.getPrezzo() > p2.getPrezzo() ? 1 : -1;

    public static Comparator<Product> comparator1ByPrice = (Product p1, Product p2) -> {
        if (p1.getPrezzo() == p2.getPrezzo()) {
            return 0;
        } else if (p1.getPrezzo() > p2.getPrezzo()) {
            return 1;
        }
        return -1;
    };
    
    public Product(String descrizione, double prezzo) {
        this.descrizione = descrizione;
        this.prezzo = prezzo;
        checkMostExpensive();
    }

    private void checkMostExpensive() {
        if (mostExpensive == null || mostExpensive.getPrezzo() < this.getPrezzo()) {
            mostExpensive = this;
        }
    }

    public static Product getMostExpensive() {
        return mostExpensive;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public double getPrezzo() {
        return prezzo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.descrizione);
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
        final Product other = (Product) obj;
        return Objects.equals(this.descrizione, other.descrizione);
    }

    @Override
    public String toString() {
        return "Product{" + "descrizione=" + descrizione + ", prezzo=" + prezzo + '}';
    }

    @Override
    public int compareTo(Product p) {
        return this.descrizione.compareTo(p.getDescrizione());
    }

}
