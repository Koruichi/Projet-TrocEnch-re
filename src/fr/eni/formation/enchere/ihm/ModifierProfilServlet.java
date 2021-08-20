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
 * Servlet implementation class ModifierProfilServlet
 */
@WebServlet("/ModifierProfilServlet")
public class ModifierProfilServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String nextPage = "";
    private UtilisateurManager manager = UtilisateurManagerSingl.getInstance();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierProfilServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		nextPage = "/WEB-INF/jsp/modifierProfil.jsp";
		
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

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
			System.out.println(u);
			
			try {
				manager.updateUtilisateur(u);
			} catch (BLLException e) {
				e.printStackTrace();
			}
		}
		
		doGet(request, response);
	}

}
