package fr.eni.formation.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import fr.eni.formation.enchere.bo.ArticleVendu;
import fr.eni.formation.enchere.bo.Retrait;
import fr.eni.formation.enchere.dal.DALException;
import fr.eni.formation.enchere.dal.RetraitDAO;

public class RetraitDAOImpl implements RetraitDAO {

	private final String INSERT = "INSERT INTO retraits (rue, code_postal, ville) VALUES(?,?,?)";
	private final String DELETE = "DELETE FROM retraits WHERE no_article =?";
	private final String UPDATE = "UPDATE retraits SET rue=?, code_postal=?, ville=? WHERE retraits=?";
	private final String SELECTALL = "SELECT retraits, no_article, rue, code_postal, ville from retraits";

	@Override
	public void insert(Retrait retrait, ArticleVendu articleVendu) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, retrait.getRue());
			stmt.setString(2, retrait.getCode_postal());
			stmt.setString(3, retrait.getVille());

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL");
		}
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
			stmt.setString(2, retrait.getRue());
			stmt.setString(3, retrait.getCode_postal());
			stmt.setString(6, retrait.getVille());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL");
		}
	}

	public List<Retrait> getall(ArticleVendu articleVendu) throws DALException {
		List<Retrait> result = new ArrayList<Retrait>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECTALL);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Retrait retrait = new Retrait();
				articleVendu.setNo_article(rs.getInt("no_article"));
				retrait.setRue(rs.getString("rue"));
				retrait.setCode_postal(rs.getString("code_postal"));
				retrait.setVille(rs.getString("ville"));
				result.add(retrait);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL");
		}
		return result;
	}

	@Override
	public List<Retrait> getAll(ArticleVendu articleVendu) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

}
