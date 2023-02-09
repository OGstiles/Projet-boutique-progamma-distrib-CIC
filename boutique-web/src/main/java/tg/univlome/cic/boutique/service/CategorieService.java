/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.boutique.service;

import java.util.List;
import java.util.ArrayList;
import tg.univlome.cic.boutique.entities.Categorie;
import java.util.Objects;

/**
 *
 * @author boris
 */
public class CategorieService {

    private static CategorieService instance;
    private static List<Categorie> liste;

    public CategorieService() {
        this.liste = new ArrayList<Categorie>();

        this.liste.add(new Categorie(1l, "Chaussure", "Mocassin, Paire, ..."));
        this.liste.add(new Categorie(2l, "Robe", "Ovale, Moulante, ..."));
    }

    public static synchronized CategorieService getinstance() {
        if (instance == null) {
            instance = new CategorieService();
        }

        return instance;
    }

    public List<Categorie> lister() {
        return this.liste;
    }

    public Categorie trouver(Long id) {
        for (Categorie e : liste) {
            if (Objects.equals(e.getId(), id)) {
                return e;
            }
        }
        return null;
    }

    public int compter() {
        return this.liste.size();
    }

    public void ajouter(Categorie e) {
        if (e != null) {
            this.liste.add(e);
        }
    }

    public void modifier(Categorie e) {
        if (this.liste.contains(e)) {
            this.liste.set(this.liste.indexOf(e), e);
        }
    }

    public void supprimer(Long id) {
        this.liste.remove(trouver(id));
    }
}
