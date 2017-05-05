package update;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connect.ConnectMySQL;

@WebServlet("/CampanyUpdate")
public class CampanyUpdate extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	ConnectMySQL cd = new ConnectMySQL();



	public void init(ServletConfig config) throws ServletException
	{

	}


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession(false);
   	    if(session == null){
   	    	session = request.getSession(true);
   	    }

		Object name =session.getAttribute("name");//セッションでユーザーIDをゲットする
		Object pass =session.getAttribute("pass");//セッションでいれたパスワードをゲットする

		Object name2 = request.getParameter("user");
		Object pass2 = request.getParameter("password");

		String oldname = (String) name;
		String oldpass = (String) pass;

		String newname = (String) name2;
		String newpass = (String) pass2;

		boolean check = cd.isExist(newname);//isExist2メソッドをオーバーロード
		if (check)
		{
			try{
				String sql = "UPDATE CAMPANIES SET USERNAME="+newname+",PASSWORD="+newpass+"WHERE USERNAME="+oldname+" AND PASSWORD="+oldpass;
				boolean check2 = cd.execute(sql);
				if(check2){
					session.setAttribute("name", newname);
					session.setAttribute("pass", newpass);
					RequestDispatcher dis = request.getRequestDispatcher("common/upfinish.jsp");
					dis.forward(request, response);
				}
			}catch(SQLException e){
				e.printStackTrace();
			}

		}else{
			/* 認証に失敗したら、ログイン画面に戻す */
			session.setAttribute("exsist", "Not Auth");
			String update = (String)session.getAttribute("updateuri");
			response.sendRedirect(update);
		}
	}
}

