package fr.eni.formation.enchere.bll;

import java.util.List;

import fr.eni.formation.enchere.bo.Categorie;
import fr.eni.formation.enchere.dal.ArticleVenduDAO;
import fr.eni.formation.enchere.dal.DALException;
import fr.eni.formation.enchere.dal.DAOFact;
import fr.eni.formation.enchere.dal.ICategorieDAO;

public class CategorieManagerImpl implements ICategorie {
	ICategorieDAO dao = DAOFact.getCategorieDAO();
	@Override
	public List<Categorie> getAllCategorie() throws BLLException {
		
		try {
			return dao.getAll();
		} catch (DALException e) {
			e.printStackTrace();
		}
		return null;
	}

}
