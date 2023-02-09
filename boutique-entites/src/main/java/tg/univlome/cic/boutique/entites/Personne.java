/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tg.univlome.cic.boutique.entites;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 *
 * @author Rasac
 */
public class Personne {

    protected Long id;
    protected String nom;
    protected String prenoms;
    protected LocalDate dateNaissance;

    public Personne() {

    }

    public Personne(String nom, String prenoms, LocalDate dateNaissance) {
        this.nom = nom;
        this.prenoms = prenoms;
        this.dateNaissance = dateNaissance;
    }

    public Personne(Long id, String nom, String prenoms, LocalDate dateNaissance) {
        this.id = id;
        this.nom = nom;
        this.prenoms = prenoms;
        this.dateNaissance = dateNaissance;
    }

    public int getAge() {
        return getAge(LocalDate.now());
    }

    public int getAge(LocalDate dateReference) {
        Period period = Period.between(this.dateNaissance, dateReference);

        return period.getYears();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
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
        final Personne other = (Personne) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Personne{" + "id=" + id + ", nom=" + nom + ", prenoms=" + prenoms + ", dateNaissance=" + dateNaissance + '}';
    }
}
