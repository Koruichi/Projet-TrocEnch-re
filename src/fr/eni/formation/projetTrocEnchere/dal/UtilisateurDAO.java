package fr.eni.formation.projetTrocEnchere.dal;

import java.util.List;

import fr.eni.formation.projetTrocEnchere.bo.Utilisateur;

public interface UtilisateurDAO {

	public void insert (Utilisateur utilisateur);
	
	public void delete (Utilisateur utilisateur);
	
	public void update (Utilisateur utilisateur);
	
	public List<Utilisateur> getAll();
	
	public Utilisateur getById (int id);
	
}

