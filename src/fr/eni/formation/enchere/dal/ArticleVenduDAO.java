package fr.eni.formation.enchere.dal;

import java.util.List;

import fr.eni.formation.enchere.bo.ArticleVendu;
import fr.eni.formation.enchere.bo.Utilisateur;

public interface ArticleVenduDAO {

public void insert (ArticleVendu articleVendu, Utilisateur u) throws DALException;
	
	public void delete (ArticleVendu articleVendu, Utilisateur u)throws DALException;
	
	public void update (ArticleVendu articleVendu, Utilisateur u)throws DALException;
	
	public List<ArticleVendu> getAll(Utilisateur u)throws DALException;
	
	public ArticleVendu getById (int id, Utilisateur u)throws DALException;
}
