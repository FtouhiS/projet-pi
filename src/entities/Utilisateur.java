/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entities;
import java.util.Objects;
/**
 *
 * @author Soulaima
 */
public class Utilisateur {
    private int IdUser;
    private String Nom;
    private String Prenom;
    private String Adresse_mail;
    private int CIN;
    private String Adresse;
    private int Numero_telephone;
    private String roleU;
   
   public Utilisateur() { }

    public Utilisateur( String Nom, String Prenom, String Adresse_mail, int CIN, String Adresse, int Numero_telephone,String roleU) {
      
        this.Nom = Nom;
        this.Prenom = Prenom;
        this.Adresse_mail = Adresse_mail;
        this.CIN = CIN;
        this.Adresse = Adresse;
        this.Numero_telephone = Numero_telephone;
        this.roleU=roleU;
        
    }

    public Utilisateur(int i, String mariem, String ftouhi, String maemailcom, int i0, String tunis, int i1, String user) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getIdUser() {
        return IdUser;
    }

    public void setIdUser(int IdUser) {
        this.IdUser = IdUser;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String Nom) {
        this.Nom = Nom;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String Prenom) {
        this.Prenom = Prenom;
    }

    public String getAdresse_mail() {
        return Adresse_mail;
    }

    public void setAdresse_mail(String Adresse_mail) {
        this.Adresse_mail = Adresse_mail;
    }

    public int getCIN() {
        return CIN;
    }

    public void setCIN(int CIN) {
        this.CIN = CIN;
    }

    public String getAdresse() {
        return Adresse;
    }

    public void setAdresse(String Adresse) {
        this.Adresse = Adresse;
    }

    public int getNumero_telephone() {
        return Numero_telephone;
    }

    public void setNumero_telephone(int Numero_telephone) {
        this.Numero_telephone = Numero_telephone;
        
    }

    public String getRole() {
        return roleU;
    }

    public void setRole(String roleU) {
        this.roleU = roleU;
    }

    @Override
    public String toString() {
        return "Utilisateur{" + "IdUser=" + IdUser + ", Nom=" + Nom + ", Prenom=" + Prenom + ", Adresse_mail=" + Adresse_mail + ", CIN=" + CIN + ", Adresse=" + Adresse + ", Numero_telephone=" + Numero_telephone + ", roleU=" + roleU + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        if (this.IdUser != other.IdUser) {
            return false;
        }
        if (this.CIN != other.CIN) {
            return false;
        }
        if (this.Numero_telephone != other.Numero_telephone) {
            return false;
        }
        if (!Objects.equals(this.Nom, other.Nom)) {
            return false;
        }
        if (!Objects.equals(this.Prenom, other.Prenom)) {
            return false;
        }
        if (!Objects.equals(this.Adresse_mail, other.Adresse_mail)) {
            return false;
        }
        if (!Objects.equals(this.Adresse, other.Adresse)) {
            return false;
        }
        return Objects.equals(this.roleU, other.roleU);
    }

    
    
    
}
