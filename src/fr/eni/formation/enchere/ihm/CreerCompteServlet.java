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
 * Servlet implementation class CreerCompteServlet
 */
@WebServlet("/CreerCompteServlet")
public class CreerCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String nextPage = "/WEB-INF/jsp/creerCompte.jsp";
	private UtilisateurManager manager = UtilisateurManagerSingl.getInstance();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CreerCompteServlet() {
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

		UtilisateurModel user = (UtilisateurModel) request.getSession().getAttribute("user");

		if (user == null) {
			user = new UtilisateurModel();
		}

		if (request.getParameter("btnCreer") != null) {

			user.setUtilisateur(new Utilisateur());
			user.getUtilisateur().setPseudo(request.getParameter("pseudo"));
			user.getUtilisateur().setNom(request.getParameter("nom"));
			user.getUtilisateur().setPrenom(request.getParameter("prenom"));
			user.getUtilisateur().setEmail(request.getParameter("email"));
			user.getUtilisateur().setTelephone(request.getParameter("telephone"));
			user.getUtilisateur().setRue(request.getParameter("rue"));
			user.getUtilisateur().setCode_postal(request.getParameter("code_postal"));
			user.getUtilisateur().setVille(request.getParameter("ville"));
			user.getUtilisateur().setMot_de_passe(request.getParameter("mot_de_passe"));
			user.getUtilisateur().setCredit(100);

			try {
				user.setLstUtilisateur(manager.getAllUtilisateur());
			} catch (BLLException e) {
				e.printStackTrace();
			}

			try {

				if (manager.confirmMDP(user.getUtilisateur().getMot_de_passe(),
						request.getParameter("confirmation"))) {

					if (manager.isAlphaNum(user.getUtilisateur().getPseudo())) {

						if (manager.isUnique(user.getUtilisateur().getPseudo())
								&& manager.isUnique(user.getUtilisateur().getEmail())) {

							manager.addUtilisateur(user.getUtilisateur());

						} else {
							request.setAttribute("message", "Ce pseudo ou e-mail existe déjà");
						}

					} else {
						request.setAttribute("message", "Votre pseudo contient des caractères spéciaux interdits");
					}

				} else {
					request.setAttribute("message", "Mot de passe et confirmation non conforme");
				}

			} catch (BLLException e) {
				e.printStackTrace();
			}

			request.getSession().setAttribute("user", user);
			doGet(request, response);

		}
	}
}