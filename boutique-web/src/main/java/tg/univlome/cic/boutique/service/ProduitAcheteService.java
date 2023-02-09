/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.boutique.service;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import tg.univlome.cic.boutique.entities.ProduitAchete;

/**
 *
 * @author boris
 */
public class ProduitAcheteService {

    private static ProduitAcheteService instance;
    private static List<ProduitAchete> liste;
    private AchatService achatService;
    private ProduitService produitService;

    public ProduitAcheteService() {
        liste = new ArrayList<ProduitAchete>();
        this.achatService = AchatService.getinstance();
        this.produitService = ProduitService.getinstance();

        liste.add(new ProduitAchete(10, 600, achatService.trouver(1l), produitService.trouver(1l)));
    }

    public static synchronized ProduitAcheteService getinstance() {
        if (instance == null) {
            instance = new ProduitAcheteService();
        }

        return instance;
    }

    public List<ProduitAchete> lister() {
        return liste;
    }

    public ProduitAchete trouver(Long achat_id, Long produit_id) {
        for (ProduitAchete e : liste) {
            if (Objects.equals(e.getAchat().getId(), achat_id) && Objects.equals(e.getProduit().getId(), produit_id)) {
                return e;
            }
        }
        return null;
    }

    public int compter() {
        return liste.size();
    }

    public void ajouter(ProduitAchete e) {
        liste.add(e);
    }

    public void modifier(ProduitAchete e) {
        if (liste.contains(e)) {
            liste.set(liste.indexOf(e), e);
        }
    }

    public void supprimer(Long achat_id, Long produit_id) {
        for (ProduitAchete e : liste) {
            if (Objects.equals(e.getAchat().getId(), achat_id) && Objects.equals(e.getProduit().getId(), produit_id)) {
                liste.remove(e);
            }
        }
    }
}
