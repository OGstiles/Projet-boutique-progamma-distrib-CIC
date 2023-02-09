/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.boutique.entities;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author boris
 */
public class Client extends Personne {

    private String cin;
    private String carteVisa;

    public Client() {
        super();
    }

    public Client(String nom, String prenoms, LocalDate dateNaissance, String cin, String carteVisa) {
        super(nom, prenoms, dateNaissance);
        this.cin = cin;
        this.carteVisa = carteVisa;
    }

    public Client(Long id, String nom, String prenoms, LocalDate dateNaissance, String cin, String carteVisa) {
        super(id, nom, prenoms, dateNaissance);
        this.cin = cin;
        this.carteVisa = carteVisa;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getCarteVisa() {
        return carteVisa;
    }

    public void setCarteVisa(String carteVisa) {
        this.carteVisa = carteVisa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.cin);
        hash = 97 * hash + Objects.hashCode(this.carteVisa);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Client other = (Client) obj;
        if (!Objects.equals(this.cin, other.cin)) {
            return false;
        }
        return Objects.equals(this.carteVisa, other.carteVisa);
    }
    
    

    @Override
    public String toString() {
        return "Client{" + "id=" + id + ", nom=" + nom + ", prenoms=" + prenoms + ", dateNaissance=" + dateNaissance + ", cin=" + cin + ", carteVisa=" + carteVisa + '}';
    }
}
