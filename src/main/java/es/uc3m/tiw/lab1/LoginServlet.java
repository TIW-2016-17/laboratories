package es.uc3m.tiw.lab1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import es.uc3m.tiw.lab1.domains.User;

/**
 * Servlet implementation class Ejercicio4Servlet
 */
@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final String ERRORS_ATTRIBUTE = "errors";
	private static final String MESSAGE_ATTRIBUTE = "message";
	private static final String USER_ATTRIBUTE = "user";
	private static final String USERS_LIST = "users";
	private static final String USERS = "users";
	private static final String PASSWORD_PARAMETER = "key";
	private static final String NAME_PARAMETER = "name";
	private static final String AUTHENTICATED = "authenticated";
	private static final String LOGIN_JSP = "/login.jsp";
	private static final String LIST_JSP = "/list.jsp";
	private static final String ERROR_JSP = "/error.jsp";
	private static final long serialVersionUID = 1L;
	private ServletConfig config;
	//private List<String> usersList;
	
	private User user;
	private ArrayList<User> users;

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
		/*
		usersList = new ArrayList<>();
		usersList.add("John");
		usersList.add("Elizabeth");
		usersList.add("Martha");
		usersList.add("Bill");
		
		ServletContext context = config.getServletContext();
	    if (context.getAttribute(USERS_LIST) == null) {
	        context.setAttribute(USERS_LIST, usersList);
	    }*/
		 user = new User("1", "1", "1", "1");
		User user2 = new User("John", "Smith", "john", "12345678");
		User user3 = new User("Martha", "Jhones", "martha", "12345678");
		
		users = new ArrayList<User>();
		users.add(user);
		users.add(user2);
		users.add(user3);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		this.getServletContext().getRequestDispatcher(LOGIN_JSP).forward(request, response);

		/*String page = "";		

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
		
*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		String page = LOGIN_JSP;
		String message = "";

		HttpSession session = request.getSession();

		String name = request.getParameter(NAME_PARAMETER);
		String password = request.getParameter(PASSWORD_PARAMETER);

		User u = checkUser(name, password);
		Map<String, String>errors;

		
		if (name.equals("")|| password.equals("")) {
			errors = new HashMap<String, String>();
			if (name.equals("")) {
				errors.put("name", "Name cannot be empty");	
			}
			if (password.equals("")) {
				errors.put("key", "key cannot be empty<");
					
			}
			
			request.setAttribute(ERRORS_ATTRIBUTE, errors);
			page = LOGIN_JSP;
		}
		if (u != null){
		//if (name.equals("1") || password.equals("1")) {
			page = LIST_JSP;
			session.setAttribute(AUTHENTICATED, true);
			session.setAttribute(USER_ATTRIBUTE, u);
			request.setAttribute(USERS, users);

		} else {

			message = "User or password incorrects";
			request.setAttribute(MESSAGE_ATTRIBUTE, message);
			//session.setAttribute(AUTHENTICATED, false);
			//page = ERROR_JSP;

		}

		config.getServletContext().getRequestDispatcher(page).forward(request, response);

	}
	
	private User  checkUser(String user, String password) {
		User returnedUser = null;
		for (User u : users) {
			if (user.equals(u.getUser()) && password.equals(u.getPassword())){
				returnedUser = u;
				break;
			}
		}
		return returnedUser;
	}

}