package insert2;

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


@WebServlet("/CustomerInsert")
public class CustomerInsert extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	protected ConnectMySQL cd = new ConnectMySQL();
	SqlPosSystem sps = new SqlPosSystem();



	protected boolean member(String username)//memberメソッド
	{
		boolean ok = false;
		String sql = "SELECT * FROM PERSONALS WHERE username = "+username;
		ok = cd.isExist(sql);
		return ok;

	}

	//@SuppressWarnings("rawtypes")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		String username = request.getParameter("user");
		String name1 = request.getParameter("name1");
		String name2 = request.getParameter("name2");
		String name3 = request.getParameter("name3");
		String name4 = request.getParameter("name4");
		String pass = request.getParameter("pass");
		String postcode1 = request.getParameter("postcode1");
		String postcode2 = request.getParameter("postcode2");
		String ken = request.getParameter("prefecture");
		String city = request.getParameter("citytown");
		String lastaddress = request.getParameter("lastaddress");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String seibetsu = request.getParameter("sex");
		String meruado = request.getParameter("address");
		String denwa = request.getParameter("denwa");
		String kekkon = request.getParameter("partner");
		String syokusyu = request.getParameter("syokugyo");
		String nensyu = request.getParameter("nensyu");
		//String kyoumi = request.getParameter/*Values*/("syumi");

		//ArrayList<ArrayList> interest = new ArrayList<ArrayList>();

		int post1 = Integer.parseInt(postcode1);
		int post2 = Integer.parseInt(postcode2);
		int prefectureid = Integer.parseInt(ken);
		int yy = Integer.parseInt(year);
		int mm = Integer.parseInt(month);
		int dd = Integer.parseInt(day);
		int sex = Integer.parseInt(seibetsu);
		int partner = Integer.parseInt(kekkon);
		int ocupation = Integer.parseInt(syokusyu);
		int income = Integer.parseInt(nensyu);
		/*int interest[0] = Integer.parseInt(kyoumi);
		int interest[1] = Integer.parseInt(kyoumi[1]);
		int interest[2] = Integer.parseInt(kyoumi[2]);*/

		boolean check = member(username);//memberメソッドをオーバーライド
		if (check)
		{
			sps.userInsert(username,pass,name1,name2,name3,name4,post1,post2,prefectureid,city,lastaddress,yy,mm,dd,sex,meruado,denwa,partner,ocupation,income);

			sps.interest(username);




			/* 本来のアクセス先へ飛ばす */
			RequestDispatcher dis = request.getRequestDispatcher("thanks.jsp");
			dis.forward(request, response);
		}else{
			HttpSession session = request.getSession(true);
			/* 認証に失敗したら、ログイン画面に戻す */
			session.setAttribute("namecheck", "Not Auth");
			String login = (String)session.getAttribute("insertURI");
			response.sendRedirect(login);
		}
	}

}
