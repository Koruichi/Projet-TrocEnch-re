package fr.eni.formation.enchere.bll;

import java.util.List;

import fr.eni.formation.enchere.bo.Utilisateur;
import fr.eni.formation.enchere.dal.DALException;
import fr.eni.formation.enchere.dal.DAOFact;
import fr.eni.formation.enchere.dal.UtilisateurDAO;

public class UtilisateurManagerImpl implements UtilisateurManager {

	UtilisateurDAO dao = DAOFact.getUtilisateurDAO();

	@Override
	public void addUtilisateur(Utilisateur u) throws BLLException {
		BLLException ex = new BLLException();

		if (u.getPseudo() == null || u.getPseudo().trim().isEmpty()) {
			ex.ajoutMessage("Le pseudo est obligatoire");
		}
		if (u.getNom() == null || u.getNom().trim().isEmpty()) {
			ex.ajoutMessage("Le nom est obligatoire");
		}
		if (u.getPrenom() == null || u.getPrenom().trim().isEmpty()) {
			ex.ajoutMessage("Le pr�nom est obligatoire");
		}
		if (u.getEmail() == null || u.getEmail().trim().isEmpty()) {
			ex.ajoutMessage("L'email est obligatoire");
		}
		if (u.getTelephone() == null || u.getTelephone().trim().isEmpty()) {
			ex.ajoutMessage("Le numero de telephone est obligatoire");
		}
		if (u.getRue() == null || u.getRue().trim().isEmpty()) {
			ex.ajoutMessage("La rue est obligatoire");
		}
		if (u.getCode_postal() == null || u.getCode_postal().trim().isEmpty()) {
			ex.ajoutMessage("Le code postal est obligatoire");
		}
		if (u.getVille() == null || u.getVille().trim().isEmpty()) {
			ex.ajoutMessage("La ville est obligatoire");
		}
		if (u.getMot_de_passe() == null || u.getMot_de_passe().trim().isEmpty()) {
			ex.ajoutMessage("Le mot de passe est obligatoire");
		}
		if (!isAlphaNum(u.getPseudo())) {
			ex.ajoutMessage("Le pseudo contient des caracteres speciaux interdits");
		}
		if (!isUnique(u.getPseudo())) {
			ex.ajoutMessage("Le pseudo existe deja");
		}
		if (!isUnique(u.getEmail())) {
			ex.ajoutMessage("L'email existe deja");
		}

		if (ex.estVide()) {
			try {
				dao.insert(u);
			} catch (DALException e) {
				ex.ajoutMessage("Un probl�me d'acc�s � la base de donn�es : " + e.getMessage());
			}
		} else {
			throw ex;
		}

	}

	@Override
	public void deleteUtilisateur(Utilisateur u) throws BLLException {
		try {
			dao.delete(u);
		} catch (DALException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateUtilisateur(Utilisateur u) throws BLLException {
		BLLException ex = new BLLException();
		if (u.getPseudo() == null || u.getPseudo().trim().isEmpty()) {
			ex.ajoutMessage("Le pseudo est obligatoire");
		}
		if (u.getNom() == null || u.getNom().trim().isEmpty()) {
			ex.ajoutMessage("Le nom est obligatoire");
		}
		if (u.getPrenom() == null || u.getPrenom().trim().isEmpty()) {
			ex.ajoutMessage("Le prenom est obligatoire");
		}
		if (u.getEmail() == null || u.getEmail().trim().isEmpty()) {
			ex.ajoutMessage("L'email est obligatoire");
		}
		if (u.getTelephone() == null || u.getTelephone().trim().isEmpty()) {
			ex.ajoutMessage("Le num�ro de telephone est obligatoire");
		}
		if (u.getRue() == null || u.getRue().trim().isEmpty()) {
			ex.ajoutMessage("La rue est obligatoire");
		}
		if (u.getCode_postal() == null || u.getCode_postal().trim().isEmpty()) {
			ex.ajoutMessage("Le code postal est obligatoire");
		}
		if (u.getVille() == null || u.getVille().trim().isEmpty()) {
			ex.ajoutMessage("La ville est obligatoire");
		}

		if (!confirmMDP(u.getMot_de_passe(), u.getMot_de_passe())) {
			ex.ajoutMessage("Mot de passe et confirmation doivent etre identique");
		}
		if (!isAlphaNum(u.getPseudo())) {
			ex.ajoutMessage("Le pseudo contient des caracteres speciaux interdits");
		}

		if (ex.estVide()) {
			try {
				dao.update(u);
			} catch (DALException e) {
				ex.ajoutMessage("Un probleme d'acces a la base de donnees : " + e.getMessage());
			}
		} else {
			throw ex;
		}
	}

	@Override
	public List<Utilisateur> getAllUtilisateur() throws BLLException {
		try {
			return dao.getAll();
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Utilisateur getUtilisateurById(int id) throws BLLException {
		try {
			return dao.getById(id);
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public boolean confirmMDP(String mdp1, String mdp2) throws BLLException {
		if (mdp1.equals(mdp2)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean isAlphaNum(String pseudo) throws BLLException {
		if (pseudo.matches("[a-zA-Z0-9]*")) {
			return true;
		} else {
			return false;
		}

	}

	@Override
	public boolean isUnique(String identifiant) throws BLLException {
		for (Utilisateur u : getAllUtilisateur()) {
			if (identifiant.equals(u.getPseudo()) || identifiant.equals(u.getEmail())) {
				return false;
			}
		}
		return true;
	}
}
