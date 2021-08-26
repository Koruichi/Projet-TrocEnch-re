package fr.eni.formation.enchere.dal.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import fr.eni.formation.enchere.bo.ArticleVendu;
import fr.eni.formation.enchere.bo.Categorie;
import fr.eni.formation.enchere.bo.Utilisateur;
import fr.eni.formation.enchere.dal.ArticleVenduDAO;
import fr.eni.formation.enchere.dal.DALException;
import fr.eni.formation.enchere.dto.AfficheArticle;

public class ArticleVenduDAOImpl implements ArticleVenduDAO {
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	LocalDate ld = LocalDate.parse("28/05/1973", formatter);

	private final String INSERT = "INSERT INTO articles_vendus (nom_article, description, date_debut_encheres, date_fin_encheres, prix_initial, prix_vente, no_utilisateur, no_categorie) VALUES(?,?,?,?,?,?,?,?)";
	private final String UPDATE = "UPDATE articles_vendus SET no_article=?, nom_article=?, description=?, date_debut_encheres=?, date_fin_encheres=?, prix_initial=?, prix_vente=?, no_categorie=?, WHERE no_article=?";
	private final String DELETE = "DELETE FROM articles_vendus where no_article = ?";
	private final String SELECTALL = "SELECT a.no_article, a.nom_article, a.description, a.date_debut_encheres, a.date_fin_encheres, a.prix_initial, a.prix_vente, a.no_utilisateur, a.no_categorie, u.pseudo, c.libelle FROM articles_vendus as a INNER JOIN utilisateurs as u ON u.no_utilisateur = a.no_utilisateur INNER JOIN categories as c ON c.no_categorie = a.no_categorie";
	private final String SELECTBYID = "SELECT a.nom_article, a.description, a.date_debut_encheres, "
			+ "a.date_fin_encheres, a.prix_initial, a.prix_vente, a.no_utilisateur, a.no_categorie, "
			+ "u.pseudo, u.nom, u.prenom, u.email FROM articles_vendus as a INNER JOIN utilisateurs as u ON "
			+ "u.no_utilisateur = a.no_utilisateur INNER JOIN categories as c ON c.no_categorie = a.no_categorie "
			+ "WHERE no_article =?";
	private final String SELECTALL_NC = "SELECT  a.no_article,a.nom_article,  a.date_fin_encheres,  "
			+ "a.prix_vente,u.no_utilisateur,  u.pseudo as pseudo FROM articles_vendus as a "
			+ "INNER JOIN utilisateurs as u ON u.no_utilisateur = a.no_utilisateur";
	private final String SELECTBYMOTCLE = "SELECT  a.nom_article,  a.date_fin_encheres,  a.prix_vente,u.no_utilisateur,  u.pseudo as pseudo FROM articles_vendus as a INNER JOIN utilisateurs as u ON u.no_utilisateur = a.no_utilisateur WHERE a.nom_article like ?";
	private final String SELECTBYCATEGORIE = "SELECT  a.nom_article,  a.date_fin_encheres,  a.prix_vente,u.no_utilisateur,  u.pseudo as pseudo, c.no_categorie FROM articles_vendus as a INNER JOIN utilisateurs as u ON u.no_utilisateur = a.no_utilisateur INNER JOIN categories as c ON a.no_categorie = c.no_categorie WHERE c.no_categorie = ?";
	private final String SELECTBYVENTE = "SELECT  a.nom_article,  a.date_fin_encheres,  a.prix_vente,u.no_utilisateur,  u.pseudo as pseudo FROM articles_vendus as a INNER JOIN utilisateurs as u ON u.no_utilisateur = a.no_utilisateur  WHERE a.no_utilisateur = ?";
	//private final String SELECTBYACHAT = "SELECT  a.nom_article,  a.date_fin_encheres,  a.prix_vente,u.no_utilisateur,  u.pseudo as pseudo, c.no_categorie FROM articles_vendus as a INNER JOIN utilisateurs as u ON u.no_utilisateur = a.no_utilisateur  WHERE c.no_categorie = ?";

	
	// private final String SELECTALL = "SELECT articles_vendus, no_article,
	// nom_article, description, date_debut_encheres, date_fin_encheres,
	// prix_initial, prix_vente, no_utilisateur, no_categorie, FROM
	// articles_vendus";
	// private final String SELECTBYID = "SELECT no_article, nom_article,
	// description, date_debut_encheres, date_fin_encheres, prix_initial,
	// prix_vente, no_utilisateur, no_categorie, FROM articles_vendus WHERE
	// no_article=?";
	// private final String SELECTBYUTILISATEUR

