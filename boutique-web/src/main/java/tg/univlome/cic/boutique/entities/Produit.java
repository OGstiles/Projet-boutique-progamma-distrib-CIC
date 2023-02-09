/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.boutique.entities;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author boris
 */
public class Produit {

    private Long id;
    private String libelle;
    private double prixUnitaire;
    private LocalDate datePeremption;
    private Categorie categorie;

    public Produit() {

    }

    public Produit(String libelle, double prixUnitaire, LocalDate datePeremption, Categorie categorie) {
        this.libelle = libelle;
        this.prixUnitaire = prixUnitaire;
        this.datePeremption = datePeremption;
        this.categorie = categorie;
    }

    public Produit(Long id, String libelle, double prixUnitaire, LocalDate datePeremption, Categorie categorie) {
        this.id = id;
        this.libelle = libelle;
        this.prixUnitaire = prixUnitaire;
        this.datePeremption = datePeremption;
        this.categorie = categorie;
    }

    public boolean estPerime() {
        return estPerime(LocalDate.now());
    }

    public boolean estPerime(LocalDate dateReference) {
        boolean estPerime;

        if (this.datePeremption.isAfter(dateReference) || this.datePeremption.isEqual(dateReference)) {
            estPerime = true;
        } else if (this.datePeremption.isBefore(dateReference)) {
            estPerime = false;
        } else {
            estPerime = false;
        }

        return estPerime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public LocalDate getDatePeremption() {
        return datePeremption;
    }

    public void setDatePeremption(LocalDate datePeremption) {
        this.datePeremption = datePeremption;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 61 * hash + Objects.hashCode(this.id);
        hash = 61 * hash + Objects.hashCode(this.libelle);
        hash = 61 * hash + (int) (Double.doubleToLongBits(this.prixUnitaire) ^ (Double.doubleToLongBits(this.prixUnitaire) >>> 32));
        hash = 61 * hash + Objects.hashCode(this.datePeremption);
        hash = 61 * hash + Objects.hashCode(this.categorie);
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
        final Produit other = (Produit) obj;
        if (this.id != other.id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Produit{" + "id=" + id + ", libelle=" + libelle + ", prixUnitaire=" + prixUnitaire + ", datePeremption=" + datePeremption + ", categorie=" + categorie + '}';
    }
}
