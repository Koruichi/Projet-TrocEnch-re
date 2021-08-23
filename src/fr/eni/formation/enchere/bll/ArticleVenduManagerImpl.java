package fr.eni.formation.enchere.bll;

import java.util.List;

import fr.eni.formation.enchere.bo.ArticleVendu;
import fr.eni.formation.enchere.bo.Utilisateur;
import fr.eni.formation.enchere.dal.ArticleVenduDAO;
import fr.eni.formation.enchere.dal.DALException;
import fr.eni.formation.enchere.dal.DAOFact;
import fr.formation.bll.BllException;

public class ArticleVenduManagerImpl implements ArticleVenduManager{
	ArticleVenduDAO dao = DAOFact.getArticleVenduDAO();
	
	@Override
	public void addArticle(ArticleVendu articleVendu, Utilisateur u) throws BLLException {
		BLLException exception = new BLLException();
		
		if (articleVendu.getNom_article() == null || articleVendu.getNom_article().trim().isEmpty()) {
			exception.ajoutMessage("Le nom de l'article est obligatoire");
		}
		if (articleVendu.getDescription() == null || articleVendu.getDescription().trim().isEmpty()) {
			exception.ajoutMessage("Une description de l'article est obligatoire");
		}
		if (articleVendu.getCategorie().getNo_categorie() == null || articleVendu.getCategorie().getNo_categorie().isEmpty()) {
			exception.ajoutMessage("Vous devez s�lectionner une cat�gorie");
		}
		if (articleVendu.getPrix_initial() == null || articleVendu.getDescription().trim().isEmpty()) {
			exception.ajoutMessage("Une description de l'article est obligatoire");
		}
		try {
			dao.insert(articleVendu, u);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void deleteArticle(ArticleVendu articleVendu, Utilisateur u) throws BLLException {
		try {
			dao.delete(articleVendu, u);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void updateArticle(ArticleVendu articleVendu, Utilisateur u) throws BLLException {
		try {
			dao.update(articleVendu, u);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public List<ArticleVendu> getAllArticle(Utilisateur u) throws BLLException {
		try {
			return dao.getAll(u);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	

	
	

}
