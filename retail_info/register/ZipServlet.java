package register;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

/**
 * Servlet implementation class ZipServlet
 */
@WebServlet(urlPatterns = { "/ZipServlet" })
public class ZipServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ZipServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
   	    if(session == null){
   	    	session = request.getSession(true);
   	    }
   	    String zip = (String)session.getAttribute("zip-code");
   	    System.out.println(zip);
   	    response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
	    String callback = request.getParameter("callback");//jsonp17....みたいな数字が入ってる
	    response.setHeader("Access-Control-Allow-Origin", "*");//これもないとダメかも
	    out.print(callback + "({\"zip\":"+gson.toJson(zip)+"})");
	    out.close();
	}

}
