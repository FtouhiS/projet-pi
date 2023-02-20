package test;

import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;

import entites.Reclamation;
import services.ReclamationService;
import services.ReponseService;
import utiles.MaConnexion;

import entites.Reponse;
import services.ReponseService;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LocalDate localDate = LocalDate.now();
		MaConnexion connexion = MaConnexion.getInstance();
		
		Reclamation r2= new Reclamation (0,Date.valueOf(localDate), "sujet","Description");
		Reclamation r3= new Reclamation (0,Date.valueOf(localDate), "Reclamation technique","DEscription1");
		Reclamation r4= new Reclamation (0,Date.valueOf(localDate), "sujet","DEscription");
		Reclamation r5= new Reclamation (8,Date.valueOf(localDate), "Ahmed","iheb");
		
		
		ReclamationService rc= new ReclamationService();	
	    Reponse reponse1 =new Reponse ("DESCRIPTION");
	    ReponseService rs =new ReponseService();
	    
	   
	    
	
		  try {
			rc.updateOne(r5);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		/*try {
			rc.updateOne(r1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		 // System.out.println(rc.afficherReclamation());
		
	 /*
		try {
			rc.updateOne1(r1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
	}

}
