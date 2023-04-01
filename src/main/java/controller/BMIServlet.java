package controller;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.BMIService;

@WebServlet(value="/servlet/bmi")
public class BMIServlet extends HttpServlet{

	private void DoHandle(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//1. 確認編碼
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		//2. 取得參數
		String height = req.getParameter("height");
		String weight = req.getParameter("weight");
		
		//3. 建立BMIService
		BMIService bmiservice = new BMIService();
		//4. 使用 getBMI 方法
		String output = bmiservice.getBMI(height, weight);
		
		String str = new String("Hello JSP 2");
		
		//9. 建立分派器
		RequestDispatcher rd = req.getRequestDispatcher("/html/bmi_result.jsp");
		req.setAttribute("str", str);
		req.setAttribute("output", output);
		rd.forward(req, resp);
		
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DoHandle(req, resp);
	}


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DoHandle(req, resp);
	};
	
	
	
}
