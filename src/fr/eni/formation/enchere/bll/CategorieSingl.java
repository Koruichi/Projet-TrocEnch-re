package fr.eni.formation.enchere.bll;

public class CategorieSingl {

	private static ICategorie instance;

	public static ICategorie getInstance() {

		if (instance == null) {
			instance = new CategorieManagerImpl();
		}
		return instance;

	}
}
