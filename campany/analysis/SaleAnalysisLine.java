package analysis;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SaleAnalysisLine
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/SaleAnalysisLine" })
public class SaleAnalysisLine extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaleAnalysisLine() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int redWine = 0;
		int whiteWine = 0;
		int sparklingWhite = 0;
		int sparklingRed = 0;
		int rose = 0;
		int other = 0;
		Long liquor_id =(long) 0;
		HttpSession session = request.getSession(true);


		ArrayList<ArrayList<Long>>  saleTbl =
				new ArrayList<ArrayList<Long>>();
		saleTbl =  (ArrayList<ArrayList<Long>>) session.getAttribute("saletbl");//取れてる

		for(int i= 0;i<saleTbl.size();i++){
			liquor_id = saleTbl.get(i).get(6);

			if(liquor_id == 1){
				redWine = (int) (redWine+saleTbl.get(i).get(6));
			}else if(liquor_id == 2){
				whiteWine=(int) (whiteWine+saleTbl.get(i).get(6));
			}else if(liquor_id == 3){
				rose = (int) (rose+saleTbl.get(i).get(6));
			}else if(liquor_id == 4){
				sparklingWhite = (int) (sparklingWhite+saleTbl.get(i).get(6));
			}else if(liquor_id == 5){
				sparklingRed = (int) (sparklingRed+saleTbl.get(i).get(6));
			}else if(liquor_id == 6){
				other = (int) (other+saleTbl.get(i).get(6));
			}else{

			}
		}
		Object graphValues =
			   "\"config\" :"
			  +"{"
		      +"\"type\" : \"line\"," //チャート種類
		      +"\"useVal\" : \"yes\"," //値を表示
		      +"\"colorSet\" : [\"red\"]," //データ列の色
		      +"\"minY\" : 0," //Y軸最小値
		      +"\"maxY\" : 100," //Y軸最大値
		      +"\"axisXLen\" : 10," //水平目盛線の本数
		      +"\"roundDigit\":0," // 軸目盛値の端数処理
		      +"\"xScaleFont\" : \"100 16px 'meiryo'\"," //水平軸目盛フォント
		      +"\"yScaleFont\" : \"100 16px 'meiryo'\"," //垂直軸目盛フォント
		      +"\"hanreiFont\" : \"bold 16px 'meiryo'\"," //凡例フォント
		      +"\"valFont\" : \"bold 16px 'meiryo'\"," //値フォント
		      +"\"paddingTop\" : \"25\"," //上パディング
		      +"\"paddingRight\" : \"140\"," //右パディング
		      +"\"useShadow\" : \"no\"," //影
		      +"\"height\" : \"300\"," //チャート高さ
		      +"\"width\" : \"900\"," //チャート幅
		      +"\"useMarker\" : \"arc\"," //マーカー種類
		      +"\"markerWidth\" : \"7\"," //マーカー大きさ
		      +"\"valYOffset\" : \"8\"," //値オフセット
		      +"\"valXOffset\" : \"-8\"," //値オフセット
		      +"\"bg\" : \"#fff\"," //背景色
		      +"\"textColor\" : \"#333\"," //テキスト色
		      +"\"lineWidth\" : \"1\"," //ラインの太さ
		      +"},"

		      +"\"data\" : ["
		      +"[\"日付\"],"
		      +"[\"売上A\"],"
		      +" [\"赤ワイン\","+redWine+"],"
			  +" [\"白ワイン\","+whiteWine+"],"
			  +" [\"スパークリング白\","+ sparklingWhite+"],"
			  +" [\"スパークリング赤\","+sparklingRed+"],"
		      +" [\"その他ワイン\","+other+"],"
			  +" [\"ロゼ\","+rose+"]"
		      +"]"
		      +"}";

		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
	    //response.setHeader("Access-Control-Allow-Origin", "*");//これもないとダメかも

    	out.println(graphValues);
    	out.close();
	}

}
