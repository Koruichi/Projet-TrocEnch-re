package fr.eni.formation.enchere.bll;

public class EnchereManagerSingl {

	private static IEnchereManager instance;

	public static IEnchereManager getInstance() {

		if (instance == null) {
			instance = new EnchereManagerImpl();
		}
		return instance;

	}

}
