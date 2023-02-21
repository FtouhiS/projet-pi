/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.produit.entites;
import java.util.Objects;

import org.apache.commons.validator.routines.EmailValidator;
/**
 *
 * @author abder
 */
public class ListDemande {
      private int id_demande;
    private String nom_d;
    private String prenom_d;
    private String email_d;

    // Constructeur sans paramètre
    public ListDemande() {}
    
    // Constructeur sans l'attribut id_demande
    public ListDemande(String nom_d, String prenom_d, String email_d) {
        this.nom_d = nom_d;
        this.prenom_d = prenom_d;
        this.email_d = email_d;
    }
    
    // Constructeur avec tous les attributs
    public ListDemande(int id_demande, String nom_d, String prenom_d, String email_d) {
        this.id_demande = id_demande;
        this.nom_d = nom_d;
        this.prenom_d = prenom_d;
        this.email_d = email_d;
    }
    
    // Setters et Getters
    public int getId_demande() {
        return id_demande;
    }
    
    public void setId_demande(int id_demande) {
        this.id_demande = id_demande;
    }
    
    public String getNom_d() {
        return nom_d;
    }
    
    public void setNom_d(String nom_d) {
        this.nom_d = nom_d;
    }
    
    public String getPrenom_d() {
        return prenom_d;
    }
    
    public void setPrenom_d(String prenom_d) {
        this.prenom_d = prenom_d;
    }
    
    public String getEmail_d() {
        //return email_d;
        if (isEmailValid(this.email_d)) {
        return this.email_d;
    } else {
        throw new IllegalArgumentException("L'adresse e-mail n'est pas valide");
    }
    }
    public boolean isEmailValid(String email) {

    String regex = "^[\\w\\.-]+@[\\w\\-]+(\\.[\\w]+)*$";
    return email.matches(regex);
}
    public void setEmail_d(String email_d) {
if (isEmailValid(email_d)) {
this.email_d = email_d;
} else {
throw new IllegalArgumentException("L'adresse e-mail n'est pas valide");
}
}
   /* public void setEmail_d(String email_d) {
        this.email_d = email_d;
    }*/
    
    // Méthode toString()
    @Override
    public String toString() {
        return "ListDemande [id_demande=" + id_demande + ", nom_d=" + nom_d + ", prenom_d=" + prenom_d + ", email_d=" + email_d + "]";
    }
    
    // Méthode equals() et hashcode()
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
        ListDemande other = (ListDemande) obj;
        if (id_demande != other.id_demande) {
            return false;
        }
        if (email_d == null) {
            if (other.email_d != null) {
                return false;
            }
        } else if (!email_d.equals(other.email_d)) {
            return false;
        }
        if (nom_d == null) {
            if (other.nom_d != null) {
                return false;
            }
        } else if (!nom_d.equals(other.nom_d)) {
            return false;
        }
        if (prenom_d == null) {
            if (other.prenom_d != null) {
                return false;
            }
        } else if (!prenom_d.equals(other.prenom_d)) {
            return false;
        }
        return true;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id_demande;
        result = prime * result + ((email_d == null) ? 0 : email_d.hashCode());
        result = prime * result + ((nom_d == null) ? 0 : nom_d.hashCode());
        return result ;
    }
    
}
