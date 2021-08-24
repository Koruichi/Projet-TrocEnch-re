package fr.eni.formation.enchere.dal;

import java.util.List;

import fr.eni.formation.enchere.bo.ArticleVendu;
import fr.eni.formation.enchere.bo.Categorie;
import fr.eni.formation.enchere.bo.Utilisateur;
import fr.eni.formation.enchere.dto.AfficheArticle;

public interface ArticleVenduDAO {

	public void insert (ArticleVendu articleVendu, Utilisateur u) throws DALException;
	
	public void delete (ArticleVendu articleVendu, Utilisateur u)throws DALException;
	
	public void update (ArticleVendu articleVendu, Utilisateur u)throws DALException;
	
	public List<ArticleVendu> getAll(Utilisateur u)throws DALException;
	
	public ArticleVendu getById (int id, Utilisateur u)throws DALException;

	public List<AfficheArticle> getAll() throws DALException;

	public List<AfficheArticle> selectByMotCle(String motCle)throws DALException;
	
	public List<Categorie> selectByCategorie(Categorie categorie)throws DALException;
}
