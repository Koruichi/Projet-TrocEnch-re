package fr.eni.formation.enchere.dal;

import java.util.List;

import fr.eni.formation.enchere.bo.Categorie;

public interface ICategorieDAO {
	public List<Categorie> getAll() throws DALException;
}
