package es.uc3m.tiw.lab1.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class SecurityFilter
 */
@WebFilter("/list.jsp")
public class SecurityFilter implements Filter {
	
	private static final String AUTHENTICATED = "authenticated";
	private static final String LOGIN_JSP = "/login.jsp";



	/**
	 * Default constructor.
	 */
	public SecurityFilter() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		// we access the server using a session object casting
		// HttpServletRequest because we get only the ServletRequest
		HttpSession sesion = ((HttpServletRequest) request).getSession();
		// we search the  el token authenticated token 
		if (sesion.getAttribute(AUTHENTICATED) != null && (boolean) sesion.getAttribute(AUTHENTICATED)) {
			// pass the request along the filter chain
			chain.doFilter(request, response);
		} else {
			request.getRequestDispatcher(LOGIN_JSP).forward(request, response);
		}

		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
