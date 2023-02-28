/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package robafikia.entities;
import java.util.Objects;
/**
 *
 * @author Mariem
 */
public class Commande {
    private int id ;
    private String lieu ;
    private String adresse ;
    private String numero_tel ;
    
    public Commande(){}
    
     public Commande(String lieu ,String adresse , String numero_tel )
    {
      
        this.lieu=lieu ;
        this.adresse=adresse ;
        this.numero_tel=numero_tel ;
    }
     
    public Commande(int id ,String lieu ,String adresse , String numero_tel )
    {
        this.id=id;
        this.lieu=lieu ;
        this.adresse=adresse ;
        this.numero_tel=numero_tel ;
    }
    
    public int getId() {
        return id ;
    }
    
    public String getLieu() {
 if (lieu == null || lieu.trim().isEmpty()) {
        throw new IllegalStateException("Le lieu ne peut pas être vide.");
    }
    return lieu;
    }
    
    public String getAdresse() {
if (adresse == null || adresse.trim().isEmpty()) {
        throw new IllegalStateException("L'adresse ne peut pas être vide.");
    }
    return adresse;
    }
    
    public String getNumero_tel() {
 if (numero_tel == null || numero_tel.trim().isEmpty()) {
        throw new IllegalStateException("Le numéro de téléphone ne peut pas être vide.");
    }
    return numero_tel;    }
    
    public void setId(int id) {
        this.id = id;
    }
    
     public void setLieu(String lieu) {
        this.lieu = lieu;
    } 
     
     public void setAdresse(String adresse) {
        this.adresse = adresse;
    } 
     
     public void setNumero_tel(String numero_tel) {
        this.numero_tel = numero_tel;
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
        final Commande other = (Commande) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.adresse, other.adresse);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + this.id;
        hash = 11 * hash + Objects.hashCode(this.adresse);
        return hash;
    }

    @Override
    public String toString() {
        return "Commande{" +
                "id="+id+'\''+
               "lieu='" + lieu + '\'' +
               ", adresse='" + adresse + '\'' +
               ", numero_tel='" + numero_tel + '\'' +
               '}';
    } 
}
