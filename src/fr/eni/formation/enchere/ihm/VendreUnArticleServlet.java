package fr.eni.formation.enchere.ihm;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.formation.enchere.bll.ArticleVenduManager;
import fr.eni.formation.enchere.bll.ArticleVenduManagerImpl;
import fr.eni.formation.enchere.bll.ArticleVenduManagerSingl;
import fr.eni.formation.enchere.bll.BLLException;
import fr.eni.formation.enchere.bll.CategorieSingl;
import fr.eni.formation.enchere.bll.ICategorie;
import fr.eni.formation.enchere.bll.RetraitManager;
import fr.eni.formation.enchere.bll.RetraitManagerSingl;
import fr.eni.formation.enchere.bo.ArticleVendu;
import fr.eni.formation.enchere.bo.Categorie;
import fr.eni.formation.enchere.bo.Utilisateur;

/**
 * Servlet implementation class VendreUnArticleServlet
 */
@WebServlet("/VendreUnArticleServlet")
public class VendreUnArticleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String nextPage = "";
	private ArticleVenduManager manager = ArticleVenduManagerSingl.getInstance();
	private RetraitManager manager2 = RetraitManagerSingl.getInstance();
	

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	String today = "22/01/2014";
	LocalDate ld = LocalDate.parse(today, dtf);

	public VendreUnArticleServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		nextPage = "/WEB-INF/jsp/vendreUnArticle.jsp";
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Utilisateur u = (Utilisateur) request.getSession().getAttribute("user");
		ArticleVenduModel modelAV = new ArticleVenduModel();
		RetraitModel modelR = new RetraitModel();
		
		System.out.println("coucou " +request.getParameter("date_fin_enchere"));
		if (request.getParameter("btnRec") != null) {
			
			modelAV.setArticleVendu(new ArticleVendu());
			modelAV.getArticleVendu().setNom_article(request.getParameter("nom_article"));
			modelAV.getArticleVendu().setDescription(request.getParameter("description"));
			modelAV.getArticleVendu().setDate_debut_enchere(LocalDateTime.now());
			try {
				modelAV.getArticleVendu().setDate_fin_enchere(LocalDateTime.parse(request.getParameter("date_fin_encheres")));
			} catch (Exception el) {
				// TODO Auto-generated catch block
				el.printStackTrace();
			}
			try {
				modelAV.getArticleVendu().setPrix_initial(Integer.parseInt(request.getParameter("prix_initial")));
			} catch (NumberFormatException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			modelAV.getArticleVendu().getCategorie().setNo_categorie(Integer.parseInt(request.getParameter("no_categorie")));
			
			modelR.getRetrait().setRue(request.getParameter("rue"));
			modelR.getRetrait().setCode_postal(request.getParameter("code_postal"));
			modelR.getRetrait().setVille(request.getParameter("ville"));
			
			try {
				manager.addArticle(modelAV.getArticleVendu(), u);
				manager2.addRetrait(modelR.getRetrait(), modelAV.getArticleVendu());
				nextPage = "/WEB-INF/jsp/enchereNonCommencee.jsp";
				modelAV.setLstArticleVendu(manager.getAllArticle(u));
			} catch (BLLException e) {
				request.setAttribute("erreurs", e.getMessages());
				nextPage = "/WEB-INF/jsp/vendreUnArticle.jsp";
			}

		}

		request.getRequestDispatcher(nextPage).forward(request, response);
	}

}
