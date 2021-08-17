package fr.eni.formation.projetTrocEnchere.bll;

import java.util.List;

import fr.eni.formation.projetTrocEnchere.bo.Utilisateur;
import fr.eni.formation.projetTrocEnchere.dal.DAOFact;
import fr.eni.formation.projetTrocEnchere.dal.UtilisateurDAO;

public class UtilisateurManagerImpl implements UtilisateurManager {

	UtilisateurDAO dao = DAOFact.getUtilisateurDAO();
	
	@Override
	public void addUtilisateur(Utilisateur utilisateur) {
		dao.insert(utilisateur);
	}

	@Override
	public void deleteUtilisateur(Utilisateur utilisateur) {
		dao.delete(utilisateur);
	}

	@Override
	public void updateUtilisateur(Utilisateur utilisateur) {
		dao.update(utilisateur);
	}

	@Override
	public List<Utilisateur> getAllUtilisateur() {
		return dao.getAll();
	}

	@Override
	public Utilisateur getUtilisateurById(int id) {
		return dao.getById(id);
	}

}
