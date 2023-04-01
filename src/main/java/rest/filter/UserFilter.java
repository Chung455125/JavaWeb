package rest.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet Filter implementation class UserFilter
 */
//@WebFilter("/rest/user/*")
public class UserFilter extends HttpFilter {

		@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {			
			// 過濾 _method
			String _method = req.getParameter("_method");
			final String http_method = _method == null ?req.getMethod() : _method.toUpperCase();
			
//			HttpServletRequestWrapper WrapperRequest = new HttpServletRequestWrapper(req) {
//				@Override
//				public String getMethod() {
//					return http_method;
//				}				
//			};
			GetMethodWrapper WrapperRequest = new GetMethodWrapper(req);
			WrapperRequest.set_method(http_method);			
			
			chain.doFilter(WrapperRequest, resp);
	}
		

}
