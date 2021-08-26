package fr.eni.formation.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import fr.eni.formation.enchere.bll.BLLException;
import fr.eni.formation.enchere.bo.ArticleVendu;
import fr.eni.formation.enchere.bo.Enchere;
import fr.eni.formation.enchere.bo.Utilisateur;
import fr.eni.formation.enchere.dal.DALException;
import fr.eni.formation.enchere.dal.IEnchere;

public class EnchereDAOImpl implements IEnchere {
	
	private final String INSERT = "INSERT INTO encheres (no_utilisateur, no_article, date_enchere, montant_enchere) VALUES(?,?,?,?)";
	private final String UPDATE = "UPDATE encheres SET  date_enchere=?,montant_enchere = ?  WHERE no_utilisateur = ? AND no_article=?  ";
	private final String DELETE = "DELETE FROM encheres where  no_utilisateur = ? AND no_article=?";


	@Override
	public void addEnchere(Enchere enchere, ArticleVendu a, Utilisateur u) throws BLLException, DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, u.getNo_utilisateur());
			stmt.setInt(2, a.getNo_article());
			stmt.setTimestamp(3, java.sql.Timestamp.valueOf(enchere.getDate_enchere()));
			stmt.setInt(4, enchere.getMontant_enchere());
			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Probl�me SQL");
		}

	}

	@Override
	public void deleteEnchere(Enchere enchere, ArticleVendu a, Utilisateur u) throws BLLException, DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(DELETE);
			stmt.setInt(1, u.getNo_utilisateur());
			stmt.setInt(2, a.getNo_article());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Probl�me SQL");
		}

	}

	@Override
	public void updateEnchere(Enchere enchere, ArticleVendu a, Utilisateur u) throws BLLException, DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setInt(1, u.getNo_utilisateur());
			stmt.setInt(2, a.getNo_article());
			stmt.setTimestamp(3, java.sql.Timestamp.valueOf(enchere.getDate_enchere()));
			stmt.setInt(4, enchere.getMontant_enchere());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Probl�me SQL");
		}

	}


}
