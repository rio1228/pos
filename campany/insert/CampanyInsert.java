package insert;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connect.ConnectMySQL;


@WebServlet("/CampanyInsert")
public class CampanyInsert extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected boolean check = false;

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession(false);
   	    if(session == null){
   	    	session = request.getSession(true);
   	    }

		String campanyname = (String) session.getAttribute("campany");
		String name1 = (String) session.getAttribute("name1");
		String name2 = (String) session.getAttribute("name2");
		String pass = (String) session.getAttribute("pass");
		String zipcode = (String) session.getAttribute("zipcode");
		String ken = (String) session.getAttribute("prefecture");
		String city = (String) session.getAttribute("citytown");
		String lastaddress = (String) session.getAttribute("lastaddress");
		String meruado = (String) session.getAttribute("address");
		String denwa = (String) session.getAttribute("denwa");

		int prefcture = Integer.parseInt(ken);

		// データベースへ接続
		ConnectMySQL cd= new ConnectMySQL();
		cd.getConnection();

		String sql = "SELECT * FROM retail_info_tbl WHERE CAMPANY_NAME =\""+campanyname+"\"";
	    try {
			check = cd.isExist(sql);//isExist2メソッドをオーバーロード

		} catch(ClassCastException e){
			e.printStackTrace();
		} catch(Exception e){
			e.printStackTrace();
		}

		if (check)
		{
			try{

				boolean insertCheck = cd.executeInfo(campanyname,name1,name2,pass,zipcode,prefcture,city,lastaddress,meruado,denwa);

		   		if(insertCheck){
		   			/* 本来のアクセス先へ飛ばす */
					RequestDispatcher dis = request.getRequestDispatcher("common/thanks.jsp");
					dis.forward(request, response);
		   		}else{
		   			/* 認証に失敗したら、ログイン画面に戻す */
					session.setAttribute("namecheck", "Not Auth");
					String login = (String)session.getAttribute("insertURI");
					response.sendRedirect(login);
		   		}

			}catch(NullPointerException e){
				e.printStackTrace();
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				cd.close();
			}

		}else
		{
			/* 認証に失敗したら、ログイン画面に戻す */
			session.setAttribute("namecheck", "Not Auth");
			String login = (String)session.getAttribute("insertURI");
			response.sendRedirect(login);
		}
	}
}
