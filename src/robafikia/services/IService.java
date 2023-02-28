/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package robafikia.services;

/**
 *
 * @author Mariem
 */
import java.sql.SQLException;
import java.util.List;
import robafikia.entities.Commande;
public interface IService<T> {
    
    void createOne(T t) throws SQLException;
    void updateOne(T t) throws SQLException;
   // void deletOne(T t) throws SQLException;
     void supprimerOne(int id);
    List<T> selectAll() throws SQLException;
}
