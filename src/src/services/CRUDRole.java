/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;
import entities.Role;
import Iservices.IRole;
import utiles.MaConnexion;
import entities.Role;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author marie
 */
public class CRUDRole implements IRole{
Statement ste;
Connection conn = MaConnexion.getInstance().getCnx();
        

    public void ajouterRole(Role R) {
    try {
        ste = conn.createStatement();
        String req = "Insert into role values(0,'"+R.getrole()+"')";
        ste.executeUpdate(req);
        System.out.println("role ajouté");
    } catch (SQLException ex) {
            System.out.println("role non ajoute!!!!");    }
    }

     
    public void modifierRole(Role R) {
        try {
            String req = "UPDATE `role` SET `roleU` = '" + R.getrole();
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("role updated !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    public void supprimerRole (String roleU) {
        try {
            String req = "DELETE FROM `role` WHERE roleU = " + roleU;
            Statement st = conn.createStatement();
            st.executeUpdate(req);
            System.out.println("role deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Role> afficherRole() {
       List<Role> list = new ArrayList<>();
        try {
            String req = "Select * from role";
            Statement st = conn.createStatement();
           
            ResultSet RS= st.executeQuery(req);
            while(RS.next()){
             Role R  = new Role();
             R.setrole(RS.getString(1));
             
             list.add(R);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

        return list;
    }

    public void ajouterRole2(Role R) {
        try {
            String req = "INSERT INTO `roleU` (`roleU`) VALUES (?)";
            PreparedStatement ps = conn.prepareStatement(req);
            ps.setString(1, R.getrole());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

   
  
}
 


