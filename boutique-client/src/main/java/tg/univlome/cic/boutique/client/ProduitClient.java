/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.boutique.client;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import tg.univlome.cic.boutique.client.entities.Produit;

/**
 *
 * @author Rasac
 */
public class ProduitClient {
    
    private final String URL = "http://localhost:8080/boutique/api/produit/";
    private Client client;
    private static ProduitClient instance;
    
    public ProduitClient() {
        this.client = ClientBuilder.newClient();
    }
    
    public static synchronized ProduitClient getInstance() {
        if(instance == null) {
            instance = new ProduitClient();
        }
        
        return instance;
    }
    
    public List<Produit> lister() {
        Response response = client.target(URL)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();
        if (response.getStatus() == 200) {
//            List<Produit> produits = response.readEntity(Produit.class);
            String produits = response.readEntity(String.class);
            System.out.println(produits);
//            return produits;
        } else {
            System.out.println("Erreur: " + response.getStatus());
        }
        
        return null;
    }

    public Produit trouver(Long id) {
        Response response = client.target(URL)
                .path(id.toString())
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();
        if (response.getStatus() == 200) {
            Produit produit = response.readEntity(Produit.class);
            return produit;
        } else {
            System.out.println("Erreur: " + response.getStatus());
        }
        
        return null;
    }
//
    public int compter() {
        Response response = client.target(URL)
                .path("/total")
                .request()
                .get();
        if (response.getStatus() == 200) {
            int total = response.readEntity(Integer.class);
            return total;
        } else {
            System.out.println("Erreur: " + response.getStatus());
        }
        
        return -1;
    }

    public void ajouter(Produit e) {
        Response response = client.target(URL)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .post(Entity.json(e));
        if (response.getStatus() == 204) {
            System.out.println("Ajouté avec succès");
        } else {
            System.out.println("Erreur: " + response.getStatus());
        }
    }

    public Produit modifier(Long id, Produit e) {
        Response response = client.target(URL)
                .path(id.toString())
                .request(MediaType.APPLICATION_JSON_TYPE)
                .put(Entity.json(e));
        if (response.getStatus() == 204) {
            Produit produit = response.readEntity(Produit.class);
            System.out.println("Modifié avec succès");
            
            return produit;
        } else {
            System.out.println("Erreur: " + response.getStatus());
            return null;
        }
    }
    
    public void supprimer(Long id) {
        Response response = client.target(URL)
                .path(id.toString())
                .request()
                .delete();
        if (response.getStatus() == 204) {
            System.out.println("Suppimé avex succès");
        } else {
            System.out.println("Erreur: " + response.getStatus());
        }
    }
}
