
package robafikia.services;
import robafikia.entities.Commande;
import robafikia.utils.MaConnexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.SQLException;
import static jdk.nashorn.internal.runtime.Debug.id;
/**
 *
 * @author Mariem
 */
public class ServiceCommande implements IService<Commande> {
    private final Connection cnx;
    private Object sp;

    public ServiceCommande(){
        cnx = MaConnexion.getInstance().getCnx();
    }

    @Override
    public void createOne(Commande t) throws SQLException {
    String req =   "INSERT INTO `commande`( `lieu`, `adresse`, `numero_tel`)" + " VALUES ('"+t.getLieu()+"', '"+t.getAdresse()+"',"+t.getNumero_tel()+")";
       
        
       Statement st = cnx.createStatement();
        st.executeUpdate(req);
        System.out.println("commande ajouté !"); 
    }

    @Override
    public void updateOne(Commande t) throws SQLException {
    String req =  " UPDATE `commande` SET lieu=?,adresse=?,numero_tel=? WHERE IdCommande=" + t.getId();
     
            PreparedStatement st = cnx.prepareStatement(req);

            st.setString(1, t.getLieu());
            st.setString(2, t.getAdresse());
            st.setString(2, t.getNumero_tel());
            st.executeUpdate();

    }
/*
    @Override
    public void deletOne(Commande t) throws SQLException {
        try {
            String req = "DELETE FROM `commande` WHERE commande.`IdCommande` = ?";
            PreparedStatement ste = cnx.prepareStatement(req);
            ste.setInt(1, t.getId());
            ste.executeUpdate();
            System.out.println("commande supprimé");

        } catch (SQLException ex) {
            Logger.getLogger(ServiceCommande.class.getName()).log(Level.SEVERE, null, ex);
        }  
    }
*/
        @Override
     public void supprimerOne(int id){
     
        try {
            String req = "DELETE FROM `commande` WHERE IdCommande = " + id;
            Statement st = cnx.createStatement();
            st.executeUpdate(req);
            System.out.println("commande deleted !");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
     
     
     }

    @Override
    public List<Commande> selectAll() throws SQLException {
    List<Commande> temp = new ArrayList<>();

        String req = "SELECT * FROM `commande`";
        PreparedStatement ps = cnx.prepareStatement(req);

        ResultSet rs = ps.executeQuery();

        while (rs.next()){

            Commande com = new Commande();
            

           com.setId(rs.getInt("idCommande"));
            com.setLieu(rs.getString("lieu"));
           com.setAdresse(rs.getString("adresse"));
           com.setNumero_tel(rs.getString("numero_tel"));
          
          temp.add(com);

        }
    
    return temp ;
}
}