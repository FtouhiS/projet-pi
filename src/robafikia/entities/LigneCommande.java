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
public class LigneCommande {
    private int idcom ;
    private float prix;
    
    public LigneCommande(){} ;
    public LigneCommande( float prix)
    { 
        this.prix =prix ;
    }
    public LigneCommande(int id , float prix)
    {
        this.idcom=id ;
        this.prix=prix ;
    }
    
    public int getIdCom() {
        return idcom ;
    }
    
    public float getPrix(){
if (prix <= 0) {
        throw new IllegalStateException("Le prix doit être supérieur à 0.");
    }
    return prix;
    }
    
    public void setIdCom(int id) {
        this.idcom = id;
    }
    
    public void setPrix(float prix)
    {
 if (prix <= 0) {
        throw new IllegalArgumentException("Le prix doit être supérieur à 0.");
    }
    this.prix = prix;    }
    
    
    @Override 
       public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LigneCommande)) {
            return false;
        }
        LigneCommande other = (LigneCommande) obj;
        return this.idcom == other.idcom && Float.compare(this.prix, other.prix) == 0;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 19 * hash + this.idcom;
        hash = 19 * hash + Float.floatToIntBits(this.prix);
        return hash;
    }
    
     @Override
    public String toString() {
        return "LigneCommande [id=" + idcom + ", prix=" + prix + "]";
    }

}