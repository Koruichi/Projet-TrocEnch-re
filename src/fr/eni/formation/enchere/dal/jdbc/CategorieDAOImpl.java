package fr.eni.formation.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import fr.eni.formation.enchere.bo.Categorie;
import fr.eni.formation.enchere.dal.DALException;
import fr.eni.formation.enchere.dal.ICategorieDAO;

public class CategorieDAOImpl implements ICategorieDAO{
	private final String SELECTALL = "SELECT no_categorie,libelle FROM categories";

	@Override
	public List<Categorie> getAll() throws DALException {
		List<Categorie> result = new ArrayList<Categorie>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECTALL);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Categorie categorie = new Categorie();
				categorie.setNo_categorie(rs.getInt("no_categorie"));
				categorie.setLibelle(rs.getString("libelle"));

				result.add(categorie);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL");
		}
		return result;
	}

}
