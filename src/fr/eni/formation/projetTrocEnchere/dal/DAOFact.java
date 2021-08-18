package fr.eni.formation.projetTrocEnchere.dal;

import fr.eni.formation.projetTrocEnchere.dal.jdbc.UtilisateurDAOImpl;

public class DAOFact {

	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOImpl();
	}
}
