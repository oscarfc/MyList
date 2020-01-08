/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.agenda;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) {
        
        Agenda ag = new Agenda();
        ag.add(new Appuntamento(LocalDateTime.now(), "lavoro", null, null));
        ag.add(new Appuntamento(LocalDateTime.now(), "tennis", null, null));
        ag.add(new Appuntamento(LocalDateTime.now(), "lavoro", null, null));
        ag.add(new Appuntamento(LocalDateTime.now(), "sci", null, null));
        ag.add(new Appuntamento(LocalDateTime.now(), "nuoto", "collega di lavoro", null));

        ag.stampa();

        System.out.println("------------ ricerca ---------------------------");

        List<Appuntamento> appuntamentiTrovati = ag.search("lavoro");

        stampa(appuntamentiTrovati);

        System.out.println("------------ find ------------------------------");

        /*
        ag.find(5).ifPresentOrElse( a -> System.out.println(a), 
            () -> System.out.println("Appuntamento inesistente")
        );
         */
        
        Optional<Appuntamento> finded = ag.find(4);
        if (finded.isPresent()) {
            Appuntamento a = finded.get();
            System.out.println(a);
        } else {
            System.out.println("appuntamento non trovato");
        }
        
        System.out.println("------------ elimina ----------------------------");
        ag.delete(1);
        
        ag.stampa();
        
        System.out.println("----------- update ------------------------------");
        ag.update(1, new Appuntamento(LocalDateTime.now(), "lavoro", "Maria", "Ivrea"));
        ag.stampa();
        
    }

    private static void stampa(List<Appuntamento> appuntamentiTrovati) {
        for (Appuntamento a : appuntamentiTrovati) {
            System.out.println(a);
        }
    }
}
