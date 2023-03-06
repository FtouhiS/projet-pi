/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.produit.services;

import java.util.List;
import edu.produit.model.Produit;
import edu.produit.model.Demande;


/**
 *
 * @author achra
 */
public interface ModifierInterface {
    public List<Produit> SearchByName(String name);
        public void sendMail(Demande client ,String mail) throws Exception;

    
}
