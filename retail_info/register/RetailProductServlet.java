package register;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

/**
 * Servlet implementation class RetailProductServlet
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/RetailProductServlet" })
public class RetailProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetailProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession(false);
   	    if(session == null){
   	    	session = request.getSession(true);
   	    }
   	    try{
   	    	LinkedList<LinkedList<String>> productTbl =
   					new LinkedList<LinkedList<String>>();

   			productTbl =  (LinkedList<LinkedList<String>>) session.getAttribute("retail_productTbl");//１．商品テーブルを取得
   			String zip = (String)session.getAttribute("zip-code");//天候情報の為取得

   			response.setContentType("text/html; charset=UTF-8");
   			PrintWriter out = response.getWriter();
   			String callback = request.getParameter("callback");//jsonp17....みたいな数字が入ってる
   			Gson gson = new Gson();
   		    response.setHeader("Access-Control-Allow-Origin", "*");//これもないとダメかも
   		    out.print(callback + "({\"retailProductTable\":"+gson.toJson(productTbl)+",");
   		    out.print("\"zip\":"+gson.toJson(zip)+"})");
   		    out.close();
   	    }catch(Exception e){
   	    	e.printStackTrace();
   	    }
	}
}
