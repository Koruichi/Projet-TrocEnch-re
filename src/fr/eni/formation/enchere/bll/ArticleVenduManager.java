package fr.eni.formation.enchere.bll;

import java.util.List;

import fr.eni.formation.enchere.bo.ArticleVendu;

public interface ArticleVenduManager {

	public void addArticle (ArticleVendu articleVendu) throws BLLException;
	
	public void deleteArticle (ArticleVendu articleVendu) throws BLLException;
	
	public void updateArticle (ArticleVendu articleVendu) throws BLLException;
	
	public List<ArticleVendu> getAllArticle()throws BLLException;
	

	
}
