/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.agenda;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author tss
 */
public class App  {

    public static void main(String[] args) {
        
        
        Agenda ag = new Agenda();
        ag.add(new Appuntamento(LocalDateTime.of(2020, Month.MARCH, 20, 9, 0), 
                "lavoro", null, null));
        ag.add(new Appuntamento(LocalDateTime.of(2020, Month.FEBRUARY, 2, 10, 0), 
                "tennis", null, null));
        ag.add(new Appuntamento(LocalDateTime.of(2020, Month.JULY, 11, 7, 0), 
                "lavoro", null, null));
        ag.add(new Appuntamento(LocalDateTime.of(2020, Month.JUNE, 11, 18, 0), 
                "sci", null, null));
        ag.add(new Appuntamento(LocalDateTime.of(2020, Month.JANUARY, 28, 19, 0), 
                "nuoto", "collega di lavoro", null));

        
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
        
        Optional<Appuntamento> found = ag.find(4);
        if (found.isPresent()) {
            Appuntamento a = found.get();
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
        
        System.out.println("----------- ordinamento ---------------------------");
        
        List<Appuntamento> all = ag.all();
        Collections.sort(all);
        stampa(all);
        
        System.out.println("----------- ordinamento al volo ---------------------------");
    
        //Uso di classe anonima.... vecchio modo
        Collections.sort(all,new Comparator<Appuntamento>() {
            @Override
            public int compare(Appuntamento a1, Appuntamento a2) {
                return a1.getMotivo().compareTo(a2.getMotivo());
            }
        });
        
        //Uso funzione lambda con una riga sola
        Collections.sort(all,
                (Appuntamento a1, Appuntamento a2) -> a1.getMotivo().compareTo(a2.getMotivo()));
        
        //Uso funzione lambda con più righe
        Collections.sort(all,
                (Appuntamento a1, Appuntamento a2) -> {
                    return a1.getMotivo().compareTo(a2.getMotivo());
                });
        
        //uso di method reference 
        Collections.sort(all, App::ordinaPerMotivo);
        
        stampa(all);
    
    }

    private static void stampa(List<Appuntamento> appuntamenti) {
        for (Appuntamento a : appuntamenti) {
            System.out.println(a);
        }
    }
    
    public static int ordinaPerMotivo(Appuntamento a1, Appuntamento a2){
        return a1.getMotivo().compareTo(a2.getMotivo());
    }
}

