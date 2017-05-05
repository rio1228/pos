package update2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connect.ConnectMySQL;
import myclass.SqlPosSystem;


@WebServlet("/CustomerUpdate")
public class CustomerUpdate extends HttpServlet
{
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
	 	HttpSession session = request.getSession(true);

		SqlPosSystem sps = new SqlPosSystem();


		Object name =session.getAttribute("name");//セッションでユーザーIDをゲットする
		Object pass =session.getAttribute("pass");//セッションでいれたパスワードをゲットする

		Object name2 = request.getParameter("user");
		Object pass2 = request.getParameter("password");
		Object meruado = request.getParameter("address");
		Object denwa = request.getParameter("denwa");
		Object syokusyu = request.getParameter("syokugyo");

		String oldname = (String) name;
		String oldpass = (String) pass;

		String newname = (String) name2;
		String newpass = (String) pass2;
		String mailaddress = (String) meruado;
		String phonenumber = (String) denwa;
		String ocu = (String) syokusyu;

		int ocupation = Integer.parseInt(ocu);

		boolean check = member(newname);//memberメソッドをオーバーライド
		if (check)
		{
		boolean check2= sps.userUpdate(newname,newpass,mailaddress,phonenumber,ocupation,oldname,oldpass);

			if(check2){
				session.setAttribute("name", newname);
				session.setAttribute("pass", newpass);
				RequestDispatcher dis = request.getRequestDispatcher("/other/upfinish.jsp");
				dis.forward(request, response);
			}else{
				/* 認証に失敗したら、ログイン画面に戻す */
				session.setAttribute("exsist", "Not Auth");
				String update = (String)session.getAttribute("updateuri");
				response.sendRedirect(update);
			}
		}else{
			/* 認証に失敗したら、ログイン画面に戻す */
			session.setAttribute("exsist", "Not Auth");
			String update = (String)session.getAttribute("updateuri");
			response.sendRedirect(update);
		}
	}
	protected boolean member(String nextname)//memberメソッド
	{
		ConnectMySQL cd = new ConnectMySQL();
		boolean result = false;
		if (nextname == null || (nextname).length() == 0){}

		String sql = "SELECT * FROM PERSONALS WHERE username = "+nextname;

		result = cd.isExist(sql);

		return result;
	}
}

