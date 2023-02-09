/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.boutique.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import tg.univlome.cic.boutique.entities.Achat;
import java.util.Objects;
import tg.univlome.cic.boutique.entities.ProduitAchete;

/**
 *
 * @author boris
 */
public class AchatService {

    private static AchatService instance;
    private static List<Achat> liste;

    private EmployeService employeService;
    private ClientService clientService;

    public AchatService() {
        liste = new ArrayList<>();
        employeService = EmployeService.getinstance();
        clientService = ClientService.getinstance();

        liste.add(new Achat(1l, LocalDateTime.of(2020, 1, 1, 11, 50, 0), 500, employeService.trouver(1l), clientService.trouver(1l), new ArrayList<ProduitAchete>()));
        liste.add(new Achat(2l, LocalDateTime.of(2020, 5, 27, 16, 5, 40), 1500, employeService.trouver(2l), clientService.trouver(3l), new ArrayList<ProduitAchete>()));
    }

    public static synchronized AchatService getinstance() {
        if (instance == null) {
            instance = new AchatService();
        }

        return instance;
    }

    public List<Achat> lister() {
        return liste;
    }

    public Achat trouver(Long id) {
        for (Achat e : liste) {
            if (Objects.equals(e.getId(), id)) {
                return e;
            }
        }
        return null;
    }

    public int compter() {
        return liste.size();
    }

    public void ajouter(Achat e) {
        if (e != null) {
            liste.add(e);
        }
    }

    public void modifier(Achat e) {
        if (liste.contains(e)) {
            liste.set(liste.indexOf(e), e);
        }
    }

    public void supprimer(Long id) {
        liste.remove(id.intValue());
    }
}
