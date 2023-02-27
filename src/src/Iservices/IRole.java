/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Iservices;
import entities.Role;
import java.util.List;
/**
 *
 * @author Soulaima
 */
public interface IRole {
  
     public void ajouterRole(Role R);
    public void ajouterRole2 (Role R);
    public void modifierRole(Role R);
    public void supprimerRole(String role);
    public List<Role> afficherRole ();  
}
