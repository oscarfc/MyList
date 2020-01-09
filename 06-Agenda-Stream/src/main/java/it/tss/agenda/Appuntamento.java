/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.agenda;

import java.time.LocalDateTime;

/**
 * Deve essere immodificabile
 *
 *
 * @author tss
 */
public class Appuntamento implements Comparable<Appuntamento> {

    private static int counter = 1;

    private final int id; //obbligatorio

    private final LocalDateTime quando; //obbligatorio

    private final String motivo;

    private final String persona;

    private final String luogo;

    public Appuntamento(LocalDateTime quando) {
        this(quando, "non specificato", "non si sa..", "dove capita..");
    }

    public Appuntamento(LocalDateTime quando, String motivo, String persona, String luogo) {
        this.id = counter++;
        this.quando = quando;
        this.motivo = motivo;
        this.persona = persona;
        this.luogo = luogo;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getQuando() {
        return quando;
    }

    public String getMotivo() {
        return motivo;
    }

    public String getPersona() {
        return persona;
    }

    public String getLuogo() {
        return luogo;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.id;
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
        final Appuntamento other = (Appuntamento) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return String.format("Appuntamento %s il %s con %s per %s a %s", id, quando, persona, motivo, luogo);
    }

    public boolean findMotivo(String ricerca) {
        return this.motivo != null && this.motivo.contains(ricerca);
    }

    public boolean findPersona(String ricerca) {
        return this.persona != null && this.persona.contains(ricerca);
    }

    public boolean findLuogo(String ricerca) {
        return this.luogo != null && this.luogo.contains(ricerca);
    }

    @Override
    public int compareTo(Appuntamento a) {
         return this.quando.compareTo(a.getQuando());
    }

}
