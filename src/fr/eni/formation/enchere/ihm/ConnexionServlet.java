package fr.eni.formation.enchere.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.formation.enchere.bll.BLLException;
import fr.eni.formation.enchere.bll.UtilisateurManager;
import fr.eni.formation.enchere.bll.UtilisateurManagerSingl;
import fr.eni.formation.enchere.bo.Utilisateur;

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

		if (request.getParameter("btnCreerCompte") != null) {
			nextPage = "/CreerCompteServlet";
		}

		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		UtilisateurModel user = (UtilisateurModel) request.getSession().getAttribute("user");

		if (user == null) {
			user = new UtilisateurModel();
		}

		System.out.println(user);

		boolean isConnecte = false;

		if (request.getParameter("btnConnexion") != null) {

			if ("".equals(request.getParameter("identifiant")) || "".equals(request.getParameter("mot_de_passe"))) {
				request.setAttribute("message", "Vous devez entrer un identifiant et un mot de passe");
			} else {

				try {
					for (Utilisateur u : manager.getAllUtilisateur()) {
						if (u.getEmail().equals(request.getParameter("identifiant"))
								|| u.getPseudo().equals(request.getParameter("identifiant"))
										&& u.getMot_de_passe().equals(request.getParameter("mot_de_passe"))) {
							nextPage = "/AccueilConnecteServlet";
							isConnecte = true;

						}
					}
					if (!isConnecte) {
						request.setAttribute("message", "L'identifiant et le mot de passe sont invalides !");
					}

					if (isConnecte) {
						System.out.println(user);

					}

				} catch (BLLException e) {
					e.printStackTrace();
				}
			}
		}

		doGet(request, response);
	}

}
