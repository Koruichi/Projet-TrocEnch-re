package fr.eni.formation.enchere.dto;

import java.time.LocalDateTime;




public class AfficheArticle {
	private int id ;
	private int no_utilisateur;
	private int no_categorie;
	private int no_article;
	private String nom_article;
	private int prix_vente;
	private LocalDateTime date_fin_enchere;
	private String pseudo;
	
	
	public AfficheArticle() {
		super();
	}
	public AfficheArticle(int id,int no_utilisateur, int no_categorie,int no_article, String nom_article, int prix_vente, LocalDateTime date_fin_enchere, String pseudo) {
		super();
		this.id = id;
		this.no_utilisateur =  no_utilisateur;
		this.no_categorie =   no_categorie;
		this.setNo_article(no_article);
		this.nom_article = nom_article;
		this.prix_vente = prix_vente;
		this.date_fin_enchere = date_fin_enchere;
		this.pseudo = pseudo;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getNo_utilisateur() {
		return no_utilisateur;
	}
	public void setNo_utilisateur(int no_utilisateur) {
		this.no_utilisateur = no_utilisateur;
	}
	public int getNo_categorie() {
		return no_categorie;
	}
	public void setNo_categorie(int no_categorie) {
		this.no_categorie = no_categorie;
	}
	public String getNom_article() {
		return nom_article;
	}
	public void setNom_article(String nom_article) {
		this.nom_article = nom_article;
	}
	public int getPrix_vente() {
		return prix_vente;
	}
	public void setPrix_vente(int prix_vente) {
		this.prix_vente = prix_vente;
	}
	public LocalDateTime getDate_fin_enchere() {
		return date_fin_enchere;
	}
	public void setDate_fin_enchere(LocalDateTime localDateTime) {
		this.date_fin_enchere = localDateTime;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	public int getNo_article() {
		return no_article;
	}
	public void setNo_article(int no_article) {
		this.no_article = no_article;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AfficheArticle [id=");
		builder.append(id);
		builder.append(", no_utilisateur=");
		builder.append(no_utilisateur);
		builder.append(", no_categorie=");
		builder.append(no_categorie);
		builder.append(", no_article=");
		builder.append(no_article);
		builder.append(", nom_article=");
		builder.append(nom_article);
		builder.append(", prix_vente=");
		builder.append(prix_vente);
		builder.append(", date_fin_enchere=");
		builder.append(date_fin_enchere);
		builder.append(", pseudo=");
		builder.append(pseudo);
		builder.append("]");
		return builder.toString();
	}
	
	
	
}
