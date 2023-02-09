/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.boutique.resources;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import tg.univlome.cic.boutique.entities.Categorie;
import tg.univlome.cic.boutique.service.CategorieService;
import java.util.List;
import javax.ws.rs.PathParam;

/**
 *
 * @author boris
 */
@Path("categorie")
public class CategorieResource {

    private CategorieService service;

    public CategorieResource() {
        this.service = CategorieService.getinstance();
    }

    @GET
    public List<Categorie> lister() {
        return this.service.lister();
    }

    @GET
    @Path("{id}")
    public Categorie trouver(@PathParam("id") Long id) {
        return this.service.trouver(id);
    }

    @GET
    @Path("total")
    public int compter() {
        return this.service.compter();
    }

    @POST
    public void ajouter(Categorie e) {
        this.service.ajouter(e);
    }

    @PUT
    public void modifier(Categorie e) {
        this.service.modifier(e);
    }

    @DELETE
    public void supprimer(Long id) {
        this.service.supprimer(id);
    }
}
