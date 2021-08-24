package fr.eni.formation.enchere.dto;

import java.time.LocalDate;




public class AfficheArticle {
	private int id ;
	private String nom_article;
	private int prix_vente;
	private LocalDate date_fin_enchere;
	private String pseudo;
	
	
	public AfficheArticle() {
		super();
	}
	public AfficheArticle(int id, String nom_article, int prix_vente, LocalDate date_fin_enchere, String pseudo) {
		super();
		this.id = id;
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
	public LocalDate getDate_fin_enchere() {
		return date_fin_enchere;
	}
	public void setDate_fin_enchere(LocalDate date_fin_enchere) {
		this.date_fin_enchere = date_fin_enchere;
	}
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AfficheArticle [id=");
		builder.append(id);
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
