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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Ejercicio4Servlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final String USERS = "users";
	private static final String KEY = "key";
	private static final String NAME = "name";
	private static final String AUTHENTICATED = "authenticated";
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
		super.init(config);
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
		String page = "";		

		boolean authenticated;
		HttpSession session = request.getSession();

		if (session.getAttribute(AUTHENTICATED) != null) {
			authenticated = (boolean) session.getAttribute(AUTHENTICATED);
		} else {
			authenticated = false;			
			page = LOGIN_JSP;

		}

		if (authenticated) {			
			page = LISTADO_JSP;

		}
		else {
			page = LOGIN_JSP;}

		
		config.getServletContext().getRequestDispatcher(page).forward(request, response);
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		String page = LISTADO_JSP;

		HttpSession session = request.getSession();

		String name = request.getParameter(NAME);
		String password = request.getParameter(KEY);

		if (name.equals("1") || password.equals("1")) {
			session.setAttribute(AUTHENTICATED, true);
			request.setAttribute(USERS, usersList);

		} else {

			session.setAttribute(AUTHENTICATED, false);
			page = ERROR_JSP;

		}

		config.getServletContext().getRequestDispatcher(page).forward(request, response);

	}

}