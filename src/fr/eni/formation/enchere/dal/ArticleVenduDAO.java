package fr.eni.formation.enchere.dal;

import java.util.List;

import fr.eni.formation.enchere.bo.ArticleVendu;

public interface ArticleVenduDAO {

public void insert (ArticleVendu articleVendu) throws DALException;
	
	public void delete (ArticleVendu articleVendu)throws DALException;
	
	public void update (ArticleVendu articleVendu)throws DALException;
	
	public List<ArticleVendu> getAll()throws DALException;
	
	public ArticleVendu getById (int id)throws DALException;
}
