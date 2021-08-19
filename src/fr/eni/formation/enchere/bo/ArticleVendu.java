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
	private Retrait retrait;
	
	//Constructeurs
	
	public ArticleVendu() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArticleVendu(int no_article, String nom_article, String description, LocalTime date_debut_enchere,
			LocalTime date_fin_enchere, int prix_initial, int prix_vente, String etat_vente, Categorie categorie,
			Retrait retrait) {
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
		this.retrait = retrait;
	}
	public ArticleVendu(String nom_article, String description, LocalTime date_debut_enchere,
			LocalTime date_fin_enchere, int prix_initial, int prix_vente, String etat_vente, Categorie categorie,
			Retrait retrait) {
		super();
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_enchere = date_debut_enchere;
		this.date_fin_enchere = date_fin_enchere;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
		this.etat_vente = etat_vente;
		this.categorie = categorie;
		this.retrait = retrait;
	}
	public ArticleVendu(String nom_article, String description, LocalTime date_debut_enchere,
			LocalTime date_fin_enchere, int prix_initial, int prix_vente, String etat_vente) {
		super();
		this.nom_article = nom_article;
		this.description = description;
		this.date_debut_enchere = date_debut_enchere;
		this.date_fin_enchere = date_fin_enchere;
		this.prix_initial = prix_initial;
		this.prix_vente = prix_vente;
		this.etat_vente = etat_vente;
	}
	
	
	//GET & SET
	public int getNo_article() {
		return no_article;
	}
	public void setNo_article(int no_article) {
		this.no_article = no_article;
	}
	public String getNom_article() {
		return nom_article;
	}
	public void setNom_article(String nom_article) {
		this.nom_article = nom_article;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalTime getDate_debut_enchere() {
		return date_debut_enchere;
	}
	public void setDate_debut_enchere(LocalTime date_debut_enchere) {
		this.date_debut_enchere = date_debut_enchere;
	}
	public LocalTime getDate_fin_enchere() {
		return date_fin_enchere;
	}
	public void setDate_fin_enchere(LocalTime date_fin_enchere) {
		this.date_fin_enchere = date_fin_enchere;
	}
	public int getPrix_initial() {
		return prix_initial;
	}
	public void setPrix_initial(int prix_initial) {
		this.prix_initial = prix_initial;
	}
	public int getPrix_vente() {
		return prix_vente;
	}
	public void setPrix_vente(int prix_vente) {
		this.prix_vente = prix_vente;
	}
	public String getEtat_vente() {
		return etat_vente;
	}
	public void setEtat_vente(String etat_vente) {
		this.etat_vente = etat_vente;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	public Retrait getRetrait() {
		return retrait;
	}
	public void setRetrait(Retrait retrait) {
		this.retrait = retrait;
	}
	
	//TO STRing
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArticleVendu [no_article=");
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
		builder.append(", retrait=");
		builder.append(retrait);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
	
	
	