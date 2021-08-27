package fr.eni.formation.enchere.bll;

import fr.eni.formation.enchere.bo.ArticleVendu;
import fr.eni.formation.enchere.bo.Enchere;
import fr.eni.formation.enchere.bo.Utilisateur;
import fr.eni.formation.enchere.dal.DALException;
import fr.eni.formation.enchere.dal.DAOFact;
import fr.eni.formation.enchere.dal.IEnchere;

public class EnchereManagerImpl implements IEnchereManager {
	IEnchere dao = DAOFact.getenchereDAO();

	@Override
	public void addEnchere(Enchere enchere, ArticleVendu a, Utilisateur u) throws BLLException {

		try {
			dao.addEnchere(enchere, a, u);
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEnchere(Enchere enchere, ArticleVendu a, Utilisateur u) throws BLLException {
		try {
			dao.deleteEnchere(enchere, a, u);
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateEnchere(Enchere enchere, ArticleVendu a, Utilisateur u) throws BLLException {
		try {
			dao.updateEnchere(enchere, a, u);
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

}
