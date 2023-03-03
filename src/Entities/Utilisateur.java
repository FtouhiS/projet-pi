/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.Objects;

/**
 *
 * @author moham
 */
public class Utilisateur {
    private int IdUser;
    private String Nom;
    private String Prenom;
    private String Adresse_mail;

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 47 * hash + Objects.hashCode(this.Adresse_mail);
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
        final Utilisateur other = (Utilisateur) obj;
        if (!Objects.equals(this.Adresse_mail, other.Adresse_mail)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "Nom=" + Nom + ", Prenom=" + Prenom + ", Adresse_mail=" + Adresse_mail + '}';
    }
    public Utilisateur() {
      
    }
 public Utilisateur(int id,String Nom, String Prenom, String Adresse_mail) {
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Adresse_mail = Adresse_mail;
        this.IdUser=id;
    }
    public Utilisateur(String Nom, String Prenom, String Adresse_mail) {
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Adresse_mail = Adresse_mail;
    }

    public void setIdUser(int IdUser) {
        this.IdUser = IdUser;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public void setAdresse_mail(String Adresse_mail) {
        this.Adresse_mail = Adresse_mail;
    }

    public int getIdUser() {
        return IdUser;
    }

    public String getNom() {
        return Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public String getAdresse_mail() {
        return Adresse_mail;
    }
}
