package myInterface;

public interface IPosColumn {
	String db_name   ="pos_db";

	String age_tbl  ="age_layer_tbl";
	String age_id ="layer_id";
	String age_name ="layer_name";

	String interest_tbl ="interest_tbl";//user_id+cate_id

	String cate_tbl ="category_tbl";//興味カテゴリのまとめ口
	String cate_id ="category_id";

	String iM_tbl ="interest_mid_tbl";
	String iM_id ="interest_mid_id";
	String iM_name ="interest_mid_name";

	String iB_tbl="interest_big_tbl";
	String iB_id ="interest_big_id";
	String iB_name ="interest_big_name";

	String iS_tbl="interest_small_tbl";
	String iS_id ="interest_small_id";
	String iS_name ="interest_small_name";

	String cD_tbl ="charge_of_district_tbl";//各都道府県の市テーブル
	String cD_id ="charge_of_district_id";
	String cD_name ="charge_of_district_name";

	String country_tbl ="countrytbl";//ここcountry_tblに変更する
	String country_code ="country_code";

	String prefecture_tbl="prefectures";//prefecture_tbl
	String clm_name16 ="pos_db";
	String clm_name17 ="pos_db";

	String customer_tbl ="customer_tbl";//エンドユーザーテーブル
	String user_id ="user_id";
	String user_name ="user_name";
	String c_pass ="password";//小売、卸売と共通
	String name ="name";//エンドユーザーの名前
	String name2 ="name2";//エンドユーザーの名前（カタカナ）
	String c_zip ="zip";//小売、卸売と共通
	String city ="city";//市区町村のところ
	String lastAddress ="address";//番地のところ
	String year ="yy";//生年月日（年）
	String month ="mm";//生年月日（月）
	String day ="dd";//生年月日（日）
	String mailAddress ="mailaddress";//エンドユーザーの名前
	String phoneNumber ="phonenumber";//エンドユーザーの名前（カタカナ）

	String flavor_tbl ="flavor_tbl";//ワインの味カテゴリーテーブル
	String flavor_id ="flavor_id";
	String flavor_name ="flavor_name";

	String income_tbl ="income_tbl";//エンドユーザーの所得テーブル
	String income_id ="income_id";
	String income_name ="income_name";

	String lCtbl="liquor_categories_tbl";//liquor_category_tblに変更
	String liquor_id ="liquor_id";
	String liquor_name ="liquor_name";

	String ocupations_tbl="ocupations_tbl";//ocupation_tblに変更
	String ocupation_id ="ocupation_id";
	String ocupation_name ="ocupation_name";

	String order_tbl="order_tbl";//発注テーブル
	String order_id ="order_id";
	String quantity ="quantity";
	String order_day ="order_day";

	String partner_tbl="partners_tbl";//partner_tblに変更
	String partner_id ="partner_id";
	String partner_name ="partner_name";

	String rI_tbl="retail_info_tbl";
	String retail_id ="retail_id";
	String co_name ="campany_name";//卸売と共通
	String account_exective ="account_exective";//卸売と共通（名前）
	String account_exective2 ="account_exective2";//卸売と共通(カタカナ)

	String rP_tbl="retail_products_tbl";//小売業者が情報を登録するテーブル
	String rPSId ="retail_product_sequence_id";
	String rPId ="retail_product_id";
	String price ="price";

	String sale_tbl="sale_tbl";
	String sale_id ="pos_db";
	String sale_day_id ="sale_day_sequence_id";

	String sex_tbl="sex_tbl";
	String sex_id ="sex_id";
	String sex_name ="sex_name";

	String temper_tbl="temperatures";//temperature_tbl
	String temper_id ="temperature_id";
	String temper_name ="temperature_name";

	String weather_tbl="wenther";//weather_tbl
	String weather_id ="weather_id";
	String weather_name ="weather_name";

	String weight_tbl="weight_tbl";
	String weight_id ="weight_id";
	String weight_name ="weight_name";

	String winfo_tbl="wholesale_info_tbl";//卸売業者が情報を登録するテーブル
	String winfo_id ="wholesale_id";

	String wP_tbl="wholesale_product_tbl";
	String wPsId ="wholesale_product_sequence_id";
	String wPId ="wholesale_product_id";

	String wRegion_tbl="wholesale_region_tbl";//卸売が回れる地区を登録するテーブル

}
