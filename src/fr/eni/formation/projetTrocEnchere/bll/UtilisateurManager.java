package fr.eni.formation.projetTrocEnchere.bll;

import java.util.List;

import fr.eni.formation.projetTrocEnchere.bo.Utilisateur;

public interface UtilisateurManager {

	public void addUtilisateur(Utilisateur utilisateur);
	
	public void deleteUtilisateur(Utilisateur utilisateur);
	
	public void updateUtilisateur(Utilisateur utilisateur);
	
	public List<Utilisateur> getAllUtilisateur();
	
	public Utilisateur getUtilisateurById(int id);
}
