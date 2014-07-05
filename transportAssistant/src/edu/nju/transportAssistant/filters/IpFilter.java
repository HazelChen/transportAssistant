package edu.nju.transportAssistant.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

import edu.nju.transportAssistant.service.IPService;
import edu.nju.transportAssistant.service.ServiceFacade;

public class IpFilter extends HttpServlet implements Filter{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest)request;
		String ip = getIp(httpServletRequest);
		
		ServiceFacade facade = new ServiceFacade();
		String place = facade.getIpPlace(ip);
		
		HttpSession session = httpServletRequest.getSession();
		System.out.println(place);
		session.setAttribute("place", place);
    	chain.doFilter(request, response); 
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}
	
	private String getIp (HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");  
	      if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	         ip = request.getHeader("Proxy-Client-IP");  
	     }  
	      if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	         ip = request.getHeader("WL-Proxy-Client-IP");  
	      }  
	     if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {  
	          ip = request.getRemoteAddr();  
	     }
	     return ip;
	}

}
