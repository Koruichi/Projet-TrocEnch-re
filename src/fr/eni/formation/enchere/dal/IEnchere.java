package fr.eni.formation.enchere.dal;


import fr.eni.formation.enchere.bll.BLLException;
import fr.eni.formation.enchere.bo.ArticleVendu;
import fr.eni.formation.enchere.bo.Enchere;
import fr.eni.formation.enchere.bo.Utilisateur;

public interface IEnchere {
	
	public void addEnchere ( Enchere enchere, ArticleVendu articleVendu, Utilisateur u) throws BLLException, DALException;
	
	public void deleteEnchere (Enchere enchere,ArticleVendu articleVendu, Utilisateur u) throws BLLException, DALException;
	
	public void updateEnchere (Enchere enchere,ArticleVendu articleVendu, Utilisateur u) throws BLLException, DALException;
	

}
