package fr.eni.formation.enchere.bll;

import java.util.List;

import fr.eni.formation.enchere.bo.ArticleVendu;
import fr.eni.formation.enchere.bo.Retrait;

public interface RetraitManager {

	public void addRetrait(Retrait retrait, ArticleVendu articleVendu) throws BLLException;

	public void deleteRetrait(Retrait retrait, ArticleVendu articleVendu) throws BLLException;

	public void updateRetrait(Retrait retrait, ArticleVendu articleVendu) throws BLLException;

	public List<Retrait> getAllRetrait(ArticleVendu articleVendu);

}
