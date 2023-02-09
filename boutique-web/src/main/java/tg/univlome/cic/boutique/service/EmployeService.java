/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.boutique.service;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import tg.univlome.cic.boutique.entities.Employe;

/**
 *
 * @author boris
 */
public class EmployeService {

    private static EmployeService instance;
    private static List<Employe> liste;

    public EmployeService() {
        liste = new ArrayList<Employe>();

        liste.add(new Employe(1l, "ABALO", "A. Kofi", LocalDate.of(1995, 1, 1), ""));
        liste.add(new Employe(2l, "KOSSI", "B. Kokou", LocalDate.of(1990, 2, 7), ""));
    }

    public static synchronized EmployeService getinstance() {
        if (instance == null) {
            instance = new EmployeService();
        }

        return instance;
    }

    public List<Employe> lister() {
        return liste;
    }

    public Employe trouver(Long id) {
        for (Employe e : liste) {
            if (Objects.equals(e.getId(), id)) {
                return e;
            }
        }
        return null;
    }

    public int compter() {
        return liste.size();
    }

    public void ajouter(Employe e) {
        liste.add(e);
    }

    public void modifier(Employe e) {
        if (liste.contains(e)) {
            liste.set(liste.indexOf(e), e);
        }
    }

    public void supprimer(Long id) {
        liste.remove(id.intValue());
    }
}
