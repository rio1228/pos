package analysis;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import myclass.WineCategory;

/**
 * Servlet implementation class SaleAnalysisTempServlet
 */
@WebServlet("/SaleAnalysisTempServlet")
public class SaleAnalysisTempServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaleAnalysisTempServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("unchecked")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int redWine = 0,
			whiteWine = 0,
			sparklingWhite = 0,
			sparklingRed = 0,
			rose = 0,
			other = 0;
		HttpSession session = request.getSession(true);

		LinkedList<LinkedList<String>>  saleTbl =
				new LinkedList<LinkedList<String>>();
		saleTbl =  (LinkedList<LinkedList<String>>) session.getAttribute("saleTbl");//取れてる
		ArrayList<Integer> saleCate = new ArrayList<Integer>();
		WineCategory wc = new WineCategory();
		saleCate = wc.saleCateOnlyTemp(saleTbl);
		redWine = saleCate.get(0);
		whiteWine = saleCate.get(1);
		rose = saleCate.get(2);
		sparklingWhite = saleCate.get(3);
		sparklingRed = saleCate.get(4);
		other = saleCate.get(5);

		Object graphValues = "{"
				+"\"config\": {"
			    +"\"title\": \"気温別分析\","
			    +"\"type\": \"pie\","
			    +"\"useVal\": \"yes\","
			    +"\"pieDataIndex\": 1,"
			    +"\"colNameFont\": \"100 18px 'Arial'\","
			    +"\"pieRingWidth\": 200,"
			    +"\"pieHoleRadius\": 40,"
			    +"\"width\": 620,"
			    +"\"textColor\": \"#888\","
			    +"\"bg\": \"black\""
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
	    //response.setHeader("Access-Control-Allow-Origin", "*");//これもないとダメかも

    	out.println(graphValues);
    	out.close();
	}
}