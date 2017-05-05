package analysis;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import connect.ConnectMySQL;

/**
 * Servlet implementation class AnalysisData
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/AnalysisData" })
public class AnalysisData extends HttpServlet {
	private static final long serialVersionUID = 1L;


	    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnalysisData() {
        super();
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
   	    if(session == null){
   	    	session = request.getSession(true);
   	    }
   	    ConnectMySQL cd= new ConnectMySQL();
		cd.getConnection();

		String campanyId = (String) session.getAttribute("campanyid");
		int campanyid = Integer.parseInt(campanyId);

		LinkedList<LinkedList<String>> saleTbl = new LinkedList<LinkedList<String>>();

		String sql = "SELECT CAMPANYID FROM CAMPANIES WHERE CAMPANYID ="+campanyid;

	    boolean ci =cd.isExist(sql);

	    if(ci){
			String sql1 = "SELECT SALES.PRODUCTID,LIQUORS.LIQUORID,QUANTITY,"
					+ "SEXID,LAYER_ID,WEATHER_ID,TEMPERATURE_ID FROM SALES,PRODUCTS,LIQUORS "
					+ "WHERE SALES.PRODUCTID = RETAIL_PRODUCT_TBL.PRODUCTID AND "
					+ "WHOLESALE_PRODUCT_TBL.LIQUORID = LIQUORS.LIQUORID AND SALES.RETAIL_ID ="+campanyid;
			saleTbl = cd.queryArrayLinked(sql1);

		    if(saleTbl!=null){//単価が取得できていれば
		    	session.setAttribute("saletbl",saleTbl);
		    }

	    }else{
	    	//もしcampanyidがなかったら、データが存在しませんっていうデータをここでセットする
	    }
	}
}
