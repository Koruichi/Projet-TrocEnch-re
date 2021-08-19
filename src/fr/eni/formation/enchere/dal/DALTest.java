package fr.eni.formation.enchere.dal;

import fr.eni.formation.enchere.bo.Utilisateur;

public class DALTest {

	public static void main(String[] args) {
		try {
			UtilisateurDAO dao = DAOFact.getUtilisateurDAO();
			Utilisateur u1 = new Utilisateur("TOTO", "Dupont", "Marc", "toto195@gmail", "06789447", "8 allée Lilas",
					"44000", "Nantes", "apache345", 250, false);

			dao.insert(u1);

			Utilisateur u2 = new Utilisateur("Superman", "Kent", "Clark", "toto195@gmail", "06789447", "8 allée Lilas",
					"44000", "Nantes", "apache345", 250, false);
			dao.insert(u2);
			Utilisateur u3 = new Utilisateur("Batman", "Wayne", "Bruce", "toto195@gmail", "06789447", "8 allée Lilas",
					"44000", "Nantes", "apache345", 250, false);
			dao.insert(u3);

			//u1.setMot_de_passe("azerty123");
			//dao.update(u1);
			System.out.println(dao.getAll());
		} catch (DALException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// System.out.println(dao.getById(1));
	}

}