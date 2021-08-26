package fr.eni.formation.enchere.ihm;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.formation.enchere.bll.ArticleVenduManager;
import fr.eni.formation.enchere.bll.ArticleVenduManagerSingl;
import fr.eni.formation.enchere.bll.BLLException;
import fr.eni.formation.enchere.bll.EnchereManagerSingl;
import fr.eni.formation.enchere.bll.IEnchereManager;
import fr.eni.formation.enchere.bll.UtilisateurManager;
import fr.eni.formation.enchere.bll.UtilisateurManagerSingl;
import fr.eni.formation.enchere.bo.ArticleVendu;
import fr.eni.formation.enchere.bo.Enchere;
import fr.eni.formation.enchere.bo.Utilisateur;

/**
 * Servlet implementation class EnchereServlet
 */
@WebServlet("/EnchereServlet")
public class EnchereServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	private IEnchereManager manager = EnchereManagerSingl.getInstance();
	private UtilisateurManager manager1 = UtilisateurManagerSingl.getInstance();
	private ArticleVenduManager manager2 = ArticleVenduManagerSingl.getInstance();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnchereServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		ArticleVendu a = new ArticleVendu();
		
		int id = Integer.parseInt(request.getParameter("id"));
		int idu = Integer.parseInt(request.getParameter("idu"));
		try {
			System.out.println(manager1.getUtilisateurById(idu));
			System.out.println(id);
			System.out.println(manager2.getById(id, manager1.getUtilisateurById(idu)));
			a = manager2.getById(id, manager1.getUtilisateurById(idu));
			request.setAttribute("a", a);
		} catch (BLLException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/WEB-INF/jsp/encherir.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Enchere enchere = new Enchere();
		
		Utilisateur u = (Utilisateur) request.getSession().getAttribute("user");
		
		if(request.getParameter("btnEncherir") != null) {
			if(Integer.parseInt(request.getParameter("proposition")) > Integer.parseInt(request.getParameter("meilleur_offre"))) {
				enchere.setMontant_enchere(Integer.parseInt(request.getParameter("proposition")));
				enchere.setDate_enchere(LocalDateTime.now());
			//	manager.updateEnchere(enchere, articleVendu, u);
			
			}
		}else {
			request.setAttribute("message", "Cette proposition est inferieur au meilleur offre");
	
	}
		request.getRequestDispatcher("/WEB-INF/jsp/encherir.jsp").forward(request, response);
	}
}	
	

	


