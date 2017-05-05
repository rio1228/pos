package myclass;

public class Check {

	public Check(){}


	public boolean isNull(String campanyname, String price, String cost, String liquor)//isNullメソッドは取得したパラメータの値が存在するか検査する
	{
		if (campanyname!=null&& price != null && cost != null&& liquor != null)//データが入力されていればtrueを返す
		{
		  return false;
		}
		else//データが入力されていなければfalseを返す
		{
		  return true;
		}
	}

	public boolean isResultCheck(String price) {
		if(price!= null) {
			return true;
		}else {
			return false;
		}
	}
}
