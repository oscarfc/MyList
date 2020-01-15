/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.esercizio.product;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) {
        Product a = new Product("Sale", 0.60),
                b = new Product("Zucchero", 0.95),
                c = new Product("Cae'", 2.54);

        System.out.println(Product.getMostExpensive());
        System.out.println(b.compareTo(c));

        System.out.println(Product.comparatorByPrice.compare(b, c));
    }
}
