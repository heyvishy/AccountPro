package accountpro.security;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class SecurityFilter implements Filter {
	
	private static final Logger LOGGER = Logger.getLogger(SecurityFilter.class.getName());
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		LOGGER.info("inside destroy");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		LOGGER.info("inside doFilter");
		
		String  name = ((HttpServletRequest)request).getRequestURI();
		
		LOGGER.info("name "+ name);
		//RequestDispatcher rd = request.getRequestDispatcher("/login.htm");
		//rd.forward(request, response);

		if(!name.endsWith("/accountpro/login.htm"))
		{
			LOGGER.info("name does not ends with /accountpro/login.htm ::::"+ name);
			if(true){
				chain.doFilter(request, response);
			}else{
				RequestDispatcher rd = request.getRequestDispatcher("/login.htm");
				rd.forward(request, response);

			}
		}else{
			LOGGER.info("name ends with /accountpro/login.htm :::::"+ name);
			chain.doFilter(request, response);
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		LOGGER.info("inside init");
	}

}
