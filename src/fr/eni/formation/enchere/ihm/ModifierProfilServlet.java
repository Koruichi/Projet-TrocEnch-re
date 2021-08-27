package fr.eni.formation.enchere.ihm;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
 * Servlet implementation class ModifierProfilServlet
 */
@WebServlet("/ModifierProfilServlet")
public class ModifierProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private UtilisateurManager manager = UtilisateurManagerSingl.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ModifierProfilServlet() {
		super();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextPage = "/WEB-INF/jsp/modifierProfil.jsp";

		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nextPage = "/WEB-INF/jsp/modifierProfil.jsp";
		BLLException ex = new BLLException();
		Utilisateur u = (Utilisateur) request.getSession().getAttribute("user");
		if (request.getParameter("btnEnregistrer") != null) {

			u.setPseudo(request.getParameter("pseudo"));
			u.setNom(request.getParameter("nom"));
			u.setPrenom(request.getParameter("prenom"));
			u.setEmail(request.getParameter("email"));
			u.setTelephone(request.getParameter("telephone"));
			u.setRue(request.getParameter("rue"));
			u.setCode_postal(request.getParameter("code_postal"));
			u.setVille(request.getParameter("ville"));

			try {
				if (!"".equals(request.getParameter("mot_de_passe_actu"))) {

					if (manager.confirmMDP(request.getParameter("mot_de_passe_actu"), u.getMot_de_passe())) {

						if (!"".equals(request.getParameter("new_mot_de_passe"))
								&& !"".equals(request.getParameter("confirmation"))) {

							if (manager.confirmMDP(request.getParameter("new_mot_de_passe"),
									request.getParameter("confirmation"))) {
								u.setMot_de_passe(request.getParameter("new_mot_de_passe"));
								manager.updateUtilisateur(u);

							} else {
								
								request.setAttribute("message", "Nouveau mot de passe et confirmation non conforme.");
							}
						} else {
							request.setAttribute("message", "Veuillez entrer le nouveau mot de passe et la confirmation.");
						}
					} else {
						request.setAttribute("message", "Votre mot de passe actuel n'est pas bon !");
					}

				} else {
					manager.updateUtilisateur(u);
				}

			} catch (BLLException e) {
				request.setAttribute("erreurs", e.getMessages());
				nextPage = "/WEB-INF/jsp/modifierProfil.jsp";
			}

		}

		if (request.getParameter("btnSupprim") != null) {
			try {
				manager.deleteUtilisateur(u);
			} catch (BLLException e) {
				e.printStackTrace();
			}
			nextPage = "/DeconnexionServlet";
		}

		request.getRequestDispatcher(nextPage).forward(request, response);
	}
}
