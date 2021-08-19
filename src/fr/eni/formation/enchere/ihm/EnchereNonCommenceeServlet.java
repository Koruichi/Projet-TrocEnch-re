package fr.eni.formation.enchere.ihm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EnchereNonCommenceeServlet
 */
@WebServlet("/EnchereNonCommenceeServlet")
public class EnchereNonCommenceeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String nextPage = "/WEB-INF/jsp/enchereNonCommencee.jsp";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EnchereNonCommenceeServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher(nextPage).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
