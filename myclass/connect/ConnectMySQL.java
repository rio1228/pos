package connect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ConnectMySQL{
	private static DataSource ds = null;
	private static Connection con = null;
	private PreparedStatement ps = null;
	protected static String jndiName = "java:comp/env/jdbc/";
	private Statement stmt;

	//* デフォルトコンストラクタ
	public ConnectMySQL(){}

	/*データベース名を固定で使うメソッド。変更する場合はpos_dbの部分を書き換える*/
	public Connection getConnection(){
		// データソースの取得

		try
		{
			InitialContext ctx = new InitialContext();//JNDIで検索をするときの出発点です。ファイルシステムに例えると、ルートディレクトリに相当します。Contextは、ディレクトリに相当します。
			ds = (DataSource)ctx.lookup(jndiName+"pos_db");//Contextのlookupというメソッドを使い、"java:comp/env/jdbc/pos_db"という名前からDataSource型のインスタンスを取得.この名前を「リソース参照名」といいます。Javaのコンポーネントは、"java:comp/env/"という文字列からはじまるリソース参照名を持つように定められています。
			con = ds.getConnection();//DataSource型のインスタンスからConnectionを取得しています。
			stmt = con.createStatement();
			return con;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//throw new IllegalStateException(e);
		}
		return con;
	}

	/*与えられたデータベース名を使うためのメソッド*/
	public Connection getConnection(String db_name){
		// データソースの取得
		try
		{
			InitialContext ctx = new InitialContext();//JNDIで検索をするときの出発点です。ファイルシステムに例えると、ルートディレクトリに相当します。Contextは、ディレクトリに相当します。
			ds = (DataSource)ctx.lookup(jndiName+db_name);
			con = (Connection) ds.getConnection();
			stmt = con.createStatement();
			return con;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			//throw new IllegalStateException(e);
		}
		return con;
	}

	/*isExsistメソッドは送られてきたSQL文の中身が存在すればfalseを返すメソッド
	 * 存在していなければtrue
	 * 存在していればfalse*/
	public boolean isExist(String sql){

		ResultSet rs = null;
		boolean result = false;
		try {
			rs = stmt.executeQuery(sql);
			if (rs.next()){}else{ result = true; }

		}catch (SQLException e){
			e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	/*isExsistメソッドは送られてきたSQL文の中身が存在しないか調べるメソッド
	 * 存在していればtrue
	 * 存在していなければfalse*/
	public boolean isNotExist(String sql){

		ResultSet rs = null;
		boolean result = false;

		try {
			rs = stmt.executeQuery(sql);
			if (rs.next()){
				result = true;
			}else{}
		}catch (SQLException e){
		    e.printStackTrace();
		}catch(NullPointerException e){
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	/*型を指定しないメソッド*/
	@SuppressWarnings("rawtypes")
	public ArrayList<ArrayList> queryArray(String sql) {

		ArrayList<ArrayList> aryTable = new ArrayList<ArrayList>();
		ResultSet rs = null;

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);//ここかな
			ResultSetMetaData rsmd = rs.getMetaData();//ここ後で調べる
			while( rs.next() )
			{
				// 1行のレコードを取得した
				ArrayList<String> rec = new ArrayList<String>();

				for(int i = 1; i <= rsmd.getColumnCount(); i++) {
					rec.add( rs.getString( i ) );
				}
				aryTable.add( rec );
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return aryTable;
	}

	/**
	 * SELECT文の実行を行う
	 *
	 * sql			SQL文字列
	 *
	 * return		LinkedList<LinkedList<String>>
	 */
	public LinkedList<LinkedList<String>> queryArrayLinked(String sql) {//LinkedListでString型の場合使用するメソッド

		//System.out.println(sql);
		LinkedList<LinkedList<String>> aryTable = new LinkedList<LinkedList<String>>();
		ResultSet rs = null;

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();//ここ後で調べる

			while(rs.next())
			{
				// 1行のレコードを取得した

				LinkedList<String> rec = new LinkedList<String>();
				for(int i = 1; i <= rsmd.getColumnCount(); i++) {
					rec.add( rs.getString( i ) );
				}
				aryTable.add( rec );
			}
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return aryTable;
	}

	/**
	 * SELECT文以外(INSERT, UPDATE, DELETE文など)の実行を行う
	 *
	 * sql			SQL文字列
	 *
	 * return		true / false
	 * @throws SQLException
	 */
	public boolean execute(String sql) throws SQLException {
		boolean result = false;
		con.setAutoCommit(false);

			try{
	        	stmt.executeUpdate(sql);
	            con.commit();
	            System.out.println("登録完了");
	            result = true;
	        }catch (SQLException e)
	   		{
	            con.rollback();
	            System.out.println("登録失敗：ロールバック実行");
	            e.printStackTrace();
	        }
		return result;
	}

	/*入力されたユーザーIDもしくはメールアドレスとパスワードが存在しているか*/
	/*@SuppressWarnings("rawtypes")
	public ArrayList<ArrayList> userExsist(String user, String password) {

		ConnectMySQL cd = new ConnectMySQL();
		cd.getConnection();
		ArrayList<ArrayList> aryTable = new ArrayList<ArrayList>();

		if(user != null && password != null){
			String sql = "SELECT RETAIL_ID,CAMPANY_NAME FROM RETAIL_INFO_TBL WHERE CAMPANY_NAME LIKE \""+user
					   + "\" OR MAILADDRESS LIKE \"" +user+ "\" && password = "+password;
			aryTable = cd.queryArray(sql);
		}
		return aryTable;
	}*/

	/*
	 * 登録している製品を取得するメソッド*/
	/*public LinkedList<LinkedList<String>> productExist(int retail_id){

		ConnectMySQL cd = new ConnectMySQL();
		LinkedList<LinkedList<String>> productTbl = new LinkedList<LinkedList<String>>();

		String sql = "SELECT RETAIL_PRODUCT_ID,PRODUCT_ID,PRODUCT_NAME,RETAIL_PRODUCTS_TBL.PRICE,CAPACITY,LIQUOR_ID,FLAVOR_ID,WEIGHT_ID,PRODUCT_IMG FROM RETAIL_PRODUCTS_TBL JOIN WHOLESALE_PRODUCT_TBL ON "
				+ "RETAIL_PRODUCTS_TBL.WHOLESALE_PRODUCT_SEQUENCE_ID = "
				+ "WHOLESALE_PRODUCT_TBL.WHOLESALE_PRODUCT_SEQUENCE_ID  WHERE RETAIL_ID = "+retail_id;

		productTbl = cd.queryArrayLinked(sql);
		return productTbl;
	}*/

	/*
	 * 売上情報を取得するメソッド*/
	/*public LinkedList<LinkedList<String>> saleTbl(int retail_id){
		ConnectMySQL cd = new ConnectMySQL();
		LinkedList<LinkedList<String>> saleTbl = new LinkedList<LinkedList<String>>();

		String sql = "SELECT * FROM SALE_TBL WHERE RETAIL_ID ="+retail_id;

		saleTbl = cd.queryArrayLinked(sql);

		return saleTbl;

	}*/

	public boolean saleExist(String purchaise_day){

		ConnectMySQL cd = new ConnectMySQL();
		cd.getConnection();//データベース接続
		boolean result = false;
		    String sql = "SELECT * FROM SALE_TBL WHERE sale_day_sequence_id ="+purchaise_day;

		result = cd.isExist(sql);
		return result;
	}

	/**
	 * 小売業を登録するためのメソッド。
	 *汎用性がないので、
	 *もっと汎用性のあるものにしたい
	 * @param campany_name
	 * @param account_exective
	 * @param account_exective2
	 * @param password
	 * @param zip
	 * @param prefecture_id
	 * @param city
	 * @param address
	 * @param mailaddress
	 * @param phonenumber
	 * @return
	 */
	public boolean executeInfo(String campany_name, String account_exective, String account_exective2, String password, String zip,
			int prefecture_id, String city, String address, String mailaddress, String phonenumber){

		boolean result = false;

		String sql = "INSERT INTO retail_info_tbl(campany_name,password,account_exective,account_exective2,"
				+ "zip,prefecture_id,city,address,phonenumber,mailaddress) "
				+ "VALUES("
				+ "?,?,?,?,?,"
				+ "?,?,?,?,?)";
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.setString(1, campany_name);
	   		ps.setString(2, password);
	   		ps.setString(3, account_exective);
	   		ps.setString(4, account_exective2);
	   		ps.setString(5,zip);
	   		ps.setInt(6,prefecture_id);
	   		ps.setString(7, city);
	   		ps.setString(8, address);
	   		ps.setString(9, phonenumber);
	   		ps.setString(10, mailaddress);
	   		ps.executeUpdate();

	   		try{
		   		con.commit();
	            System.out.println("登録完了");
	            result = true;
	   		}catch(SQLException e) {
				con.rollback();
				System.out.println("登録失敗：ロールバック実行");
				e.printStackTrace();
	   		}
		}catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 会計のために使用するメソッド
	 * @param purchaiseday
	 * @param retail_id
	 * @param retailProductCode
	 * @param quntity
	 * @param sex
	 * @param age
	 * @param temper
	 * @param weather
	 * @return
	 */
	public boolean registerInsert(int purchaiseday, int retail_id, int retailProductCode, int quntity, int sex, int age, int temper,int weather) {
		boolean result = false;
		ConnectMySQL cd= new ConnectMySQL();
		cd.getConnection();

		String sql = "INSERT INTO SALE_TBL(sale_day_sequence_id,retail_id,retail_product_sequence_id,quantity,"
				+ "sex_id,layer_id,weather_id,temperature_id) "
				+ "VALUES(?,?,?,?,?,?,?,?)";

		try {
			con.setAutoCommit(false);
	   		ps = con.prepareStatement(sql);
	   		ps.setInt(1, purchaiseday);
	   		ps.setInt(2, retail_id);
	   		ps.setInt(3, retailProductCode);
	   		ps.setInt(4, quntity);
	   		ps.setInt(5, sex);
	   		ps.setInt(6, age);
	   		ps.setInt(7, temper);
	   		ps.setInt(8, weather);
	   		ps.executeUpdate();

	   		try{
		   		con.commit();
	            System.out.println("登録完了");
	            result = true;
	   		}catch(SQLException e) {
				con.rollback();
				System.out.println("登録失敗：ロールバック実行");
				e.printStackTrace();
	   		}
		}catch(Exception e){
			e.printStackTrace();
		}
        return result;
	}

	/*小売が商品を登録するためのメソッド*/
	/*public boolean productInsert(String campanyname, int price2, int cost2, int liquor2) {

		boolean result = false;

		String sql = "INSERT INTO CAMPANIES(productname,price,cost,liquor) "
			+ "VALUES("
			+ "?,?,?,?)";
		try {
			con.setAutoCommit(false);
			ps = con.prepareStatement(sql);
			ps.setString(1, campanyname);
			ps.setInt(2, price2);
			ps.setInt(3, cost2);
			ps.setInt(4, liquor2);
			ps.executeUpdate();

	   		try{
		   		con.commit();
	            System.out.println("登録完了");
	            result = true;
	            return result;
	   		}catch(SQLException e) {
				con.rollback();
				System.out.println("登録失敗：ロールバック実行");
				e.printStackTrace();
				return result;
	   		}
		}catch(Exception e){
			e.printStackTrace();
			return result;
		}
	}*/

	/*ユーザー情報を登録するためのメソッド*/
	/*public boolean userInsert(String username, String pass, String name1, String name2, String name3, String name4, int post1,
			int post2, int prefectureid, String city, String lastaddress, int yy, int mm, int dd, int sex, String meruado,
			String denwa, int partner, int ocupation, int income) {

		boolean result = false;

		String sql = "INSERT INTO PERSONALS(userid,password,name1,name2,name3,name4,post1,post2,"
				+ "fromid,city,address,yy,mm,dd,sexid,mailaddress,phonenumber,"
				+ "partnerid,ocupationid,incomeid,interestid,time,lasttime) "
				+ "VALUES("
				+ "?,?,?,?,?,"
				+ "?,?,?,?,?,"
				+ "?,?,?,?,?,"
				+ "?,?,?,?,?,"
				+ "?,CURRENT_TIMESTAMP,CURRENT_TIMESTAMP)";

			try {
				con.setAutoCommit(false);

				ps = con.prepareStatement(sql);
				ps.setString(1, username);
				ps.setString(2, pass);
				ps.setString(3, name1);
				ps.setString(4, name2);
				ps.setString(5, name3);
				ps.setString(6, name4);
				ps.setInt(7, post1);
				ps.setInt(8, post2);
				ps.setInt(9, prefectureid);
				ps.setString(10, city);
				ps.setString(11, lastaddress);
				ps.setInt(12, yy);
				ps.setInt(13, mm);
				ps.setInt(14, dd);
				ps.setInt(15, sex);
				ps.setString(16, meruado);
				ps.setString(17, denwa);
				ps.setInt(18, partner);
				ps.setInt(19, ocupation);
				ps.setInt(20, income);
				/*ps.setInt(21, interest[0]);
				ps.setInt(22, interest2);
				ps.setInt(23, interest3);
				ps.executeUpdate();

				try{
			   		con.commit();
		            System.out.println("登録完了");
		            result = true;
		   		}catch(SQLException e) {
					con.rollback();
					System.out.println("登録失敗：ロールバック実行");
					e.printStackTrace();
		   		}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return result;
	}*/

	/*ユーザー情報の興味を登録するためのメソッド*/
	/*public boolean interest(String username) {
		boolean result = false;

		String sql = "INSERT INTO INTERESTS(interestid) VALUES(?,?,?,?,?)";

		try {
			con.setAutoCommit(false);

			ps = con.prepareStatement(sql);
	   		ps.setString(1, username);
	   		//ps2.setInt(1, interestid);
	   		//ps2.setInt(1, username);
	   		//ps2.setInt(1, username);
	   		ps.executeUpdate();
	   		try{
		   		con.commit();
	            System.out.println("登録完了");
	            result = true;
	   		}catch(SQLException e) {
				con.rollback();
				System.out.println("登録失敗：ロールバック実行");
				e.printStackTrace();
	   		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}*/

	/*ユーザー情報を更新するためのメソッド*/
	/*public boolean userUpdate(String newname, String newpass, String mailaddress, String phonenumber, int ocupation,
		String oldname, String oldpass) {
		boolean result = false;

		String sql = "UPDATE PERSONALS SET USERNAME=?,PASSWORD=?,"
				+ "MAILADDRESS=?,PHONENUMBER=?,OCUPATIONID=? WHERE USERNAME=? AND PASSWORD=?";
		try {
			con.setAutoCommit(false);

			ps = con.prepareStatement(sql);
	   		ps.setString(1, newname);
	   		ps.setString(2, newpass);
	   		ps.setString(3, mailaddress);
	   		ps.setString(4, phonenumber);
	   		ps.setInt(5, ocupation);
	   		ps.setString(6, oldname);
	   		ps.setString(7, oldpass);
	   		ps.executeUpdate();
			try{
		   		con.commit();
	            System.out.println("登録完了");
	            result = true;
	   		}catch(SQLException e) {
				con.rollback();
				System.out.println("登録失敗：ロールバック実行");
				e.printStackTrace();
	   		}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}*/



/**
 * データベース接続を切断する
 */
	public void close() {
		try {
			stmt.close();
			con.close();
			ps.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}catch(Exception e){
			e.printStackTrace();
		}
	}


}
