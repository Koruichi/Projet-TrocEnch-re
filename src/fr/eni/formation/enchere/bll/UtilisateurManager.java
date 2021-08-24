package fr.eni.formation.enchere.bll;

import java.util.List;

import fr.eni.formation.enchere.bo.Utilisateur;

public interface UtilisateurManager {

	public void addUtilisateur(Utilisateur u)throws BLLException;
	
	public void deleteUtilisateur(Utilisateur u)throws BLLException;
	
	public void updateUtilisateur(Utilisateur u)throws BLLException;
	
	public List<Utilisateur> getAllUtilisateur()throws BLLException;
	
	public Utilisateur getUtilisateurById(int id)throws BLLException;
	
	public boolean confirmMDP(String mdp1, String mdp2) throws BLLException;
	
	public boolean isAlphaNum (String pseudo) throws BLLException;
	
	public boolean isUnique (String identifiant) throws BLLException;
}
