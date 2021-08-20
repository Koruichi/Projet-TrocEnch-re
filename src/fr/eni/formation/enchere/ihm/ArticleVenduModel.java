package fr.eni.formation.enchere.ihm;

import java.util.List;

import fr.eni.formation.enchere.bo.ArticleVendu;

public class ArticleVenduModel {

	private ArticleVendu articleVendu;
	private List<ArticleVendu> lstArticleVendu;
	public ArticleVenduModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArticleVenduModel(ArticleVendu articleVendu, List<ArticleVendu> lstArticleVendu) {
		super();
		this.articleVendu = articleVendu;
		this.lstArticleVendu = lstArticleVendu;
	}
	public ArticleVendu getArticleVendu() {
		return articleVendu;
	}
	public void setArticleVendu(ArticleVendu articleVendu) {
		this.articleVendu = articleVendu;
	}
	public List<ArticleVendu> getLstArticleVendu() {
		return lstArticleVendu;
	}
	public void setLstArticleVendu(List<ArticleVendu> lstArticleVendu) {
		this.lstArticleVendu = lstArticleVendu;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ArticleVenduModel [articleVendu=");
		builder.append(articleVendu);
		builder.append(", lstArticleVendu=");
		builder.append(lstArticleVendu);
		builder.append("]");
		return builder.toString();
	}
	
	
}
