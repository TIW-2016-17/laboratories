package es.uc3m.tiw.lab1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ejercicio4Servlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final String LOGIN_JSP = "/login.jsp";
	private static final String LISTADO_JSP = "/list.jsp";
	private static final String ERROR_JSP = "/error.jsp";
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
	private List<String> usersList;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {	
		this.config = config;
		usersList = new ArrayList<>();
		usersList.add("John");
		usersList.add("Elizabeth");
		usersList.add("Martha");
		usersList.add("Bill");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		config.getServletContext().getRequestDispatcher(LOGIN_JSP).forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("key");

		String pagina = "";

		if (name.equals("user1") || password.equals("password1")) {

			pagina = LISTADO_JSP;
			request.setAttribute("users", usersList);

		} else {
			pagina = ERROR_JSP;

		}
		config.getServletContext().getRequestDispatcher(pagina).forward(request, response);
	}

}