package fr.eni.formation.enchere.bll;

import java.util.List;

import fr.eni.formation.enchere.bo.ArticleVendu;
import fr.eni.formation.enchere.bo.Retrait;
import fr.eni.formation.enchere.bo.Utilisateur;
import fr.eni.formation.enchere.dal.ArticleVenduDAO;

public interface ArticleVenduManager {
	
	public void addArticle (ArticleVendu articleVendu, Utilisateur u) throws BLLException;
	
	public void deleteArticle (ArticleVendu articleVendu, Utilisateur u) throws BLLException;
	
	public void updateArticle (ArticleVendu articleVendu, Utilisateur u) throws BLLException;
	
	public List<ArticleVendu> getAllArticle(Utilisateur u)throws BLLException;


	

	
}
