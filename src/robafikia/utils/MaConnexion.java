/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package robafikia.utils;

/**
 *
 * @author Mariem
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class MaConnexion {
    private final String url = "jdbc:mysql://localhost:3306/robafikia";
    private final String login = "root";
    private final String pwd = "";

    private Connection cnx;

    private static MaConnexion instance;

    private MaConnexion(){
        try {
            cnx = DriverManager.getConnection(url, login, pwd);
            System.out.println("Connexion etablie !");
        } catch (SQLException e) {
            System.err.println("Erreur de connexion !");
            System.out.println(e.getMessage());
        }
    }

    public static MaConnexion getInstance(){
        if (instance == null) instance = new MaConnexion();
        return instance;
    }

    public Connection getCnx() {
        return cnx;
    }
}
