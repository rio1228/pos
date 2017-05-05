package suggestion;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;

import myclass.WineCategory;

/**
 * Servlet implementation class ComprehensiveProposal
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/AllSuggestServlet" })
public class AllSuggestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	/**
	 * 目的：一番売れているワインの色を調べ、その属性を分析する
	 * １．一番売れている商品群を調べる
	 * ２．一番売れているカテゴリーを変数へ代入
	 * ３．その変数の詳細を分析し、どの属性(重さと味)が一番売れているか調べる
	 */

    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllSuggestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings({ "unchecked", "unused" })
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int red = 0,white = 0,rose = 0,spaW = 0,spaR = 0,other = 0,maxQuantity = 0,bestLiquors = 0,bestWeightFlavorCate = 0;
		int intFullSweet = 0,intFullSpicy = 0,intMidSweet = 0,intMidSpicy = 0,intLightSweet = 0,intLightSpicy =0;
		String maxLiquor = null,maxWeight = null,maxFlavor = null;
		ArrayList<Integer> arrayLiquor= new ArrayList<Integer>(),arrayDetail = new ArrayList<Integer>();

		HttpSession session = request.getSession(true);

		LinkedList<LinkedList<String>>  saleTbl =
				new LinkedList<LinkedList<String>>();
		saleTbl =  (LinkedList<LinkedList<String>>) session.getAttribute("saleTbl");//取れてる

		WineCategory wc = new WineCategory();
		/*WineCategory{redWine,whiteWine,rose,sparklingWhite,sparklingRed,other}*/
		arrayLiquor = wc.saleCate(saleTbl);
		red = arrayLiquor.get(0);
		white = arrayLiquor.get(1);
		rose = arrayLiquor.get(2);
		spaW = arrayLiquor.get(3);
		spaR = arrayLiquor.get(4);
		other = arrayLiquor.get(5);

		/*一番売れているワインのカテゴリーを変数へ代入する*/
		Collections.sort(arrayLiquor);
		/*一番売れているワインの色を取得*/
		bestLiquors = arrayLiquor.get(arrayLiquor.size()-1);
		/*一番売れている商品のリキュールIDを取得*/
		if(bestLiquors == red){
			maxLiquor ="1";
		}else if(bestLiquors == white){
			maxLiquor ="2";
		}else if(bestLiquors == rose){
			maxLiquor ="3";
		}else if(bestLiquors == spaW){
			maxLiquor ="4";
		}else if(bestLiquors == spaR){
			maxLiquor ="5";
		}else if(bestLiquors == other){
			maxLiquor ="6";
		}

		/**一番売れているワインの色の詳細分析*/
		 /* arrayLiquorの中身{intFullSweet,intFullSpicy,intMidSweet,intMidSpicy,intLightSweet,intLightSpicy}*/
		arrayDetail = wc.maxSaleQuantity(saleTbl,maxLiquor);
		intFullSweet = arrayDetail.get(0);
		intFullSpicy = arrayDetail.get(1);
		intMidSweet = arrayDetail.get(2);
		intMidSpicy = arrayDetail.get(3);
		intLightSweet = arrayDetail.get(4);
		intLightSpicy = arrayDetail.get(5);
		/*一番売れている商品群の要素を取得*/
		Collections.sort(arrayDetail);
		/*売り上げた商品をカテゴリー別に分ける*/
		/*このarrayDetailでとれた要素が店で一番売れている要素
		 * つまり、この要素と同じ要素を選べば今一番売れている商品郡を選択できる*/
		bestWeightFlavorCate = arrayDetail.get(arrayLiquor.size()-1);
		if(bestWeightFlavorCate == intFullSweet){
			maxWeight ="1";
			maxFlavor ="1";
		}else if(bestWeightFlavorCate == intFullSpicy){
			maxWeight ="1";
			maxFlavor ="2";
		}else if(bestWeightFlavorCate == intMidSweet){
			maxWeight ="2";
			maxFlavor ="1";
		}else if(bestWeightFlavorCate == intMidSpicy){
			maxWeight ="2";
			maxFlavor ="2";
		}else if(bestWeightFlavorCate == intLightSweet){
			maxWeight ="3";
			maxFlavor ="1";
		}else if(bestWeightFlavorCate == intLightSpicy){
			maxWeight ="3";
			maxFlavor ="2";
		}
		/*一番売れているワインの色、味、重さを要素として、データベース上の取り扱い商品を検索*/
		LinkedList<LinkedList<String>> productTbl = new LinkedList<LinkedList<String>>();
		LinkedList<LinkedList<String>> suggestionTbl = new LinkedList<LinkedList<String>>();
		productTbl = (LinkedList<LinkedList<String>>) session.getAttribute("wholesale_productTbl");
		for(int i= 0;i<productTbl.size();i++){
			if((productTbl.get(i).get(6)).equals(maxLiquor)&& (productTbl.get(i).get(7)).equals(maxFlavor)&& (productTbl.get(i).get(8)).equals(maxWeight)){
				LinkedList<String> rec = new LinkedList<String>();
				rec.add(productTbl.get(i).get(0));
				rec.add(productTbl.get(i).get(1));
				rec.add(productTbl.get(i).get(2));
				rec.add(productTbl.get(i).get(3));
				rec.add(productTbl.get(i).get(4));
				rec.add(productTbl.get(i).get(5));
				rec.add(productTbl.get(i).get(6));
				rec.add(productTbl.get(i).get(7));
				rec.add(productTbl.get(i).get(8));
				rec.add(productTbl.get(i).get(9));
				rec.add(productTbl.get(i).get(10));
				suggestionTbl.add(rec);
			}
		}
		LinkedList<LinkedList<String>> suggestCampanyTbl = new LinkedList<LinkedList<String>>();
		suggestCampanyTbl = (LinkedList<LinkedList<String>>) session.getAttribute("suggestProductTbl");
		String callback = request.getParameter("callback");//jsonp17....みたいな数字が入ってる
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		Gson gson = new Gson();
	    response.setHeader("Access-Control-Allow-Origin", "*");//これもないとダメかも
	    out.print(callback + "({\"suggestTable\":"+gson.toJson(suggestionTbl)+",");
	    out.print("\"suggestForModal\":"+gson.toJson(suggestCampanyTbl)+"})");
		out.close();
	}
}