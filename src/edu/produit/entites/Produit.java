/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.produit.entites;

import java.util.Objects;

/**
 *
 * @author USER
 */
public class Produit {
    int id_produit;

    public Produit(int id_produit, String nom_produit, String etat , String description) {
        this.id_produit = id_produit;
        this.nom_produit = nom_produit;
        this.etat = etat;
        this.description = description;
    }
    String nom_produit;
    String etat;
    String description;

    @Override
    public String toString() {
        return "Produit{" + "id_produit=" + id_produit + ", nom_produit=" + nom_produit + ", etat=" + etat + ", description=" + description +  '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + this.id_produit;
        hash = 47 * hash + Objects.hashCode(this.nom_produit);
        hash = 47 * hash + Objects.hashCode(this.description);
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
        final Produit other = (Produit) obj;
        if (this.id_produit != other.id_produit) {
            return false;
        }
        if (!Objects.equals(this.etat, other.etat)) {
            return false;
        }
        
        if (!Objects.equals(this.nom_produit, other.nom_produit)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        return true;
    }

    public Produit(String nom_produit, String etat, String description) {
        this.nom_produit = nom_produit;
        this.etat = etat;
        this.description = description;
       
    }

    public int getId_produit() {
        return id_produit;
    }

    public void setId_produit(int id_produit) {
        this.id_produit = id_produit;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    
}