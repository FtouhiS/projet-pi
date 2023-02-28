/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package robafikia.services;
import robafikia.entities.LigneCommande;
 import robafikia.utils.MaConnexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import static jdk.nashorn.internal.runtime.Debug.id;
 /*
 * @author Mariem
 */
public class ServiceLigneCommande implements IService<LigneCommande> {
private final Connection cnx;
    private Object sp;

    public ServiceLigneCommande(){
        cnx = MaConnexion.getInstance().getCnx();
    }
    @Override
    public void createOne(LigneCommande t) throws SQLException {
   String req =   "INSERT INTO `ligne_commande`( `prix`)" + " VALUES ("+t.getPrix()+")";
       
        
       Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("ligne de commande ajouté !");     }

    @Override
    public void updateOne(LigneCommande t) throws SQLException {
 String req =  " UPDATE `ligne_commande` SET prix=? WHERE Id_ligne=" + t.getIdCom();
     
            PreparedStatement st = cnx.prepareStatement(req);

            st.setFloat(1, t.getPrix());
           
            st.executeUpdate();  
    }
/*
    @Override
    public void deletOne(LigneCommande t) throws SQLException {
 try {
            String req = "DELETE FROM `ligne_commande` WHERE Id_ligne =" + t.getIdCom();
            PreparedStatement ste = cnx.prepareStatement(req);
            //ste.setInt(1, t.getIdCom());
            ste.executeUpdate();
            System.out.println("ligne de commande supprimé");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceLigneCommande.class.getName()).log(Level.SEVERE, null, ex);
        }  */ 
@Override
       public void supprimerOne(int id){

try {
            String req = "DELETE FROM `ligne_commande` WHERE Id_ligne = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("ligne de commande deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    
    }

    @Override
    public List<LigneCommande> selectAll() throws SQLException {
        List<LigneCommande> temp = new ArrayList<>();
        String req = "SELECT * FROM `ligne_commande`";
        PreparedStatement ps = cnx.prepareStatement(req);
 
        ResultSet rs = ps.executeQuery();

        while (rs.next()){

            LigneCommande com = new LigneCommande();

           com.setPrix(rs.getFloat("prix"));
           
          
          temp.add(com);

        }
    
        return temp ;   
    }
    
}
