/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.boutique.client;

import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import tg.univlome.cic.boutique.client.entities.Categorie;

/**
 *
 * @author Rasac
 */
public class CategorieClient {
    
    private final String URL = "http://localhost:8080/boutique/api/categorie/";
    private final Client client;
    private static CategorieClient instance;
    
    public CategorieClient() {
        this.client = ClientBuilder.newClient();
    }
    
    public static synchronized CategorieClient getInstance() {
        if(instance == null) {
            instance = new CategorieClient();
        }
        
        return instance;
    }
    
    public List<Categorie> lister() {
        Response response = client.target(URL)
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();
        if (response.getStatus() == 200) {
//            Categorie categorie = response.readEntity(Categorie.class);
            String categorie = response.readEntity(String.class);
            System.out.println(categorie);
//            return categorie;
        } else {
            System.out.println("Erreur: " + response.getStatus());
        }
        
        return null;
    }

    public Categorie trouver(Long id) {
        Response response = client.target(URL)
                .path(id.toString())
                .request(MediaType.APPLICATION_JSON_TYPE)
                .get();
        if (response.getStatus() == 200) {
            Categorie categorie = response.readEntity(Categorie.class);
            return categorie;
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

    public void ajouter(Categorie e) {
    }

    public Categorie modifier(Categorie e) {
        return null;
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
