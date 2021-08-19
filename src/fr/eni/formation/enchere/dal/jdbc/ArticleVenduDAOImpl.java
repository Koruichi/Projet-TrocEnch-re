package fr.eni.formation.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import fr.eni.formation.enchere.bo.ArticleVendu;
import fr.eni.formation.enchere.bo.Utilisateur;
import fr.eni.formation.enchere.dal.ArticleVenduDAO;
import fr.eni.formation.enchere.dal.DALException;

public class ArticleVenduDAOImpl implements ArticleVenduDAO{
	private final String INSERT = "INSERT INTO articles_vendus (no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) VALUES(?,?,?,?,?,?,?,?,?)";
	private final String DELETE = "DELETE FROM articles_vendus where no_article = ?";
	private final String UPDATE = "UPDATE articles_vendus SET no_article=?, nom_article=?, description=?, date_debut_encheres=?, date_fin_encheres=?, prix_initial=?, prix_vente=?, no_utilisateur=?, no_categorie=?, WHERE no_article=?";
	private final String SELECTALL = "SELECT articles_vendus, no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie, FROM articles_vendus";
	private final String SELECTBYID = "SELECT no_article, nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie,  FROM articles_vendus WHERE no_article=?";
	// private final String SELECTBYUTILISATEUR

	public void insert(ArticleVendu articleVendu) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setInt(1, articleVendu.getNo_article());
			stmt.setString(2, articleVendu.getNom_article());
			stmt.setString(3, articleVendu.getDescription());
			stmt.setTime(4, Time.valueOf(articleVendu.getDate_debut_enchere()));
			stmt.setTime(5,Time.valueOf(articleVendu.getDate_fin_enchere()));
			stmt.setInt(6, articleVendu.getPrix_initial());
			stmt.setInt(7, articleVendu.getPrix_vente());
			stmt.setInt(8, articleVendu.getNo_utilisateur());
			stmt.setInt(9, articleVendu.getNo_categorie());
			int nb = stmt.executeUpdate();
			if (nb > 0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					articleVendu.setNo_article(rs.getInt(1));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL");
		}
	}

	public void delete(ArticleVendu articleVendu) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(DELETE);
			stmt.setInt(1, articleVendu.getNo_article());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL");
		}
	}

	public void update(ArticleVendu articleVendu) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setInt(1, articleVendu.getNo_article());
			stmt.setString(2, articleVendu.getNom_article());
			stmt.setString(3, articleVendu.getDescription());
			stmt.setTime(4, Time.valueOf(articleVendu.getDate_debut_enchere()));
			stmt.setTime(5,Time.valueOf(articleVendu.getDate_fin_enchere()));
			stmt.setInt(6, articleVendu.getPrix_initial());
			stmt.setInt(7, articleVendu.getPrix_vente());
			stmt.setInt(8, articleVendu.getUtilisateur.getNo_utilisateur());
			stmt.setInt(9, articleVendu.getNo_categorie());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL");
		}
	}

	public List<ArticleVendu> getAll() throws DALException {
		List<ArticleVendu> result = new ArrayList<ArticleVendu>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECTALL);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ArticleVendu articleVendu = new ArticleVendu();
				articleVendu.setNo_article(rs.getInt("no_article"));
				articleVendu.setNom_article(rs.getString("nom_article"));
				articleVendu.setDescription(rs.getString("description"));
				articleVendu.setTime(rs.getTime(articleVendu.getDate_debut_enchere()));
				articleVendu.setTime(rs.getTime(articleVendu.getDate_fin_enchere()));
				articleVendu.setPrix_initial(rs.getInt("prix_initial"));
				articleVendu.setPrix_vente(rs.getInt("prix_vente"));
				articleVendu.setNo_utilisateur(rs.getString("no_utilisateur"));
				articleVendu.setNo_categorie(rs.getString("no_categorie"));
				result.add(articleVendu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL");
		}
		return result;
	}

	public ArticleVendu getById(int id) throws DALException {
		ArticleVendu articleVendu = new ArticleVendu();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECTBYID);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				articleVendu.setNo_article(rs.getInt("no_article"));
				articleVendu.setNom_article(rs.getString("nom_article"));
				articleVendu.setDescription(rs.getString("description"));
				articleVendu.setTime(rs.getTime(articleVendu.getDate_debut_enchere()));
				articleVendu.setTime(rs.getTime(articleVendu.getDate_fin_enchere()));
				articleVendu.setPrix_initial(rs.getInt("prix_initial"));
				articleVendu.setPrix_vente(rs.getInt("prix_vente"));
				articleVendu.setNo_utilisateur(rs.getInt("no_utilisateur"));
				articleVendu.setNo_categorie(rs.getInt("no_categorie"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL");
		}
		return articleVendu;
	}
}
