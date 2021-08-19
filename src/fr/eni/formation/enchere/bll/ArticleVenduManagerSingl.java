package fr.eni.formation.enchere.bll;

public class ArticleVenduManagerSingl {

private static ArticleVenduManager instance;
	
	public static ArticleVenduManager getInstance() {
		
		if (instance == null) {
			instance = new ArticleVenduManagerImpl();
		}
		return instance;
		
	}
}
