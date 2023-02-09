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
import tg.univlome.cic.boutique.entities.Personne;
import java.util.List;
import javax.ws.rs.PathParam;
import tg.univlome.cic.boutique.service.PersonneService;

/**
 *
 * @author boris
 */
@Path("personne")
public class PersonneResource {

    private PersonneService personneService;

    public PersonneResource() {
        this.personneService = PersonneService.getinstance();
    }

    @GET
    public List<Personne> lister() {
        return this.personneService.lister();
    }

    @GET
    @Path("{id}")
    public Personne trouver(@PathParam("id") Long id) {
        return this.personneService.trouver(id);
    }

    @GET
    @Path("total")
    public int compter() {
        return this.personneService.compter();
    }

    @POST
    public void ajouter(Personne e) {
        this.personneService.ajouter(e);
    }

    @PUT
    public void modifier(Personne e) {
        this.personneService.modifier(e);
    }

    @DELETE
    @Path("{id}")
    public void supprimer(@PathParam("id") Long id) {
        this.personneService.supprimer(id);
    }
}
