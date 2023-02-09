/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.boutique.service;

import java.util.List;
import java.util.ArrayList;
import tg.univlome.cic.boutique.entities.Produit;
import tg.univlome.cic.boutique.entities.Categorie;
import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author boris
 */
public class ProduitService {

    private static ProduitService instance;
    private CategorieService categorieService;
    private static List<Produit> liste;

    public ProduitService() {
        this.categorieService = CategorieService.getinstance();
        liste = new ArrayList<Produit>();

        liste.add(new Produit(1l, "Fils", 1000.0, LocalDate.of(2025, 12, 1), categorieService.trouver(1l)));
        liste.add(new Produit(2l, "Adidas", 2500.0, LocalDate.of(2030, 12, 1), categorieService.trouver(1l)));
        liste.add(new Produit(3l, "Zara", 10000.0, LocalDate.of(2035, 12, 4), categorieService.trouver(1l)));
    }

    public static synchronized ProduitService getinstance() {
        if (instance == null) {
            instance = new ProduitService();
        }

        return instance;
    }

    public List<Produit> lister() {
        return liste;
    }

    public Produit trouver(Long id) {
        for (Produit e : liste) {
            if (Objects.equals(e.getId(), id)) {
                return e;
            }
        }
        return null;
    }

    public int compter() {
        return liste.size();
    }

    public void ajouter(Produit e) {
        if (e != null) {
            liste.add(e);
        }
    }

    public Produit modifier(Long id, Produit e) {
        if (liste.contains(e)) {
            return liste.set(liste.indexOf(e), e);
        }
        
        return null;
    }

    public void supprimer(Long id) {
        liste.remove(id.intValue());
    }
}
