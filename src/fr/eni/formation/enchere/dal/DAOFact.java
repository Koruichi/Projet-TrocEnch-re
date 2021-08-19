package fr.eni.formation.enchere.dal;

import fr.eni.formation.enchere.dal.jdbc.UtilisateurDAOImpl;

public class DAOFact {

	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOImpl();
	}
}
