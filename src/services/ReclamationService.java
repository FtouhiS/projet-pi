package services;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import entites.Reclamation;
import utiles.MaConnexion;

public class ReclamationService implements IService<Reclamation> {

	private Connection cnx;

	public ReclamationService(){
		cnx = MaConnexion.getInstance().getCnx();
	}

	@Override
	public void createOne(Reclamation reclamation) throws SQLException {
		// Check that date_ajout is a valid date
		if (reclamation.getDate_ajout() == null) {
			throw new IllegalArgumentException("Date ajout must not be null");
		}

		// Check that sujet is not empty
		if (reclamation.getSujet().isEmpty()) {
			throw new IllegalArgumentException("Sujet must not be empty");
		}

		// Check that description is not empty
		if (reclamation.getDescription().isEmpty()) {
			throw new IllegalArgumentException("Description must not be empty");
		}

		// Build the SQL query string
		String req = "INSERT INTO `reclamation`( `Date_ajout`, `Sujet`, `Description`)" +
				" VALUES ('"+reclamation.getDate_ajout()+"','"+reclamation.getSujet()+"','"+reclamation.getDescription()+"')";
		// System.out.println(req);

		// Execute the SQL query
		Statement st = cnx.createStatement();
		st.executeUpdate(req);
		System.out.println("Reclamation ajouté !");
	}



	//The (?,?,?) syntax is a placeholder syntax used in a prepared statement to represent values that will be inserted into the database at runtime. Each ? corresponds to a single value that will be set using the set methods on the prepared statement.

	//If you want to insert specific values into the database instead of using placeholders, you can replace the (?,?,?) syntax with a comma-separated list of values wrapped in parentheses

	@Override
	public void updateOne(Reclamation reclamation) throws SQLException {
		String sql = "UPDATE reclamation SET `Date_ajout`=?, `Sujet`=?, `Description`=? WHERE `IdReclamation`=?";
		PreparedStatement pstmt = cnx.prepareStatement(sql);
		pstmt.setDate(1, reclamation.getDate_ajout());
		pstmt.setString(2, reclamation.getSujet());
		pstmt.setString(3, reclamation.getDescription());
		pstmt.setInt(4, reclamation.getIdReclamation());
		int rowsUpdated = pstmt.executeUpdate();
		if (rowsUpdated > 0) {
			System.out.println("Reclamation updated successfully");
		} else {
			System.out.println("Reclamation update failed");
		}
	}


	public void updateOne1(Reclamation reclamation) throws SQLException {
		String sql = "UPDATE reclamation SET `Date_ajout`='" + reclamation.getDate_ajout() + "', `Sujet`='" + reclamation.getSujet() + "', `Description`='" + reclamation.getDescription() + "' WHERE `IdReclamation`=" + reclamation.getIdReclamation();
		PreparedStatement pstmt = cnx.prepareStatement(sql);
		pstmt.executeUpdate();
		System.out.println("Reclamation mise à jour !");
	}





	@Override
	public void deletOne(Reclamation r) throws SQLException {

		String req = "DELETE FROM reclamation WHERE IDreclamation = ?";
		PreparedStatement st = cnx.prepareStatement(req);
		st.setInt(1, r.getIdReclamation());
		st.executeUpdate();
		System.out.println("reclamation Supprimee !");


	}


	public List<Reclamation> afficherReclamation() {
		List<Reclamation> list = new ArrayList<>();
		try {
			String req = "Select * from reclamation";
			Statement st = cnx.createStatement();

			ResultSet RS= st.executeQuery(req);
			while(RS.next()){
				Reclamation r  = new Reclamation();
				r.setIdReclamation(RS.getInt(1));
				r.setDate_ajout(RS.getDate(2));
				r.setSujet(RS.getString(3));
				r.setDescription(RS.getString(4));
				list.add(r);
			}
		} catch (SQLException ex) {
			System.out.println(ex.getMessage());
		}

		return list;
	}

	@Override
	public List<Reclamation> selectAll() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}


}
