package controller;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(value="/servlet/person")
public class PersonServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 中文編碼配置
		req.setCharacterEncoding("UTF-8");
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		
		// 抓取表單資料
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String birth= req.getParameter("birth");
		String sex = req.getParameter("sex");
		String edu = req.getParameter("edu");
		String[] hobbies= req.getParameterValues("hobby");
		String memo = req.getParameter("memo");
		
		// 檢查表單參數資料...
		Map<String, String> errorMsg = new LinkedHashMap<String, String>();
		
		// 是否有輸入姓名？
		if(name == null || name.trim().length() == 0) {
			errorMsg.put("name", "姓名沒有填入");
		}
		
		// 是否有輸入年齡？
		if(age == null || age.trim().length() == 0) {
			errorMsg.put("age", "年齡沒有輸入");
		}
		
		// 是否有輸入生日？
		if(birth == null || birth.trim().length() == 0) {
			errorMsg.put("birth", "生日沒有輸入");
		}
		
		// 是否有選擇興趣？
		if(hobbies == null) {
			errorMsg.put("hobby", "興趣沒有選擇");
		}
		
		// 重導程序 - 建立分派器
		RequestDispatcher rd = req.getRequestDispatcher("/html/person_result.jsp");
		//帶入給 jsp 的資料
		req.setAttribute("name", name);
		req.setAttribute("age", age);
		req.setAttribute("birth", birth);
		req.setAttribute("sex", sex);
		req.setAttribute("edu", edu);
		req.setAttribute("hobbies", hobbies);
		req.setAttribute("memo", memo);
		req.setAttribute("errorMsg", errorMsg);
		//重導
		rd.forward(req, resp);
	}

}
