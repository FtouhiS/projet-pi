/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.produit.model;

import java.util.Objects;

/**
 *
 * @author achra
 */
public class Demande {
     int id_demande;
    String nom_demande;
    String prenom;
    String email;

    public Demande(String nom_demande, String prenom, String email) {
        this.nom_demande = nom_demande;
        this.prenom = prenom;
        this.email = email;
    }

    public Demande(int id_demande, String nom_demande, String prenom, String email) {
        this.id_demande = id_demande;
        this.nom_demande = nom_demande;
        this.prenom = prenom;
        this.email = email;
    }

    public int getId_demande() {
        return id_demande;
    }

    public void setId_demande(int id_demande) {
        this.id_demande = id_demande;
    }

    public String getNom_demande() {
        return nom_demande;
    }

    public void setNom_demande(String nom_demande) {
        this.nom_demande = nom_demande;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public int hashCode() {
        int hash = 7;
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
        final Demande other = (Demande) obj;
        if (this.id_demande != other.id_demande) {
            return false;
        }
        if (!Objects.equals(this.nom_demande, other.nom_demande)) {
            return false;
        }
        if (!Objects.equals(this.prenom, other.prenom)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Demande{" + "id_demande=" + id_demande + ", nom_demande=" + nom_demande + ", prenom=" + prenom + ", email=" + email + '}';
    }
    
}
