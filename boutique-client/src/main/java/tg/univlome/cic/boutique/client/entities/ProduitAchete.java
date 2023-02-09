/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.boutique.client.entities;

/**
 *
 * @author Rasac
 */
public class ProduitAchete {

    private int quantite;
    private double remise;
    private Achat achat;
    private Produit produit;

    public ProduitAchete() {
        this.quantite = 1;
        this.remise = 0;
    }

    public ProduitAchete(int quantite, double remise, Achat achat, Produit produit) {
        this.quantite = quantite;
        this.remise = remise;
        this.achat = achat;
        this.produit = produit;
    }

    public double getPrixTotal() {
        double prixTotal = this.quantite * this.produit.getPrixUnitaire() - this.remise;

        return prixTotal;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public double getRemise() {
        return remise;
    }

    public void setRemise(double remise) {
        this.remise = remise;
    }

    public Achat getAchat() {
        return achat;
    }

    public void setAchat(Achat achat) {
        this.achat = achat;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "ProduitAchete{" + "quantite=" + quantite + ", remise=" + remise + ", achat=" + achat + ", produit=" + produit + '}';
    }
}
