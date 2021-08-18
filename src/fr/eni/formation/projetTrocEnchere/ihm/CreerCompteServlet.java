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
 * Servlet implementation class CreerCompteServlet
 */
@WebServlet("/CreerCompteServlet")
public class CreerCompteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String nextPage = "/WEB-INF/creerCompte.jsp";
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

		boolean isCree = false;
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
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(model);

			System.out.println(model.getUtilisateur().getMot_de_passe());
			System.out.println(request.getAttribute("confirmation"));
			
			try {
				
				if (manager.confirmMDP(model.getUtilisateur().getMot_de_passe(), request.getParameter("confirmation"))) {
					
					if (manager.isAlphaNum(model.getUtilisateur().getPseudo())){
						if (manager.isUnique(model.getUtilisateur().getPseudo()) && manager.isUnique(model.getUtilisateur().getEmail())) {
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
			
//			if (model.getUtilisateur().getMot_de_passe().equals(request.getAttribute("confirmation"))) {
//			
//				if(model.getUtilisateur().getPseudo().matches("[a-zA-Z0-9]*")) {
//					System.out.println("Votre pseudo est validé");
//				} else {
//					System.out.println("Le pseudo n'accepte que des caractères alphanumériques");
//				}
//				try {
//					manager.addUtilisateur(model.getUtilisateur());
//				} catch (BLLException e) {
//					e.printStackTrace();
//				}

				System.out.println("seksay mdp babay");
			} else  {
				throw new ServletException("mot de passe et confirmation non conforme");
			}

//			for (Utilisateur u : manager.getAllUtilisateur()) {
//				if (u.getPseudo().equals(model.getUtilisateur().getPseudo())) {
//					System.out.println("le pseudo est déjà pris");
//				}
//				if (u.getEmail().equals(model.getUtilisateur().getEmail())) {
//					System.out.println("l'email est déjà pris");
//				}
//
//			}

		//}
		request.getSession().setAttribute("model", model);
		doGet(request, response);
	
}

}