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
 * Servlet implementation class SaleAnalysisRod
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/SaleAnalysisRod" })
public class SaleAnalysisRod extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaleAnalysisRod() {
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
			liquor_id = saleTbl.get(i).get(2);

			if(liquor_id == 1){
				redWine = (int) (redWine+saleTbl.get(i).get(2));
			}else if(liquor_id == 2){
				whiteWine=(int) (whiteWine+saleTbl.get(i).get(2));
			}else if(liquor_id == 3){
				rose = (int) (rose+saleTbl.get(i).get(2));
			}else if(liquor_id == 4){
				sparklingWhite = (int) (sparklingWhite+saleTbl.get(i).get(2));
			}else if(liquor_id == 5){
				sparklingRed = (int) (sparklingRed+saleTbl.get(i).get(2));
			}else if(liquor_id == 6){
				other = (int) (other+saleTbl.get(i).get(2));
			}else{

			}
		}
		Object graphValues ="{"
			+"\"config\": {"
			+"\"title\": \"総合分析\","
			+"\"type\": \"bar\","
		    +"\"useVal\": \"yes\""
		    +"},"

			+"\"data\": ["
			+"[\"年度\",2016],"
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
	    response.setHeader("Access-Control-Allow-Origin", "*");//これもないとダメかも

    	out.println(graphValues);
    	out.close();
	}

}
