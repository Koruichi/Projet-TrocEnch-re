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
		String nextPage = "/WEB-INF/jsp/creerCompte.jsp";
		request.getRequestDispatcher(nextPage).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nextPage = "/WEB-INF/jsp/creerCompte.jsp";
		UtilisateurModel modelU = new UtilisateurModel();

		if (request.getParameter("btnCreer") != null) {

			modelU.setUtilisateur(new Utilisateur());
			modelU.getUtilisateur().setPseudo(request.getParameter("pseudo"));
			modelU.getUtilisateur().setNom(request.getParameter("nom"));
			modelU.getUtilisateur().setPrenom(request.getParameter("prenom"));
			modelU.getUtilisateur().setEmail(request.getParameter("email"));
			modelU.getUtilisateur().setTelephone(request.getParameter("telephone"));
			modelU.getUtilisateur().setRue(request.getParameter("rue"));
			modelU.getUtilisateur().setCode_postal(request.getParameter("code_postal"));
			modelU.getUtilisateur().setVille(request.getParameter("ville"));
			modelU.getUtilisateur().setMot_de_passe(request.getParameter("mot_de_passe"));
			modelU.getUtilisateur().setCredit(100);
			try {
				if (!"".equals(request.getParameter("confirmation"))) {
					if (!manager.confirmMDP(request.getParameter("mot_de_passe"),
							request.getParameter("confirmation"))) {
						request.setAttribute("message", "Le mot de passe et la confirmation doivent etre identique");
					}
				} else {
					request.setAttribute("message", "La confirmation est obligatoire");
				}
				try {
					modelU.setLstUtilisateur(manager.getAllUtilisateur());
					manager.addUtilisateur(modelU.getUtilisateur());
					nextPage = "/AccueilServlet";
				} catch (BLLException e) {
					request.setAttribute("erreurs", e.getMessages());
				}
			} catch (BLLException e) {

				e.printStackTrace();
			}
			request.setAttribute("modelU", modelU);
			request.getRequestDispatcher(nextPage).forward(request, response);

		}
	}
}