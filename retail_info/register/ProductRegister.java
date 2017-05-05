package register;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connect.ConnectMySQL;
import myclass.Check;
import myclass.SqlPosSystem;

/**
 * Servlet implementation class ProductRegister
 */
@WebServlet("/ProductRegister")
public class ProductRegister extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException
	{

	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession(false);
   	    if(session == null){
   	    	session = request.getSession(true);
   	    }

		String campanyname = request.getParameter("productname");
		String price = request.getParameter("price");
		String cost = request.getParameter("cost");
		String liquor = request.getParameter("liquor");

		int price2 =Integer.parseInt(price);
		int cost2 =Integer.parseInt(cost);
		int liquor2 =Integer.parseInt(liquor);
		Check check = new Check();
		ConnectMySQL cd = new ConnectMySQL();
		SqlPosSystem sps = new SqlPosSystem();

		boolean check1 = cd.isExist(campanyname);//check1メソッドをオーバーライド
		if (check1)
		{
			boolean check2 = check.isNull(campanyname, price, cost, liquor);
			if(check2)
			{
				boolean check3 = sps.productInsert(campanyname,price2,cost2,liquor2);

				if(check3){
					/* 本来のアクセス先へ飛ばす */
					RequestDispatcher dis = request.getRequestDispatcher("common/thanks.jsp");
					dis.forward(request, response);
				}else {
					/* 認証に失敗したら、ログイン画面に戻す */
					session.setAttribute("namecheck", "Not Auth");
					String login = (String)session.getAttribute("insertURI");
					response.sendRedirect(login);
				}
			}else{

			}

		}else {
		/* 認証に失敗したら、ログイン画面に戻すこっちの処理ではパラメータの値がどれか入力されていないということを教える */
		session.setAttribute("namecheck", "Not Auth");
		String login = (String)session.getAttribute("insertURI");
		response.sendRedirect(login);
		}
	}
}
