package fr.eni.formation.enchere.ihm;

import java.util.List;

import fr.eni.formation.enchere.bo.Utilisateur;

public class UtilisateurModel {
	private Utilisateur utilisateur;
	private List<Utilisateur> lstUtilisateur;

	public UtilisateurModel() {
	}

	public UtilisateurModel(Utilisateur utilisateur, List<Utilisateur> lstUtilisateur) {

		this.utilisateur = utilisateur;
		this.lstUtilisateur = lstUtilisateur;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public List<Utilisateur> getLstUtilisateur() {
		return lstUtilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public void setLstUtilisateur(List<Utilisateur> lstUtilisateur) {
		this.lstUtilisateur = lstUtilisateur;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ModelUtilisateur [utilisateur=");
		builder.append(utilisateur);
		builder.append(", lstUtilisateur=");
		builder.append(lstUtilisateur);
		builder.append("]");
		return builder.toString();
	}

}
