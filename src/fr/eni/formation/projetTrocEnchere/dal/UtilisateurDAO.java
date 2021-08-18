package fr.eni.formation.projetTrocEnchere.dal;

import java.util.List;

import fr.eni.formation.projetTrocEnchere.bo.Utilisateur;

public interface UtilisateurDAO {

	public void insert (Utilisateur utilisateur) throws DALException;
	
	public void delete (Utilisateur utilisateur)throws DALException;
	
	public void update (Utilisateur utilisateur)throws DALException;
	
	public List<Utilisateur> getAll()throws DALException;
	
	public Utilisateur getById (int id)throws DALException;
	
}

