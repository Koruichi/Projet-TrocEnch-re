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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nextPage = "/WEB-INF/creerCompte.jsp";

		UtilisateurModel model = null;
		if (model == null) {
			model = new UtilisateurModel(new Utilisateur(), manager.getAllUtilisateur());
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
			manager.addUtilisateur(model.getUtilisateur());
			model.setLstUtilisateur(manager.getAllUtilisateur());
			
			System.out.println(model);
		
		System.out.println(model.getUtilisateur().getMot_de_passe());
		System.out.println(request.getAttribute("confirmation"));
		if(model.getUtilisateur().getMot_de_passe().equals(request.getAttribute("confirmation"))) {
			
			System.out.println("le mdp est bon");
		}else {
			System.out.println("le mdp est pourri!");
		}
		for (Utilisateur u : manager.getAllUtilisateur()) {
			if(u.getPseudo().equals(model.getUtilisateur().getPseudo())) {
				System.out.println("le pseudo est déjà pris");
			}
			if(u.getEmail().equals(model.getUtilisateur().getEmail())) {
				System.out.println("l'email est déjà pris");
			}
			
		}
		
		}
		request.getSession().setAttribute("model", model);
		request.getRequestDispatcher(nextPage).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
