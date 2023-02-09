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
import tg.univlome.cic.boutique.entities.Client;
import java.util.List;
import javax.ws.rs.PathParam;
import tg.univlome.cic.boutique.service.ClientService;

/**
 *
 * @author boris
 */
@Path("client")
public class ClientResource {

    private ClientService clientService;

    public ClientResource() {
        this.clientService = ClientService.getinstance();
    }

    @GET
    public List<Client> lister() {
        return this.clientService.lister();
    }

    @GET
    @Path("{id}")
    public Client trouver(@PathParam("id") Long id) {
        return this.clientService.trouver(id);
    }

    @GET
    @Path("total")
    public int compter() {
        return this.clientService.compter();
    }

    @POST
    public void ajouter(Client e) {
        this.clientService.ajouter(e);
    }

    @PUT
    public void modifier(Client e) {
        this.clientService.modifier(e);
    }

    @DELETE
    @Path("{id}")
    public void supprimer(@PathParam("id") Long id) {
        this.clientService.supprimer(id);
    }
}
