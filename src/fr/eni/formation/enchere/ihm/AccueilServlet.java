package fr.eni.formation.enchere.ihm;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.formation.enchere.bll.ArticleVenduManager;
import fr.eni.formation.enchere.bll.ArticleVenduManagerSingl;
import fr.eni.formation.enchere.bll.BLLException;
import fr.eni.formation.enchere.bll.CategorieSingl;
import fr.eni.formation.enchere.bll.ICategorie;
import fr.eni.formation.enchere.bo.Categorie;
import fr.eni.formation.enchere.bo.Utilisateur;
import fr.eni.formation.enchere.dto.AfficheArticle;

/**
 * Servlet implementation class AccueilServlet
 */
@WebServlet("/AccueilServlet")
public class AccueilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String nextPage = "/WEB-INF/jsp/accueil.jsp";

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AccueilServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ICategorie cat = CategorieSingl.getInstance();
		ArticleVenduManager am = ArticleVenduManagerSingl.getInstance();
		Utilisateur u = (Utilisateur) request.getSession().getAttribute("user");

		try {
			List<Categorie> list = cat.getAllCategorie();
			request.setAttribute("list", list);
		} catch (BLLException e1) {
			e1.printStackTrace();
		}

		try {
			List<AfficheArticle> lst = am.getAllArticle();
			request.setAttribute("lst", lst);
		} catch (BLLException e) {
			e.printStackTrace();
		}

		if (request.getParameter("btnRecherche") != null) {
			try {
				List<AfficheArticle> lst = new ArrayList<>();

				lst = am.selectByMotCle(request.getParameter("motRecherche"));

				if (Integer.parseInt(request.getParameter("categorie")) != 0) {
					lst = am.selectByCategorie(Integer.parseInt(request.getParameter("categorie")));
				}
//				if (u != null) {
//					lst = am.getVente(u);
//				}

				request.setAttribute("lst", lst);
			} catch (BLLException e) {
				e.printStackTrace();
			}
		}

		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
