package fr.eni.formation.enchere.bll;

import java.util.List;

import fr.eni.formation.enchere.bo.ArticleVendu;
import fr.eni.formation.enchere.dal.ArticleVenduDAO;
import fr.eni.formation.enchere.dal.DALException;
import fr.eni.formation.enchere.dal.DAOFact;

public class ArticleVenduManagerImpl implements ArticleVenduManager{
	ArticleVenduDAO dao = DAOFact.getArticleVenduDAO();
	
	@Override
	public void addArticle(ArticleVendu articleVendu) throws BLLException {
		try {
			dao.insert(articleVendu);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void deleteArticle(ArticleVendu articleVendu) throws BLLException {
		try {
			dao.delete(articleVendu);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public void updateArticle(ArticleVendu articleVendu) throws BLLException {
		try {
			dao.update(articleVendu);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public List<ArticleVendu> getAllArticle() throws BLLException {
		try {
			return dao.getAll();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	

}
