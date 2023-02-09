/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.boutique.entites;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Rasac
 */
public class Achat {
    
    private Long id;
    private LocalDateTime dateAchat;
    private double remise;
    private Employe employe;
    private Client client;
    
    private List<ProduitAchete> listeProduitAchete;

    public Achat() {
        this.remise = 0;
        this.listeProduitAchete = new ArrayList<ProduitAchete>();
    }

    public Achat(LocalDateTime dateAchat, double remise, Employe employe, Client client, List<ProduitAchete> listeProduitAchete) {
        this.dateAchat = dateAchat;
        this.remise = remise;
        this.employe = employe;
        this.client = client;
        this.listeProduitAchete = listeProduitAchete;
    }

    public Achat(Long id, LocalDateTime dateAchat, double remise, Employe employe, Client client, List<ProduitAchete> listeProduitAchete) {
        this.id = id;
        this.dateAchat = dateAchat;
        this.remise = remise;
        this.employe = employe;
        this.client = client;
        this.listeProduitAchete = listeProduitAchete;
    }
    
    public double getPrixTotal() {
        double prixTotal = 0;
        
        for (ProduitAchete produitAchete : this.listeProduitAchete) {
            prixTotal = prixTotal + produitAchete.getPrixTotal();
        }
        
        return prixTotal;
    }
    
    public double getRemiseTotale() {
        double remiseTotale = this.remise;
        
        for (ProduitAchete produitAchete : this.listeProduitAchete) {
            remiseTotale = remiseTotale + produitAchete.getRemise();
        }
        
        return remiseTotale;
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDateAchat() {
        return dateAchat;
    }

    public void setDateAchat(LocalDateTime dateAchat) {
        this.dateAchat = dateAchat;
    }

    public double getRemise() {
        return remise;
    }

    public void setRemise(double remise) {
        this.remise = remise;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public List<ProduitAchete> getListeProduitAchete() {
        return listeProduitAchete;
    }

    public void setListeProduitAchete(List<ProduitAchete> listeProduitAchete) {
        this.listeProduitAchete = listeProduitAchete;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 83 * hash + Objects.hashCode(this.id);
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
        final Achat other = (Achat) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Achat{" + "id=" + id + ", dateAchat=" + dateAchat + ", remise=" + remise + ", employe=" + employe + ", client=" + client + '}';
    }
}
