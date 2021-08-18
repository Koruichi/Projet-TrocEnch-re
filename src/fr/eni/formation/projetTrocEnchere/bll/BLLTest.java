package fr.eni.formation.projetTrocEnchere.bll;

import fr.eni.formation.projetTrocEnchere.bo.Utilisateur;

public class BLLTest {

	public static void main(String[] args) {
		try {
		UtilisateurManager manager = UtilisateurManagerSingl.getInstance();
		Utilisateur u1 = new Utilisateur( "TOTO", "Dupont", "Marc", "toto195@gmail", "06789447", "8 allée Lilas", "44000", "Nantes", "apache345", 250, false);
		
			manager.addUtilisateur(u1);
		
		
		Utilisateur u2 = new Utilisateur("Superman", "Kent", "Clark", "toto195@gmail", "06789447", "8 allée Lilas", "44000", "Nantes", "apache345", 250, false);
		manager.addUtilisateur(u2);
		Utilisateur u3 = new Utilisateur("Batman", "Wayne", "Bruce", "toto195@gmail", "06789447", "8 allée Lilas", "44000", "Nantes", "apache345", 250, false);
		manager.addUtilisateur(u3);
		
		
		//System.out.println(manager.getUtilisateurById(1));
		
		//manager.deleteUtilisateur(u1);
		
		u1.setEmail("gogo14");
		manager.updateUtilisateur(u1);
		System.out.println(manager.getAllUtilisateur());
	} catch (BLLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
