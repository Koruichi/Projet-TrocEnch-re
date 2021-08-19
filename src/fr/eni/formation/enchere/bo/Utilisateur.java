package fr.eni.formation.enchere.bo;

import java.util.List;

public class Utilisateur {
	private int no_utilisateur;
	private String pseudo;
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String rue;
	private String code_postal;
	private String ville;
	private String mot_de_passe;
	private int credit;
	private boolean administrateur;
	private List<ArticleVendu> lstArticleAchete;
	private List<ArticleVendu> lstArticlevendu;
	private List<Enchere> lstEnchere;
	
	
	
	// Constructeurs
	
	public Utilisateur() {
		super();
	}
	public Utilisateur(int no_utilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String code_postal, String ville, String mot_de_passe, int credit, boolean administrateur) {
		super();
		this.no_utilisateur = no_utilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.mot_de_passe = mot_de_passe;
		this.credit = credit;
		this.administrateur = administrateur;
	}
	public Utilisateur(int no_utilisateur, String pseudo, String nom, String prenom, String email, String telephone,
			String rue, String code_postal, String ville, String mot_de_passe, int credit, boolean administrateur,
			List<ArticleVendu> lstArticleAchete, List<ArticleVendu> lstArticlevendu, List<Enchere> lstEnchere) {
		super();
		this.no_utilisateur = no_utilisateur;
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.mot_de_passe = mot_de_passe;
		this.credit = credit;
		this.administrateur = administrateur;
		this.lstArticleAchete = lstArticleAchete;
		this.lstArticlevendu = lstArticlevendu;
		this.lstEnchere = lstEnchere;
	}
	
	
	public Utilisateur(String pseudo, String nom, String prenom, String email, String telephone, String rue,
			String code_postal, String ville, String mot_de_passe, int credit, boolean administrateur) {
		super();
		this.pseudo = pseudo;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.rue = rue;
		this.code_postal = code_postal;
		this.ville = ville;
		this.mot_de_passe = mot_de_passe;
		this.credit = credit;
		this.administrateur = administrateur;
	}
	
	// Get
	
	public int getNo_utilisateur() {
		return no_utilisateur;
	}
	public String getPseudo() {
		return pseudo;
	}
	public String getNom() {
		return nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public String getEmail() {
		return email;
	}
	public String getTelephone() {
		return telephone;
	}
	public String getRue() {
		return rue;
	}
	public String getCode_postal() {
		return code_postal;
	}
	public String getVille() {
		return ville;
	}
	public String getMot_de_passe() {
		return mot_de_passe;
	}
	public int getCredit() {
		return credit;
	}
	public boolean isAdministrateur() {
		return administrateur;
	}
	public List<ArticleVendu> getLstArticleAchete() {
		return lstArticleAchete;
	}
	public List<ArticleVendu> getLstArticlevendu() {
		return lstArticlevendu;
	}
	public List<Enchere> getLstEnchere() {
		return lstEnchere;
	}
	
	// SET
	
	public void setNo_utilisateur(int no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public void setMot_de_passe(String mot_de_passe) {
		this.mot_de_passe = mot_de_passe;
	}
	public void setCredit(int credit) {
		this.credit = credit;
	}
	public void setAdministrateur(boolean administrateur) {
		this.administrateur = administrateur;
	}
	public void setLstArticleAchete(List<ArticleVendu> lstArticleAchete) {
		this.lstArticleAchete = lstArticleAchete;
	}
	public void setLstArticlevendu(List<ArticleVendu> lstArticlevendu) {
		this.lstArticlevendu = lstArticlevendu;
	}
	public void setLstEnchere(List<Enchere> lstEnchere) {
		this.lstEnchere = lstEnchere;
	}
	
	// TO STring
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Utilisateur [no_utilisateur=");
		builder.append(no_utilisateur);
		builder.append(", pseudo=");
		builder.append(pseudo);
		builder.append(", nom=");
		builder.append(nom);
		builder.append(", prenom=");
		builder.append(prenom);
		builder.append(", email=");
		builder.append(email);
		builder.append(", telephone=");
		builder.append(telephone);
		builder.append(", rue=");
		builder.append(rue);
		builder.append(", code_postal=");
		builder.append(code_postal);
		builder.append(", ville=");
		builder.append(ville);
		builder.append(", mot_de_passe=");
		builder.append(mot_de_passe);
		builder.append(", credit=");
		builder.append(credit);
		builder.append(", administrateur=");
		builder.append(administrateur);
		builder.append(", lstArticleAchete=");
		builder.append(lstArticleAchete);
		builder.append(", lstArticlevendu=");
		builder.append(lstArticlevendu);
		builder.append(", lstEnchere=");
		builder.append(lstEnchere);
		builder.append("]");
		return builder.toString();
	}
	


}
