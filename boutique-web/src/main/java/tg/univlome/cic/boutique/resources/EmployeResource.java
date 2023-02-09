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
import tg.univlome.cic.boutique.entities.Employe;
import java.util.List;
import javax.ws.rs.PathParam;
import tg.univlome.cic.boutique.service.EmployeService;

/**
 *
 * @author boris
 */
@Path("employe")
public class EmployeResource {

    private EmployeService employeService;

    public EmployeResource() {
        this.employeService = EmployeService.getinstance();
    }

    @GET
    public List<Employe> lister() {
        return this.employeService.lister();
    }

    @GET
    @Path("{id}")
    public Employe trouver(@PathParam("id") Long id) {
        return this.employeService.trouver(id);
    }

    @GET
    @Path("total")
    public int compter() {
        return this.employeService.compter();
    }

    @POST
    public void ajouter(Employe e) {
        this.employeService.ajouter(e);
    }

    @PUT
    public void modifier(Employe e) {
        this.employeService.modifier(e);
    }

    @DELETE
    @Path("{id}")
    public void supprimer(@PathParam("id") Long id) {
        this.employeService.supprimer(id);
    }
}
