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

/**
 *
 * @author tss
 */
public class Optionals {

    public static void main(String[] args) {
        Optional<A> opt = produce(-5);
        opt.ifPresent(a -> a.m());
        if (opt.isPresent()) {
            opt.get().m();
        }
        opt.ifPresentOrElse(a -> a.m(), () -> System.out.println("ciao"));
    }

    private static Optional<A> produce(int x) {
        return x > 0 ? Optional.of(new A()) : Optional.empty();
    }

    private static List<A> produce1(int x) {
        List<A> result = new ArrayList<>();
        result.add(new A());
        return x > 0 ? result : new ArrayList<>();
    }
}

class A {

    public void m() {
        System.out.println("ciao..");
    }
}
