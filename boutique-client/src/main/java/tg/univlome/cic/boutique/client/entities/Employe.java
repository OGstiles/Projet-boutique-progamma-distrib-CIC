/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.boutique.client.entities;

import java.time.LocalDate;

/**
 *
 * @author Rasac
 */
public class Employe extends Personne {

    private String cnss;

    public Employe() {
        super();
    }

    public Employe(String nom, String prenoms, LocalDate dateNaissance, String cnss) {
        super(nom, prenoms, dateNaissance);
        this.cnss = cnss;
    }

    public Employe(Long id, String nom, String prenoms, LocalDate dateNaissance, String cnss) {
        super(id, nom, prenoms, dateNaissance);
        this.cnss = cnss;
    }

    public String getCnss() {
        return cnss;
    }

    public void setCnss(String cnss) {
        this.cnss = cnss;
    }

    @Override
    public String toString() {
        return "Employe{" + "id=" + id + ", nom=" + nom + ", prenoms=" + prenoms + ", dateNaissance=" + dateNaissance + ", cnss=" + cnss + '}';
    }
}
