package register;

import java.io.IOException;
/*import java.io.PrintWriter;*/
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/*import com.google.gson.Gson;*/

import connect.ConnectMySQL;
import myclass.SqlPosSystem;

/**
 * Servlet implementation class Register2
 */
@WebServlet("/RegisterInsert")
public class RegisterInsert extends HttpServlet {//お会計後の会計情報の登録
	private static final long serialVersionUID = 1L;

	protected PreparedStatement ps = null;
	protected Connection con = null;
	final String[] ProductCodeJson = new String[10];

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterInsert() {     super();		}
    /*
     * やること
     * 1.会計した時の情報取得
     * 2.商品テーブル取得
     * 3.会計した時の情報取得時に取得した商品コードと商品テーブルの商品コード比較
     * 4.一致した場合、その商品コード連番を取得
     * 5.商品コード連番、数量、天候、性別、気温をデータベースに登録
     * */

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
		HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
   	    if(session == null){ session = request.getSession(true); }

   	    ConnectMySQL cd = new ConnectMySQL();//コンストラクタの呼び出し
   	    SqlPosSystem sps = new SqlPosSystem();

		String purchaise_day = null;
		int purchaiseday = 0;

		String sexParam = request.getParameter("sexJs");//性別
		String ageParam = request.getParameter("ageJs");//年齢層
		String tempParam = request.getParameter("tempJs");//気温
		String weatherParam = request.getParameter("weatherJs");//天気
		String campanyId = (String) session.getAttribute("campanyid");//会社ID取得

		//ArrayList<String>  productTbl = new ArrayList<String>();
		//productTbl = (ArrayList<String>) session.getAttribute("productCodeJson");//2.商品テーブル取得
		ArrayList<String>  quantityTbl = new ArrayList<String>();
		quantityTbl = (ArrayList<String>) session.getAttribute("QuantityJson");//2.数量テーブル取得
		System.out.println(sexParam);
		System.out.println(ageParam);
		System.out.println(tempParam);
		System.out.println(weatherParam);
		System.out.println(campanyId);
		//System.out.println(productTbl);
		System.out.println(quantityTbl);

		int j = 1;

		//現在日時を取得する
        Calendar c = Calendar.getInstance();
        //現在日時を文字列に変換
		String  sdf = new SimpleDateFormat("yyyyMMdd").format(c.getTime());//とれてる

		/*
		 * 売上日のシーケンス情報を検索
		 * 存在しなければ西暦＋○月○日＋１
		 * 存在すれば＋１してまた検索
		 * データベース接続するので、重くなる可能性ありなので、のちに修正必要あり
		 * */
		while(j != -1){
			purchaise_day = sdf+j;//売上日＋連番を設定
			boolean pd =sps.saleExist(purchaise_day);//存在しなければtrueただfalseになっている
			if(pd){
				purchaiseday = Integer.parseInt(purchaise_day);
				j=-1;
			}else{
				j++;//存在すれば、＋１してまたデータベース比較
			}
		}
	}//doPost
}
