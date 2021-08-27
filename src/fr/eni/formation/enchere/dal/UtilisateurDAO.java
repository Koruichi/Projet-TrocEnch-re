package fr.eni.formation.enchere.dal;

import java.util.List;

import fr.eni.formation.enchere.bo.Utilisateur;

public interface UtilisateurDAO {

	public void insert(Utilisateur utilisateur) throws DALException;

	public void delete(Utilisateur utilisateur) throws DALException;

	public void update(Utilisateur utilisateur) throws DALException;

	public List<Utilisateur> getAll() throws DALException;

	public Utilisateur getById(int id) throws DALException;

}
