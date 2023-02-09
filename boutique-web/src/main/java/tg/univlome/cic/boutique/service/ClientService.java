/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.boutique.service;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import tg.univlome.cic.boutique.entities.Client;

/**
 *
 * @author boris
 */
public class ClientService {

    private static ClientService instance;
    private static List<Client> liste;

    public ClientService() {
        liste = new ArrayList<Client>();

        liste.add(new Client(1l, "KOKOU", "K. Kodjo", LocalDate.of(1998, 4, 3), "1234-456-7156", "1234 4565 4846 1354"));
        liste.add(new Client(2l, "TOTO", "C. Tata", LocalDate.of(1999, 1, 21), "7651-986-3548", "5468 8645 6513 8465"));
        liste.add(new Client(3l, "AMA", "A. Kwatcha", LocalDate.of(2000, 7, 10), "5636-835-2316", "1359 8945 5688 5123"));
    }

    public static synchronized ClientService getinstance() {
        if (instance == null) {
            instance = new ClientService();
        }

        return instance;
    }

    public List<Client> lister() {
        return liste;
    }

    public Client trouver(Long id) {
        for (Client e : liste) {
            if (Objects.equals(e.getId(), id)) {
                return e;
            }
        }
        return null;
    }

    public int compter() {
        return liste.size();
    }

    public void ajouter(Client e) {
        liste.add(e);
    }

    public void modifier(Client e) {
        if (liste.contains(e)) {
            liste.set(liste.indexOf(e), e);
        }
    }

    public void supprimer(Long id) {
        liste.remove(id.intValue());
    }
}
