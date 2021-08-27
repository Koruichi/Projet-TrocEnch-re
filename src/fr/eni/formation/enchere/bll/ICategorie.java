package fr.eni.formation.enchere.bll;

import java.util.List;

import fr.eni.formation.enchere.bo.Categorie;

public interface ICategorie {

	public List<Categorie> getAllCategorie() throws BLLException;

}
