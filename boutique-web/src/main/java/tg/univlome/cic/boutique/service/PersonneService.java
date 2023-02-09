/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.boutique.service;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import tg.univlome.cic.boutique.entities.Personne;

/**
 *
 * @author boris
 */
public class PersonneService {

    private static PersonneService instance;
    private static List<Personne> liste;

    public PersonneService() {
        liste = new ArrayList<Personne>();
    }

    public static synchronized PersonneService getinstance() {
        if (instance == null) {
            instance = new PersonneService();
        }

        return instance;
    }

    public List<Personne> lister() {
        return liste;
    }

    public Personne trouver(Long id) {
        for (Personne e : liste) {
            if (Objects.equals(e.getId(), id)) {
                return e;
            }
        }
        return null;
    }

    public int compter() {
        return liste.size();
    }

    public void ajouter(Personne e) {
        liste.add(e);
    }

    public void modifier(Personne e) {
        if (liste.contains(e)) {
            liste.set(liste.indexOf(e), e);
        }
    }

    public void supprimer(Long id) {
        liste.remove(id.intValue());
    }
}
