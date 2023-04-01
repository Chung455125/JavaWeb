package rest.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter("/rest/user/*")
public class CheckNameFilter extends HttpFilter{

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		if (req.getMethod().equals("POST")) {
			String str = (String) req.getParameter("name");

			for (int i = 0, size = str.length(); i < size; i++) {
				int num = str.charAt(i);
//				System.out.println(str.charAt(i));
				if (!(0x41 <= num && num <= 0x5A) && !(0x61 <= num && num <= 0x7A)
						&& !(0x4E00 <= num && num <= 0x9FA5)) {
//				System.out.println("不是英文字母或中文字");

					RequestDispatcher rd = req.getRequestDispatcher("/WEB-INF/view/rest/error.jsp");
					rd.forward(req, res);
					return;
				}
			}
			chain.doFilter(req, res);
		} else {
			chain.doFilter(req, res);
		}
	}
	
}
