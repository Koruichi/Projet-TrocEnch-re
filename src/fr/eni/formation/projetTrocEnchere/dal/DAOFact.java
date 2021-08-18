package fr.eni.formation.projetTrocEnchere.dal;

public class DAOFact {

	public static UtilisateurDAO getUtilisateurDAO() {
		return new UtilisateurDAOImpl();
	}
}
