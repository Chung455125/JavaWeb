package spa.listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener()
public class SpaSessionListener implements HttpSessionListener{
	public static int TotalCount = 0;
	public static int CurrentCount = 0;

	// 當有新的 session 被創建時
	@Override
	public void sessionCreated(HttpSessionEvent se) {
		System.out.println("當有新的 session 被建立，ID : " + se.getSession().getId());
		TotalCount++;
		CurrentCount++;
	}

	// 當有 session 被銷毀時
	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		System.out.println("當有 session 被銷毀，ID : " + se.getSession().getId());
		CurrentCount--;
	}
	
	

}
