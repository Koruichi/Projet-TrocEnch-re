package fr.eni.formation.projetTrocEnchere.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.formation.projetTrocEnchere.bll.UtilisateurManager;
import fr.eni.formation.projetTrocEnchere.bll.UtilisateurManagerSingl;
import fr.eni.formation.projetTrocEnchere.bo.Utilisateur;

/**
 * Servlet implementation class ConnexionServlet
 */
@WebServlet("/ConnexionServlet")
public class ConnexionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager manager = UtilisateurManagerSingl.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ConnexionServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nextPage = "/WEB-INF/connexion.jsp";

		UtilisateurModel model = null;
		if (model == null) {
			model = new UtilisateurModel(new Utilisateur(), manager.getAllUtilisateur());
		}
		if (request.getParameter("btnConnexion") != null) {
			model.getUtilisateur().setEmail(request.getParameter("identifiant"));
			model.getUtilisateur().setPseudo(request.getParameter("identifiant"));
			model.getUtilisateur().setMot_de_passe(request.getParameter("mot_de_passe"));
			System.out.println("je passe dans le if btnconnex");

			if ("".equals(request.getParameter("identifiant"))) {
				request.setAttribute("message", "Vous devez entrer un identifiant");
				System.out.println("je passe dans le if identifiant");

			} else {
				request.getSession().setAttribute("identifiant", request.getParameter("identifiant"));
				nextPage = "/AccueilServlet";
				System.out.println("je passe dans le else");
			}

		}

          if (request.getParameter("btnCreerCompte") != null) {
			nextPage = "/CreerCompteServlet";
		}
		// request.getSession().setAttribute("model", model);
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

}
