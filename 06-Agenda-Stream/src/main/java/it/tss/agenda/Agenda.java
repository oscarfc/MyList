/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.agenda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * divieto di uso degli Stream, forEach, lambda ecc...
 *
 * @author tss
 */
public class Agenda {

    private final List<Appuntamento> appuntamenti = new ArrayList<>();

    /**
     * aggiunge un appuntamento
     *
     * @param a
     */
    public void add(Appuntamento a) {
        appuntamenti.add(a);
    }

    /**
     * ricerca per motivo o persona o luogo
     *
     * @param ricerca
     * @return
     */
    public List<Appuntamento> search(String ricerca) {
        List<Appuntamento> result = new ArrayList<>();

        for (Appuntamento a : appuntamenti) {
            if (a.findMotivo(ricerca) || a.findPersona(ricerca)
                    || a.findLuogo(ricerca)) {
                result.add(a);
            }
        }
        return result;
    }

    /**
     * ritorna se esiste l'appuntamento con id uguale
     *
     * @param id
     * @return
     */
    public Optional<Appuntamento> find(int id) {
        Optional<Appuntamento> result = Optional.empty();
        for (Appuntamento a : appuntamenti) {
            if (a.getId() == id) {
                result = Optional.of(a);
                break;
            }
        }
        return result;
    }

    public Optional<Appuntamento> find1(int id) {
        for (Appuntamento a : appuntamenti) {
            if (a.getId() == id) {
                return Optional.of(a);
            }
        }
        return Optional.empty();
    }

    /**
     * aggiorna se esiste l'appuntamento con id uguale al nuovo appuntamento
     *
     * @param id
     * @param a
     */
    public void update(int id, Appuntamento a) {
        delete(id);
        add(a);
    }

    /**
     * elimina se esiste l'appuntamento con id uguale altrimenti non fa nulla
     *
     * @param id
     */
    public void delete(int id) {
        Optional<Appuntamento> found = find(id);
        if (found.isPresent()) {
            appuntamenti.remove(found.get());
        }
    }

    /**
     * elimina se esiste l'appuntamento con id uguale altrimenti genera un
     * errore
     *
     * @param id
     */
    public void delete1(int id) {
        Optional<Appuntamento> found = find(id);
        if (found.isPresent()) {
            appuntamenti.remove(found.get());
        } else {
            throw new IllegalArgumentException("appuntamento inesistente");
        }
    }

    /**
     * elimina se esiste l'appuntamento con id uguale e ritorna true altrimenti
     * non fa nulla e ritorna false
     *
     * @param id
     */
    public boolean delete2(int id) {
        boolean result = false;
        Optional<Appuntamento> found = find(id);
        if (found.isPresent()) {
            appuntamenti.remove(found.get());
            result = true;
        }
        return result;
    }

    /**
     * elimina se esiste l'appuntamento con id uguale altrimenti non fa nulla
     *
     * @param id
     */
    public void delete3(int id) {
        find(id).ifPresent(a -> appuntamenti.remove(a));
    }

    /**
     * elimina se esiste l'appuntamento con id uguale altrimenti non fa nulla
     *
     * @param id
     */
    public void delete4(int id) {
        find(id).ifPresent(appuntamenti::remove);
    }

    /**
     * elimina se esiste l'appuntamento con id uguale altrimenti genera un
     * errore
     *
     * @param id
     */
    public void delete5(int id) {
        Appuntamento found = find(id).orElseThrow();
        appuntamenti.remove(found);
    }

    /**
     * elimina se esiste l'appuntamento con id uguale e ritorna true altrimenti
     * non fa nulla e ritorna false
     *
     * @param id
     */
    public boolean delete6(int id) {
        find(id).ifPresent(appuntamenti::remove);
        return find(id).isPresent();
    }

    public void stampa() {
        //appuntamenti.forEach((Appuntamento a) -> System.out.println(a));
        //appuntamenti.forEach(a -> System.out.println(a));
        appuntamenti.forEach(System.out::println);
    }

    /**
     * ritorna tutti gli appuntamenti dell'Agenda
     *
     * @return
     */
    public List<Appuntamento> all() {
        return new ArrayList<>(appuntamenti);
    }
}
