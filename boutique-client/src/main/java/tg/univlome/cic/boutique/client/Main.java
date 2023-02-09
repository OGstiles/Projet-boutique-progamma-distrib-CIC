/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tg.univlome.cic.boutique.client;

import java.time.LocalDate;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import tg.univlome.cic.boutique.client.entities.Categorie;
import tg.univlome.cic.boutique.client.entities.Produit;

/**
 *
 * @author Rasac
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // String url = "http://localhost:8080/boutique/api/produits";
        String url = "http://192.168.43.2:8080/boutique/api/produits";
        Client client = ClientBuilder.newClient();
        Response response = client.target(url)
                .path("2")
                .request(MediaType.APPLICATION_JSON)
                .get();
        if (response.getStatus() == 200) {
            Produit produit = response.readEntity(Produit.class);
            System.out.println(produit);
        } else {
            System.out.println("Erreur :" + response.getStatus());
        }
    }
    
}
