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

		UtilisateurModel model = null;

		if (model == null) {
			try {
				model = new UtilisateurModel(new Utilisateur(), manager.getAllUtilisateur());
			} catch (BLLException e) {
				e.printStackTrace();
			}
		}

		if (request.getParameter("btnCreer") != null) {
			
			model.setUtilisateur(new Utilisateur());
			model.getUtilisateur().setPseudo(request.getParameter("pseudo"));
			model.getUtilisateur().setNom(request.getParameter("nom"));
			model.getUtilisateur().setPrenom(request.getParameter("prenom"));
			model.getUtilisateur().setEmail(request.getParameter("email"));
			model.getUtilisateur().setTelephone(request.getParameter("telephone"));
			model.getUtilisateur().setRue(request.getParameter("rue"));
			model.getUtilisateur().setCode_postal(request.getParameter("code_postal"));
			model.getUtilisateur().setVille(request.getParameter("ville"));
			model.getUtilisateur().setMot_de_passe(request.getParameter("mot_de_passe"));
			request.setAttribute("confirmation", request.getParameter("confirmation"));
			model.getUtilisateur().setCredit(100);
			
			try {
				model.setLstUtilisateur(manager.getAllUtilisateur());
			} catch (BLLException e) {
				e.printStackTrace();
			}

			try {

				if (manager.confirmMDP(model.getUtilisateur().getMot_de_passe(),
						request.getParameter("confirmation"))) {

					if (manager.isAlphaNum(model.getUtilisateur().getPseudo())) {

						if (manager.isUnique(model.getUtilisateur().getPseudo())
								&& manager.isUnique(model.getUtilisateur().getEmail())) {

							manager.addUtilisateur(model.getUtilisateur());

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

			request.getSession().setAttribute("model", model);
			doGet(request, response);

		}
	}
}