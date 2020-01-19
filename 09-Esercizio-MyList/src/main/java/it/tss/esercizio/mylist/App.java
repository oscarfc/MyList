/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.esercizio.mylist;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) {

        A[] start = {new A("x1"), new A("x2"), new A("x3")};

        TssList<A> list = new TssList<>(start);

        Iterator<A> iterator = list.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println(list);

        list.add(new A("a1"));
        list.add(new A("b1"));
        list.add(new A("c1"));
        list.add(new A("d1"));
        list.add(new A("e1"));

        System.out.println(list.contains(new A("k1")));
        System.out.println(list);

        Object[] ob = list.toArray();
        Arrays.stream(ob).forEach(System.out::println);

        System.out.println(list.add(new A("add")));
        System.out.println(list);

        System.out.println(list.indexOf(new A("c1")));

        System.out.println(list.remove(new A("c2")));
        System.out.println(list.remove(new A("c1")));
        System.out.println(list);

        ArrayList<A> l = new ArrayList<>();
        l.add(new A("all_1"));
        l.add(new A("all_2"));
        l.add(new A("all_3"));
        System.out.println(list.addAll(l));
        System.out.println(list);

        System.out.println(list.addAll(2, l));
        System.out.println(list);

        System.out.println(list.removeAll(l));
        System.out.println(list);

        System.out.println(list.remove(2));
        System.out.println(list);
   }
}

class A {

    String msg;

    public A(String msg) {
        this.msg = msg;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 73 * hash + Objects.hashCode(this.msg);
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
        final A other = (A) obj;
        if (!Objects.equals(this.msg, other.msg)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return msg;
    }

}
