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
 * Servlet implementation class RegisterHash
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/RegisterArray" })
public class RegisterArray extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/*流れ↓
	 * １．商品テーブルを取得
	 * ２．jqueryからのvalueを取得、抽出。
	 * ３．その値と商品テーブルの値を比較(for文)
	 * ４．その値が合っていれば、その価格を取得
	 * ５．java側へ返送
	 */


	final String[] ProductCodeJson = new String[10];
	private String callbackPrice = null;
	private int callBackPrice = 0;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterArray() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "unchecked" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(false);
   	    if(session == null){
   	    	session = request.getSession(true);
   	    }
		String[] productcode_pre = new String[10];
		//String[] productcode = new String[10];

		LinkedList<LinkedList<String>> productTbl =
				new LinkedList<LinkedList<String>>();

		productTbl =  (LinkedList<LinkedList<String>>) session.getAttribute("retail_productTbl");//１．商品テーブルを取得

		String prefix = "{\"message\":\"";//jquery側のメッセージの前半部分
		String suffix = "\"}";//

		for(int i = 0; i<ProductCodeJson.length;i++) {

			productcode_pre[i] = request.getParameter("requestJs"+i);//２．jquery側からのデータ取得
		}
		int i =0;
		while(i != -1){
			if(productcode_pre[i] != null){
				int _preIdx = productcode_pre[i].indexOf(prefix) + prefix.length();
				int _sufIdx = productcode_pre[i].indexOf(suffix);

			String productcode1 =productcode_pre[i].substring(_preIdx, _sufIdx);//指定した値と値の間の値を取得する(切り取り)
			int j = 0;

			while(j != -1){
				String retailProductCode = productTbl.get(j).get(1);//商品テーブルの商品コードを取得
				if(retailProductCode.equals(productcode1)){//３．商品テーブルの商品コードと選択した側の商品コードが正しいかどうか比較
					callbackPrice =  (productTbl.get(j).get(3));
					callBackPrice = Integer.parseInt(callbackPrice);
					j =-1;
				}//if(retailProductCode.equals(productcode1))
				else{
					j++;
				}
			}//while(j != -1)
				if(callbackPrice != null){
					response.setContentType("text/html; charset=UTF-8");
					PrintWriter out = response.getWriter();
					Gson gson = new Gson();
				    String callback = request.getParameter("callback");//jsonp17....みたいな数字が入ってる
				    response.setHeader("Access-Control-Allow-Origin", "*");//これもないとダメかも
				    out.println( callback + "(" + gson.toJson(callBackPrice) + ")");
				    i = -1;
				}else{}//if(callbackPrice != null)
			}else{
				i++;
			}//if(productcode_pre[i] != null)
		}
	}
}
