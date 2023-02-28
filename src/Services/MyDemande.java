/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Services;

import Utils.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import Entities.Demande;
import Entities.Service;
import Entities.Service.Categorie;
import Entities.Demande;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author moham
 */
public class MyDemande {

    private static String USER_NAME = "roubafikaservice";  // GMail user name (just the part before "@gmail.com")
    private static String PASSWORD = "pbmtdethvxelgsdl"; // GMail password
    private static String RECIPIENT = "mohamedbahaeddine.brinsi@esprit.tn";

    private PreparedStatement pst;
    private Statement ste;
    private Connection connection;
    private ResultSet rs;

    public MyDemande() {
        connection = DataSource.getInstance().getConnection();
    }

    public ObservableList<Demande> afficherDemande() {
        ObservableList<Demande> listeDemande = FXCollections.observableArrayList();
        String requete = "SELECT nom_demandeur,prenom_demandeur,email_demandeur,date_demande,titre FROM demande join service on demande.id_serv= service.id_service";
        Statement st;
        ResultSet rs;
        try {

            ste = connection.createStatement();
            rs = ste.executeQuery(requete);
            while (rs.next()) {
                Demande demande = new Demande();
                demande.setNom_demandeur(rs.getString("nom_demandeur"));
                demande.setPrenom_demandeur(rs.getString("prenom_demandeur"));
                demande.setEmail_demandeur(rs.getString("email_demandeur"));
                demande.setDate_demande(rs.getString("date_demande"));
                demande.setTitreService(rs.getString("titre"));
                listeDemande.add(demande);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyDemande.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listeDemande;

    }
    public Service getServiceByID(int id) {
        String requete = "SELECT * FROM service where id_service="+id;
        Statement st;
        ResultSet rs;
        Service s =new Service();
        try {

            ste = connection.createStatement();
            rs = ste.executeQuery(requete);
            while (rs.next()) {
                
                String categorieStr = rs.getString("categorie");
                Categorie categorie = Categorie.valueOf(categorieStr);
                 s =new Service(rs.getString("titre"), rs.getString("description"), rs.getString("date_annonce"), rs.getString("adresse"), categorie);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyDemande.class.getName()).log(Level.SEVERE, null, ex);
        }
        return s;

    }

    public void ajouterDemande(Demande d) throws SQLException {
        String requete = "INSERT INTO demande (nom_demandeur, prenom_demandeur, email_demandeur, date_demande, id_serv) VALUES (?,?,?,?,?)";
        try {
            connection = DataSource.getInstance().getConnection();
            pst = connection.prepareStatement(requete);
            pst.setString(1, d.getNom_demandeur());
            pst.setString(2, d.getPrenom_demandeur());
            pst.setString(3, d.getEmail_demandeur());
            pst.setString(4, d.getDate_demande());
            pst.setInt(5, d.getId_serv());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(MyDemande.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean deleteDemande(String id) {
        String requete = "DELETE FROM demande WHERE nom_demandeur= '" + id + "'";
        try {
            ste = connection.createStatement();
            int rowsDeleted = ste.executeUpdate(requete);
            if (rowsDeleted > 0) {
                System.out.println("Service was successfully deleted");
                return true;
            } else {
                System.out.println("Failed to delete the service");
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyService.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Failed to delete the service");
            return false;
        }
    }

    public void modifierDemande(Demande d, String id) {
        String requete = "UPDATE demande SET nom_demandeur = '" + d.getNom_demandeur() + "', prenom_demandeur = '" + d.getPrenom_demandeur() + "', date_demande = '" + d.getDate_demande() + "', id_serv = '" + d.getId_serv() + "' WHERE nom_demandeur = '" + id + "'";
        try {
            ste = connection.createStatement();
            ste.executeUpdate(requete);
        } catch (SQLException ex) {
            Logger.getLogger(MyDemande.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void sendEmailNotif(String recipient, Service s) {
        String from = USER_NAME;
        String pass = PASSWORD;
        String[] to = {RECIPIENT}; // list of recipient email addresses
        String subject = "Votre demande a ete bien effectuée";
        String body = "Vous avez demandé le service  <b>"+s.getTitre()+ "</b> <br/>"+s.getDescription();
        sendFromGMail(from, pass, to, subject, body);
    }

    private static void sendFromGMail(String from, String pass, String[] to, String subject, String body) {
        Properties props = System.getProperties();
        String host = "smtp.gmail.com";
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.user", from);
        props.put("mail.smtp.password", pass);
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);
        MimeMessage message = new MimeMessage(session);

        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] toAddress = new InternetAddress[to.length];

            // To get the array of addresses
            for (int i = 0; i < to.length; i++) {
                toAddress[i] = new InternetAddress(to[i]);
            }

            for (int i = 0; i < toAddress.length; i++) {
                message.addRecipient(Message.RecipientType.TO, toAddress[i]);
            }

            message.setSubject(subject);
            message.setText(body);
            Transport transport = session.getTransport("smtp");
            transport.connect(host, from, pass);
            transport.sendMessage(message, message.getAllRecipients());
            transport.close();
        } catch (AddressException ae) {
            ae.printStackTrace();
        } catch (MessagingException me) {
            me.printStackTrace();
        }
    }

}
