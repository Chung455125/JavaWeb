package exchange.filter;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class ExchangeParamRequestWrapper extends HttpServletRequestWrapper{

	private Map<String, String[]> paramMap;	// 所有參數的 Map 集合
	
	public ExchangeParamRequestWrapper(HttpServletRequest request) {
		super(request);
		paramMap = request.getParameterMap();
	}
	
	public void setParameterMap(Map<String, String[]> paramMap) {
		this.paramMap = paramMap;
	}

	@Override
	public String getParameter(String name) {
		if(name.equals("amount") && 
				(super.getParameter("amount") == null || super.getParameter("amount").length() == 0)) {
			
			return "1";
		}else {
			return super.getParameter(name);
		}
	}
	
}
