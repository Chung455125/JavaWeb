package rest.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

public class GetMethodWrapper extends HttpServletRequestWrapper{

	private String _method = new String();
	
	public GetMethodWrapper(HttpServletRequest request) {
		super(request);
		this._method = request.getMethod();
	}

	public void set_method(String _method) {
		this._method = _method;
	}

	@Override
	public String getMethod() {
		// TODO Auto-generated method stub
		return this._method;
	}
	
	

}
