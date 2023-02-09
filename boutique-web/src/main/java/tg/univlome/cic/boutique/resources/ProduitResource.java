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
import tg.univlome.cic.boutique.entities.Produit;
import tg.univlome.cic.boutique.service.ProduitService;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author boris
 */
@Path("produit")
public class ProduitResource {

    private ProduitService service;

    public ProduitResource() {
        this.service = ProduitService.getinstance();
    }

    @Produces({"application/json", "application/xml"})
    @Consumes({"application/json", "application/xml"})
    @GET
    public List<Produit> lister() {
        return this.service.lister();
    }

    @GET
    @Path("{id}")
    public Produit trouver(@PathParam("id") Long id) {
        return this.service.trouver(id);
    }

    @GET
    @Path("total")
    public int compter() {
        return this.service.compter();
    }

    @POST
    public void ajouter(Produit p) {
//        System.out.println(p);
        this.service.ajouter(p);
    }

    @PUT
    @Path("{id}")
    public Produit modifier(@PathParam("id") Long id, Produit p) {
        return this.service.modifier(id, p);
    }

    @DELETE
    @Path("{id}")
    public void supprimer(@PathParam("id") Long id) {
        this.service.supprimer(id);
    }
}
