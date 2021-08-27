package fr.eni.formation.enchere.bll;

import java.util.List;

import fr.eni.formation.enchere.bo.ArticleVendu;
import fr.eni.formation.enchere.bo.Retrait;
import fr.eni.formation.enchere.dal.DALException;
import fr.eni.formation.enchere.dal.DAOFact;
import fr.eni.formation.enchere.dal.RetraitDAO;

public class RetraitManagerImpl implements RetraitManager {

	RetraitDAO dao = DAOFact.getRetraitDAO();

	@Override
	public void addRetrait(Retrait retrait, ArticleVendu articleVendu) throws BLLException {
		try {
			dao.insert(retrait, articleVendu);
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteRetrait(Retrait retrait, ArticleVendu articleVendu) throws BLLException {
		try {
			dao.delete(retrait, articleVendu);
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateRetrait(Retrait retrait, ArticleVendu articleVendu) throws BLLException {
		try {
			dao.update(retrait, articleVendu);
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Retrait> getAllRetrait(ArticleVendu articleVendu) {
		try {
			return dao.getAll(articleVendu);
		} catch (DALException e) {
			e.printStackTrace();
		}
		return null;
	}

}
