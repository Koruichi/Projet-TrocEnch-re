package fr.eni.formation.projetTrocEnchere.bll;

public class UtilisateurManagerSingl {

	private static UtilisateurManager instance;
	
	public static UtilisateurManager getInstance() {
		
		if (instance == null) {
			instance = new UtilisateurManagerImpl();
		}
		return instance;
		
	}
}
