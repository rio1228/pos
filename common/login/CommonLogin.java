package login;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connect.ConnectMySQL;
import myclass.SqlPosSystem;

@WebServlet("/CommonLogin")
public class CommonLogin extends HttpServlet
{
	private static final long serialVersionUID = 1L;

	/**
	 * このプログラムでしていること
	 * 1.会員情報の検索
	 * 2.小売商品テーブルを取得
	 * 3.小売売上テーブルを取得
	 * 4.卸売商品テーブルを取得
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		    throws IOException, ServletException{
		HttpSession session = request.getSession(false);
		if(session == null){
	   	    session = request.getSession(true);
		}
	   	/* 認証に成功したら、statusをnullにする */
		session.setAttribute("status", "Not Auth");
		String login = (String)session.getAttribute("loginuri");
		RequestDispatcher dis = request.getRequestDispatcher("common/login.jsp");

		String campanyid = null;
		String campanyname = null;
		String zipCode = null;

		Object username = request.getParameter("user");
		Object pass = request.getParameter("pass");

		String user = (String) username;
		String password = (String) pass;

		// データベースへ接続
		ConnectMySQL cd= new ConnectMySQL();
		SqlPosSystem sps = new SqlPosSystem();
		try {
			@SuppressWarnings("rawtypes")
			ArrayList<ArrayList> userConfirmation = new ArrayList<ArrayList>();

			userConfirmation = sps.userExsist(user,password);//ここでnullpointExceptionになるのはデータベースが接続されていないから

			if(!userConfirmation.isEmpty()){
				campanyid = (String) userConfirmation.get(0).get(0);//会社id取得
				campanyname = (String) userConfirmation.get(0).get(1);//会社名取得
				zipCode = (String) userConfirmation.get(0).get(2);//郵便番号

			    int campanyId = Integer.parseInt(campanyid);

				/* 認証済みにセット */
				session.setAttribute("campanyid", campanyid);
				session.setAttribute("login", "OK");
				session.setAttribute("name", campanyname);
				session.setAttribute("pass", pass);
				session.setAttribute("zip-code", zipCode);
				session.setAttribute("status", null);

			    /*ここから登録された小売製品情報を取得する処理*/
			    LinkedList<LinkedList<String>>  retail_productTbl =
						new LinkedList<LinkedList<String>>();

			    retail_productTbl = sps.productExist(campanyId);

			    if(!retail_productTbl.isEmpty()){//単価が取得できていれば
			    	session.setAttribute("retail_productTbl",retail_productTbl);
			    }else{
			    	session.setAttribute("retail_productTbl",null);//売上情報がなければここに移動する
			    }
			    /*ここから登録された小売製品情報を取得する処理*/
			    LinkedList<LinkedList<String>>  wholesale_productTbl =
						new LinkedList<LinkedList<String>>();

			    wholesale_productTbl = sps.wholesale_productExist();

			    if(!retail_productTbl.isEmpty()){//単価が取得できていれば
			    	session.setAttribute("wholesale_productTbl",wholesale_productTbl);
			    }else{
			    	session.setAttribute("wholesale_productTbl",null);//売上情報がなければここに移動する
			    }
			    /*卸売業者の名前など取得する*/
			    LinkedList<LinkedList<String>>  suggestProductTbl =
						new LinkedList<LinkedList<String>>();

			    suggestProductTbl = sps.productForSuggest();

			    if(!retail_productTbl.isEmpty()){//単価が取得できていれば
			    	session.setAttribute("suggestProductTbl",suggestProductTbl);
			    }else{
			    	session.setAttribute("suggestProductTbl",null);//売上情報がなければここに移動する
			    }

			    /*ここから売り上げた製品情報の取得*/

			    LinkedList<LinkedList<String>>  saleTbl =//Longだといける
						new LinkedList<LinkedList<String>>();

			    if(campanyId != 0){

					saleTbl = sps.saleTbl(campanyId);
					System.out.println(saleTbl);

					if(!saleTbl.isEmpty()){//単価が取得できていれば
						session.setAttribute("saleTbl",saleTbl);
					}
			    }else{
			    	session.setAttribute("saletbl",null);//売上情報がなければここに移動する
			    }
			}else{//会員情報が存在しない場合、ここに飛ばされる
				dis.forward(request, response);
			}
		}catch(NullPointerException n){
			dis.forward(request, response);
		}catch(IndexOutOfBoundsException e){
			dis.forward(request, response);
		}catch(Exception e){
			e.printStackTrace();
			dis.forward(request, response);
		}finally{
			//データベースの切断
			cd.close();
			/* 本来のアクセス先へ飛ばす */
			response.sendRedirect(login);
   	    }
	}
}