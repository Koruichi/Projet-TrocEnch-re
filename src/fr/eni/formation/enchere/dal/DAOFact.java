package fr.eni.formation.enchere.dal;

import fr.eni.formation.enchere.dal.jdbc.ArticleVenduDAOImpl;
import fr.eni.formation.enchere.dal.jdbc.EnchereDAOImpl;
import fr.eni.formation.enchere.dal.jdbc.RetraitDAOImpl;
import fr.eni.formation.enchere.dal.jdbc.UtilisateurDAOImpl;

public class DAOFact {

	
	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOImpl();
	}
	
	public static ArticleVenduDAO getArticleVenduDAO() {
		return new ArticleVenduDAOImpl();
	}
	
	public static RetraitDAO getRetraitDAO() {
		return new RetraitDAOImpl();
	}
	
	public static IEnchere getenchereDAO() {
		return new EnchereDAOImpl();
	}
}
