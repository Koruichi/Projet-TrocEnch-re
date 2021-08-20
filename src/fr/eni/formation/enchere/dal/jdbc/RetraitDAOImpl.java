package fr.eni.formation.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import fr.eni.formation.enchere.bo.ArticleVendu;
import fr.eni.formation.enchere.bo.Retrait;
import fr.eni.formation.enchere.dal.DALException;
import fr.eni.formation.enchere.dal.RetraitDAO;

public class RetraitDAOImpl implements RetraitDAO{
	
	private final String INSERT= "INSERT INTO retraits (rue, code_postal, ville) VALUES(?,?,?)";
	private final String DELETE= "DELETE FROM retraits WHERE no_article =?";
	private final String UPDATE = "UPDATE retraits SET rue=?, code_postal=?, ville=? WHERE retraits=?";
	private final String SELECTALL= "SELECT retraits, no_article, rue, code_postal, ville from retraits";

	@Override
	public void insert(Retrait retrait, ArticleVendu articleVendu) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(INSERT);
			stmt.setInt(1, articleVendu.getNo_article());
			stmt.setString(2, retrait.getRue());
			stmt.setString(3, retrait.getCode_postal());
			stmt.setString(4, retrait.getVille());
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL");
		}		

	@Override
	public void delete(Retrait retrait, ArticleVendu articleVendu) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(DELETE);
			stmt.setInt(1, articleVendu.getNo_article());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL");
		}
	}

	@Override
	public void update(Retrait retrait, ArticleVendu articleVendu) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setInt(1, articleVendu.getNo_article());
			stmt.setString(2, retrait.getNom_article());
			stmt.setString(3, articleVendu.getDescription());
			stmt.setDate(4, java.sql.Date.valueOf(articleVendu.getDate_debut_enchere()));
			stmt.setDate(5, java.sql.Date.valueOf(articleVendu.getDate_fin_enchere()));
			stmt.setInt(6, articleVendu.getPrix_initial());
			stmt.setInt(7, articleVendu.getPrix_vente());
			stmt.setInt(8, u.getNo_utilisateur());
			stmt.setInt(9, articleVendu.getCategorie().getNo_categorie());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL");
		}
	}

	@Override
	public List<Retrait> getall() throws DALException {
		return null;
	}

	

}
