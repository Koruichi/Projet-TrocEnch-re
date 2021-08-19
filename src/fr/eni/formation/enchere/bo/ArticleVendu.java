package fr.eni.formation.enchere.bo;

import java.time.LocalTime;
import java.util.List;

public class ArticleVendu {
	
	private int no_article;
	private String nom_article;
	private String description;
	private LocalTime date_debut_enchere;
	private LocalTime date_fin_enchere;
	private int prix_initial;
	private int prix_vente;
	private String etat_vente;
	private Categorie categorie;
	private Utilisateur utilisateur;
	private List<Enchere> lstEnchere;
	
	//constructeur par defaut
	public ArticleVendu() {
		super();
	}
	
	
	//constructeur avec les paramettre
	
	
	public ArticleVendu(int no_article, String nom_article, String description, LocalTime date_debut_enchere,
			LocalTime date_fin_enchere, int prix_initial, int prix_vente, String etat_vente, Categorie categorie,
			Utilisateur utilisateur, List<Enchere> lstEnchere) {
		super();
		this.no_article = no_article;
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_enchere = date_debut_enchere;
		this.date_fin_enchere = date_fin_enchere;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
		this.etat_vente = etat_vente;
		this.categorie = categorie;
		this.utilisateur = utilisateur;
		this.lstEnchere = lstEnchere;
	}


	public ArticleVendu(int no_article, String nom_article, String description, LocalTime date_debut_enchere,
			LocalTime date_fin_enchere, int prix_initial, int prix_vente, String etat_vente, Categorie categorie,
			Utilisateur utilisateur) {
		super();
		this.no_article = no_article;
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_enchere = date_debut_enchere;
		this.date_fin_enchere = date_fin_enchere;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
		this.etat_vente = etat_vente;
		this.categorie = categorie;
		this.utilisateur = utilisateur;
	}

//getters
	public int getNo_article() {
		return no_article;
	}


	public String getNom_article() {
		return nom_article;
	}


	public String getDescription() {
		return description;
	}


	public LocalTime getDate_debut_enchere() {
		return date_debut_enchere;
	}


	public LocalTime getDate_fin_enchere() {
		return date_fin_enchere;
	}


	public int getPrix_initial() {
		return prix_initial;
	}


	public int getPrix_vente() {
		return prix_vente;
	}


	public String getEtat_vente() {
		return etat_vente;
	}


	public Categorie getCategorie() {
		return categorie;
	}


	public Utilisateur getUtilisateur() {
		return utilisateur;
	}


	public List<Enchere> getLstEnchere() {
		return lstEnchere;
	}

//setters
	public void setNo_article(int no_article) {
		this.no_article = no_article;
	}


	public void setNom_article(String nom_article) {
		this.nom_article = nom_article;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setDate_debut_enchere(LocalTime date_debut_enchere) {
		this.date_debut_enchere = date_debut_enchere;
	}


	public void setDate_fin_enchere(LocalTime date_fin_enchere) {
		this.date_fin_enchere = date_fin_enchere;
	}


	public void setPrix_initial(int prix_initial) {
		this.prix_initial = prix_initial;
	}


	public void setPrix_vente(int prix_vente) {
		this.prix_vente = prix_vente;
	}


	public void setEtat_vente(String etat_vente) {
		this.etat_vente = etat_vente;
	}


	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}


	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}


	public void setLstEnchere(List<Enchere> lstEnchere) {
		this.lstEnchere = lstEnchere;
	}

	//affichage
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Article [no_article=");
		builder.append(no_article);
		builder.append(", nom_article=");
		builder.append(nom_article);
		builder.append(", description=");
		builder.append(description);
		builder.append(", date_debut_enchere=");
		builder.append(date_debut_enchere);
		builder.append(", date_fin_enchere=");
		builder.append(date_fin_enchere);
		builder.append(", prix_initial=");
		builder.append(prix_initial);
		builder.append(", prix_vente=");
		builder.append(prix_vente);
		builder.append(", etat_vente=");
		builder.append(etat_vente);
		builder.append(", categorie=");
		builder.append(categorie);
		builder.append(", utilisateur=");
		builder.append(utilisateur);
		builder.append(", lstEnchere++=");
		builder.append(lstEnchere);
		builder.append("]");
		return builder.toString();
	}

	
	
	

}
