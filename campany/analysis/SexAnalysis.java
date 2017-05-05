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

import com.google.gson.Gson;

/**
 * Servlet implementation class SexAnalysis
 */
@WebServlet("/SexAnalysis")
public class SexAnalysis extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SexAnalysis() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		int redWineMan = 0;
		int whiteWineMan = 0;
		int sparklingWhiteMan = 0;
		int sparklingRedMan = 0;
		int roseMan = 0;
		int otherMan = 0;

		int redWineWoman = 0;
		int whiteWineWoman = 0;
		int sparklingWhiteWoman = 0;
		int sparklingRedWoman = 0;
		int roseWoman = 0;
		int otherWoman = 0;
		Long liquor_id =(long) 0;
		Long sex_id =(long) 0;
		HttpSession session = request.getSession(true);


		ArrayList<ArrayList<Long>>  saleTbl =
				new ArrayList<ArrayList<Long>>();
		saleTbl =  (ArrayList<ArrayList<Long>>) session.getAttribute("saletbl");//取れてる

		for(int i= 0;i<saleTbl.size();i++){
			sex_id = saleTbl.get(i).get(3);
			liquor_id = saleTbl.get(i).get(2);

			if(sex_id == 1){
				if(liquor_id == 1){
					redWineMan = (int) (redWineMan+saleTbl.get(i).get(2));
				}else if(liquor_id == 2){
					whiteWineMan=(int) (whiteWineMan+saleTbl.get(i).get(2));
				}else if(liquor_id == 3){
					roseMan = (int) (roseMan+saleTbl.get(i).get(2));
				}else if(liquor_id == 4){
					sparklingWhiteMan = (int) (sparklingWhiteMan+saleTbl.get(i).get(2));
				}else if(liquor_id == 5){
					sparklingRedMan = (int) (sparklingRedMan+saleTbl.get(i).get(2));
				}else if(liquor_id == 6){
					otherMan = (int) (otherMan+saleTbl.get(i).get(2));
				}else{

				}
			}else if(sex_id == 2){
				if(liquor_id == 1){
					redWineWoman = (int) (redWineWoman+saleTbl.get(i).get(2));
				}else if(liquor_id == 2){
					whiteWineWoman=(int) (whiteWineWoman+saleTbl.get(i).get(2));
				}else if(liquor_id == 3){
					roseWoman = (int) (roseWoman+saleTbl.get(i).get(2));
				}else if(liquor_id == 4){
					sparklingWhiteWoman = (int) (sparklingWhiteWoman+saleTbl.get(i).get(2));
				}else if(liquor_id == 5){
					sparklingRedWoman = (int) (sparklingRedWoman+saleTbl.get(i).get(2));
				}else if(liquor_id == 6){
					otherWoman = (int) (otherWoman+saleTbl.get(i).get(2));
				}else{

				}
			}
		}
		String graphValues ="{"
			+"\"config\": {"
		    +"\"title\": \"pie Chart\","
		    +"\"subTitle\": \"円(ドーナツ)チャート\","
		    +"\"type\": \"pie\","
		    +"\"useVal\": \"yes\","
		    +"\"pieDataIndex\": 1,"
		    +"\"colNameFont\": \"100 18px 'Arial'\","
		    +"\"pieRingWidth\": 80,"
		    +"\"pieHoleRadius\": 40,"
		    +"\"textColor\": \"#888\","
		    +"\"bg\": \"#fff\""
		    +"},"

			+"\"data\": ["
			+"[\"年度\",2016],"
			+" [\"赤ワイン\","+redWineMan+"],"
			+" [\"白ワイン\","+whiteWineMan+"],"
			+" [\"スパークリング白\","+ sparklingWhiteMan+"],"
			+" [\"スパークリング赤\","+sparklingRedMan+"],"
			+" [\"その他ワイン\","+otherMan+"],"
			+" [\"ロゼ\","+roseMan+"]"
			+"]"
			+"};";

		String graphValues2 ="{"
				+"\"config\": {"
			    +"\"title\": \"pie Chart\","
			    +"\"subTitle\": \"円(ドーナツ)チャート\","
			    +"\"type\": \"pie\","
			    +"\"useVal\": \"yes\","
			    +"\"pieDataIndex\": 1,"
			    +"\"colNameFont\": \"100 18px 'Arial'\","
			    +"\"pieRingWidth\": 80,"
			    +"\"pieHoleRadius\": 40,"
			    +"\"textColor\": \"#888\","
			    +"\"bg\": \"#fff\""
			    +"},"

				+"\"data\": ["
				+"[\"年度\",2016],"
				+" [\"赤ワイン\","+redWineWoman+"],"
				+" [\"白ワイン\","+whiteWineWoman+"],"
				+" [\"スパークリング白\","+ sparklingWhiteWoman+"],"
				+" [\"スパークリング赤\","+sparklingRedWoman+"],"
				+" [\"その他ワイン\","+otherWoman+"],"
				+" [\"ロゼ\","+roseWoman+"]"
				+"]"
				+"};";

		PrintWriter out = response.getWriter();
		Gson gson = new Gson();

	    String callback = request.getParameter("callback");//jsonp17....みたいな数字が入ってる
	    response.setHeader("Access-Control-Allow-Origin", "*");//これもないとダメかも

    	//String responseJson = "{\"data\":[" +graphValues+"]};";
    	//このcallbackを付けないと、JavaScript側でデータを受け取れない
    	out.println( callback + "(" + gson.toJson(graphValues) + ")");
    	out.println( callback + "(" + gson.toJson(graphValues2) + ")");
    	System.out.println(callback + "(" + gson.toJson(graphValues) + ")");
	}

}
