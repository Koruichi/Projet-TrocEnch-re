package fr.eni.formation.enchere.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AccueilConnecteServlet
 */
@WebServlet("/AccueilConnecteServlet")
public class AccueilConnecteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String nextPage = "/WEB-INF/jsp/lstEncheresConnecte.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AccueilConnecteServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("btnDeco") != null) {
			System.out.println("coucou");
		}
		
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
