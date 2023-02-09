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
import tg.univlome.cic.boutique.entities.Achat;
import java.util.List;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import tg.univlome.cic.boutique.service.AchatService;

/**
 *
 * @author boris
 */
@Path("achat")
public class AchatResource {

    private AchatService achatService;

    public AchatResource() {
        this.achatService = AchatService.getinstance();
    }

    @Produces({"application/json", "application/xml"})
    @GET
    public List<Achat> lister() {
        return this.achatService.lister();
    }

    @GET
    @Path("{id}")
    public Achat trouver(@PathParam("id") Long id) {
        return this.achatService.trouver(id);
    }

    @GET
    @Path("total")
    public int compter() {
        return this.achatService.compter();
    }

    @POST
    public void ajouter(Achat e) {
        this.achatService.ajouter(e);
    }

    @PUT
    public void modifier(Achat e) {
        this.achatService.modifier(e);
    }

    @DELETE
    @Path("{id}")
    public void supprimer(@PathParam("id") Long id) {
        this.achatService.supprimer(id);
    }
}
