package logout;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogOut
 */
@WebServlet("/CommonLogout")
public class CommonLogout extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected  void doGet (HttpServletRequest request,
			HttpServletResponse response)throws IOException, ServletException
			{
			this.doPost(request, response);
			}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession(true);
	    session.invalidate();
	    RequestDispatcher dis = request.getRequestDispatcher("common/finish.jsp");
		dis.forward(request, response);
	}

}
