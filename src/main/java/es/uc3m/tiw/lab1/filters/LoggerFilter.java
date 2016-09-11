package es.uc3m.tiw.lab1.filters;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Servlet Filter implementation class LoggerFilter
 */
@WebFilter("/*")
public class LoggerFilter implements Filter {
	
	private static final String SEPARATOR = " ";


    /**
     * Default constructor. 
     */
    public LoggerFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		StringBuilder sb = new StringBuilder();

		//date
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		sb.append(sdf.format(new Date()));
		sb.append(SEPARATOR);
		
		// ip
		sb.append(request.getRemoteAddr());
		sb.append(SEPARATOR);
		
		// protocol
		sb.append(((HttpServletRequest)request).getProtocol());
		sb.append(SEPARATOR);
		//method
		sb.append(((HttpServletRequest)request).getMethod());
		sb.append(SEPARATOR);
		// url	
		
		sb.append(request.getScheme());
		sb.append("://");
		sb.append(request.getServerName());		
		sb.append(request.getLocalPort());
		sb.append(((HttpServletRequest)request).getContextPath());				
		sb.append(((HttpServletRequest)request).getServletPath());				
		System.out.println(sb.toString());


		// pass the request along the filter chain
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
