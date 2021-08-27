package fr.eni.formation.enchere.dal;

import java.util.List;

import fr.eni.formation.enchere.bo.ArticleVendu;
import fr.eni.formation.enchere.bo.Retrait;

public interface RetraitDAO {

	public void insert(Retrait retrait, ArticleVendu articleVendu) throws DALException;

	public void delete(Retrait retrait, ArticleVendu articleVendu) throws DALException;

	public void update(Retrait retrait, ArticleVendu articleVendu) throws DALException;

	public List<Retrait> getAll(ArticleVendu articleVendu) throws DALException;

}
