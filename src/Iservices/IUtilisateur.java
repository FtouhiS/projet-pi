/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Iservices;
import entities.Utilisateur;
import java.util.List;
/**
 *
 * @author Soulaima
 */
public interface IUtilisateur {
    public void ajouterUtilisateur(Utilisateur U);
    public void ajouterUtilisateur2 (Utilisateur U);
    public void modifierUtilisateur(Utilisateur U);
    public void supprimerUtilisateur(int id);
    public List<Utilisateur > afficherUtilisateur ();
     
}