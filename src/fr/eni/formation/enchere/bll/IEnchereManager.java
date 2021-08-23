package fr.eni.formation.enchere.bll;

import fr.eni.formation.enchere.bo.ArticleVendu;
import fr.eni.formation.enchere.bo.Enchere;
import fr.eni.formation.enchere.bo.Utilisateur;

public interface IEnchereManager {
	
	public void addEnchere (Enchere enchere,ArticleVendu articleVendu, Utilisateur u) throws BLLException;
	
	public void deleteEnchere (Enchere enchere,ArticleVendu articleVendu, Utilisateur u) throws BLLException;
	
	public void updateEnchere (Enchere enchere,ArticleVendu articleVendu, Utilisateur u) throws BLLException;
}