	public void insert(ArticleVendu articleVendu, Utilisateur u) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(INSERT, Statement.RETURN_GENERATED_KEYS);
			
			stmt.setString(1, articleVendu.getNom_article());
			stmt.setString(2, articleVendu.getDescription());
			stmt.setDate(3, java.sql.Date.valueOf(articleVendu.getDate_debut_enchere()));
			stmt.setDate(4, java.sql.Date.valueOf(articleVendu.getDate_fin_enchere()));
			stmt.setInt(5, articleVendu.getPrix_initial());
			stmt.setInt(6, articleVendu.getPrix_vente());
			stmt.setInt(7, u.getNo_utilisateur());
			stmt.setInt(8, articleVendu.getCategorie().getNo_categorie());
			int nb = stmt.executeUpdate();
			if (nb > 0) {
				ResultSet rs = stmt.getGeneratedKeys();
				if (rs.next()) {
					articleVendu.setNo_article(rs.getInt(1));
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL");
		}
	}

	public void delete(ArticleVendu articleVendu) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(DELETE);
			stmt.setInt(1, articleVendu.getNo_article());
			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL");
		}
	}

	public void update(ArticleVendu articleVendu, Utilisateur u) throws DALException {
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(UPDATE);
			stmt.setInt(1, articleVendu.getNo_article());
			stmt.setString(2, articleVendu.getNom_article());
			stmt.setString(3, articleVendu.getDescription());
			stmt.setDate(4, java.sql.Date.valueOf(articleVendu.getDate_debut_enchere()));
			stmt.setDate(5, java.sql.Date.valueOf(articleVendu.getDate_fin_enchere()));
			stmt.setInt(6, articleVendu.getPrix_initial());
			stmt.setInt(7, articleVendu.getPrix_vente());
			stmt.setInt(8, articleVendu.getCategorie().getNo_categorie());

			stmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL");
		}
	}

	public List<ArticleVendu> getAll(Utilisateur u) throws DALException {
		List<ArticleVendu> result = new ArrayList<ArticleVendu>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECTALL);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				ArticleVendu articleVendu = new ArticleVendu();
				articleVendu.setNo_article(rs.getInt("no_article"));
				articleVendu.setNom_article(rs.getString("nom_article"));
				articleVendu.setDescription(rs.getString("description"));
				java.sql.Date jsd = java.sql.Date.valueOf(rs.getString("date_debut_encheres"));
				LocalDate ld = jsd.toLocalDate();
				java.sql.Date jsd2 = java.sql.Date.valueOf(rs.getString("date_fin_encheres"));
				LocalDate ld2 = jsd.toLocalDate();
				articleVendu.setPrix_initial(rs.getInt("prix_initial"));
				articleVendu.setPrix_vente(rs.getInt("prix_vente"));
				u.setNo_utilisateur(rs.getInt("no_utilisateur"));
				articleVendu.getCategorie().setNo_categorie(rs.getInt("no_categorie"));
				result.add(articleVendu);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL");
		}
		return result;
	}

	public ArticleVendu getById(int id, Utilisateur u) throws DALException {
		ArticleVendu articleVendu = new ArticleVendu();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECTBYID);
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				articleVendu.setNo_article(rs.getInt("no_article"));
				articleVendu.setNom_article(rs.getString("nom_article"));
				articleVendu.setDescription(rs.getString("description"));
				java.sql.Date jsd = java.sql.Date.valueOf(rs.getString("date_debut_enchere"));
				LocalDate ld = jsd.toLocalDate();
				java.sql.Date jsd2 = java.sql.Date.valueOf(rs.getString("date_fin_enchere"));
				LocalDate ld2 = jsd.toLocalDate();
				articleVendu.setPrix_initial(rs.getInt("prix_initial"));
				articleVendu.setPrix_vente(rs.getInt("prix_vente"));
				u.setNo_utilisateur(rs.getInt("no_utilisateur"));
				articleVendu.getCategorie().setNo_categorie(rs.getInt("categorie"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL");
		}
		return articleVendu;
	}

	@Override
	public void delete(ArticleVendu articleVendu, Utilisateur u) throws DALException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<AfficheArticle> getAll() throws DALException {
		List<AfficheArticle> result = new ArrayList<AfficheArticle>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECTALL_NC);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				AfficheArticle article = new AfficheArticle();
				article.setNo_article(rs.getInt("no_article"));
				article.setNom_article(rs.getString("nom_article"));
				java.sql.Date jsd2 = java.sql.Date.valueOf(rs.getString("date_fin_encheres"));
				LocalDate ld =jsd2.toLocalDate();
				article.setDate_fin_enchere(ld);
				article.setPrix_vente(rs.getInt("prix_vente"));
				article.setNo_utilisateur(rs.getInt("no_utilisateur"));
				article.setPseudo(rs.getString("pseudo"));
				result.add(article);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DALException("Problème SQL");
		}
		return result;
	}

	@Override
	public List<AfficheArticle> selectByMotCle(String motCle) throws DALException {
		List<AfficheArticle> result = new ArrayList<AfficheArticle>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECTBYMOTCLE);
			stmt.setString(1, "%"+motCle.trim()+"%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				AfficheArticle article = new AfficheArticle();
				article.setNo_utilisateur(rs.getInt("no_utilisateur"));
				article.setNom_article(rs.getString("nom_article"));
				java.sql.Date jsd2 = java.sql.Date.valueOf(rs.getString("date_fin_encheres"));
				LocalDate ld =jsd2.toLocalDate();
				article.setDate_fin_enchere(ld);
				article.setPrix_vente(rs.getInt("prix_vente"));
				article.setPseudo(rs.getString("pseudo"));
				result.add(article);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;	

	}

	

	@Override
	public List<AfficheArticle> selectByCategorie(int categorie) throws DALException {
			List<AfficheArticle> cat = new ArrayList<AfficheArticle>();
			try (Connection con = ConnectionProvider.getConnection()) {
				PreparedStatement stmt = con.prepareStatement(SELECTBYCATEGORIE);
				stmt.setInt(1, categorie);
				ResultSet rs = stmt.executeQuery();
				while (rs.next()) {
					
					AfficheArticle article = new AfficheArticle();
					article.setNo_categorie(rs.getInt("no_categorie"));
					article.setNom_article(rs.getString("nom_article"));
					java.sql.Date jsd2 = java.sql.Date.valueOf(rs.getString("date_fin_encheres"));
					LocalDate ld =jsd2.toLocalDate();
					article.setDate_fin_enchere(ld);
					article.setPrix_vente(rs.getInt("prix_vente"));
					article.setNo_utilisateur(rs.getInt("no_utilisateur"));
					article.setPseudo(rs.getString("pseudo"));
					cat.add(article);

					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return cat;	
	}

	@Override
	public List<AfficheArticle> getVente(Utilisateur u) throws DALException {
		List<AfficheArticle> result = new ArrayList<AfficheArticle>();
		try (Connection con = ConnectionProvider.getConnection()) {
			PreparedStatement stmt = con.prepareStatement(SELECTBYVENTE);
			stmt.setInt(1,u.getNo_utilisateur());
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				
				AfficheArticle article = new AfficheArticle();
				article.setNo_utilisateur(rs.getInt("no_utilisateur"));
				article.setNom_article(rs.getString("nom_article"));
				java.sql.Date jsd2 = java.sql.Date.valueOf(rs.getString("date_fin_encheres"));
				LocalDate ld =jsd2.toLocalDate();
				article.setDate_fin_enchere(ld);
				article.setPrix_vente(rs.getInt("prix_vente"));
				article.setPseudo(rs.getString("pseudo"));
				result.add(article);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;	

	}

	@Override
	public List<AfficheArticle> getAchat(Utilisateur u) throws DALException {
		// TODO Auto-generated method stub
		return null;
	}

	

}
	