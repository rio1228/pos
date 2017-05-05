package myclass;

public class CreateSQL {//sql文を生成するためのクラス

	/**
	 * SQL文を自動生成するメソッド
	 * where文はなし
	 */
	public CreateSQL() {
		// TODO 自動生成されたコンストラクター・スタブ
	}
	/**
	 *
	 * @param select_tbl
	 * @return
	 */
	public String selectAll_1(String select_tbl){
		String sql ="SELECT * FROM" + select_tbl;
		return sql;
	}
	/**
	 *
	 * @param column1
	 * @param select_tbl
	 * @return
	 */
	public String select1_1(String column1, String select_tbl){
		String sql ="SELECT"+column1+"FROM"+ select_tbl;
		return sql;
	}
	/**
	 *
	 * @param column1
	 * @param column2
	 * @param select_tbl
	 * @return
	 */
	public String select2_1(String column1,String column2, String select_tbl){
		String sql ="SELECT"+column1+","+column2+"FROM"+ select_tbl;
		return sql;
	}
	/**
	 *カラム名３つとテーブル名１つ
	 * @param column1
	 * @param column2
	 * @param column3
	 * @param select_tbl
	 * @return
	 */
	public String select3_1(String column1,String column2,String column3, String select_tbl){
		String sql ="SELECT"+column1+","+column2+","+column3+"FROM"+ select_tbl;
		return sql;
	}
	/**
	 *
	 * @param column1
	 * @param column2
	 * @param column3
	 * @param column4
	 * @param select_tbl
	 * @return
	 */
	public String select4_1(String column1,String column2,String column3,String column4, String select_tbl){
		String sql ="SELECT"+column1+","+column2+","+column3+","+column4+"FROM"+ select_tbl;
		return sql;
	}
	/**
	 *
	 * @param column1
	 * @param column2
	 * @param column3
	 * @param column4
	 * @param column5
	 * @param select_tbl
	 * @return
	 */
	public String select5_1(String column1,String column2,String column3,String column4,String column5, String select_tbl){
		String sql ="SELECT"+column1+","+column2+","+column3+","+column4+","+column5+"FROM"+ select_tbl;
		return sql;
	}
	/**
	 *
	 * @param tbl1
	 * @param tbl2
	 * @param id1
	 * @return String
	 */
	public String selectAll_2(String tbl1, String tbl2, String id){
		String sql ="SELECT * FROM"+ tbl1+"JOIN"+tbl2+"ON"+tbl1+"."+id+"="+tbl2+"."+id;
		return sql;
	}
	/**
	 *
	 * @param column1
	 * @param select_tbl1
	 * @param select_tbl2
	 * @return
	 */
	public String select1_2(String column1, String tbl1, String tbl2){
		String sql ="SELECT"+column1+"FROM"+ tbl1+","+tbl2;
		return sql;
	}
}
