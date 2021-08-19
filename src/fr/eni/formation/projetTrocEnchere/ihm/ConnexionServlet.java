package fr.eni.formation.projetTrocEnchere.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.formation.projetTrocEnchere.bll.BLLException;
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
	private String nextPage = "/WEB-INF/jsp/connexion.jsp";

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

		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		boolean isConnecte = false;
		
		if (request.getParameter("btnConnexion") != null) {
			request.setAttribute("identifiant", request.getParameter("identifiant"));
			request.setAttribute("mot_de_passe", request.getParameter("mot_de_passe"));

			if ("".equals(request.getAttribute("identifiant")) || "".equals(request.getAttribute("mot_de_passe"))) {
				request.setAttribute("message", "Vous devez entrer un identifiant et un mot de passe");
			} else {
				
				try {
					for (Utilisateur u : manager.getAllUtilisateur()) {
						if (u.getEmail().equals(request.getAttribute("identifiant"))
						 || u.getPseudo().equals(request.getAttribute("identifiant"))
						 && u.getMot_de_passe().equals(request.getAttribute("mot_de_passe"))) {
							nextPage = "/AccueilConnecteServlet";
							isConnecte = true;
						}
					}
					if (!isConnecte) {
						request.setAttribute("message", "L'identifiant et le mot de passe sont invalides !");
					}
					
				} catch (BLLException e) {
					e.printStackTrace();
				}
			}
		}

		if (request.getParameter("btnCreerCompte") != null) {
			nextPage = "/CreerCompteServlet";
		}

		doGet(request, response);
	}

}
