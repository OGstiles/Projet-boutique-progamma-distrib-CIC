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
import tg.univlome.cic.boutique.entities.ProduitAchete;
import java.util.List;
import javax.ws.rs.PathParam;
import tg.univlome.cic.boutique.service.ProduitAcheteService;

/**
 *
 * @author boris
 */
@Path("produit-achete")
public class ProduitAcheteResource {

    private ProduitAcheteService produitAcheteService;

    public ProduitAcheteResource() {
        this.produitAcheteService = ProduitAcheteService.getinstance();
    }

    @GET
    public List<ProduitAchete> lister() {
        return this.produitAcheteService.lister();
    }

    @GET
    @Path("{achat_id}/{produit_id}")
    public ProduitAchete trouver(@PathParam("achat_id") Long achat_id, @PathParam("produit_id") Long produit_id) {
        return this.produitAcheteService.trouver(achat_id, produit_id);
    }

    @GET
    @Path("total")
    public int compter() {
        return this.produitAcheteService.compter();
    }

    @POST
    public void ajouter(ProduitAchete e) {
        this.produitAcheteService.ajouter(e);
    }

    @PUT
    public void modifier(ProduitAchete e) {
        this.produitAcheteService.modifier(e);
    }

    @DELETE
    @Path("{achat_id}/{produit_id}")
    public void supprimer(@PathParam("achat_id") Long achat_id, @PathParam("produit_id") Long produit_id) {
        this.produitAcheteService.supprimer(achat_id, produit_id);
    }
}
