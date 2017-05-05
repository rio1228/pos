package myclass;

import java.util.ArrayList;
import java.util.LinkedList;

public class WineCategory {
	public String red = null,
				  white = null,
				  spaRed = null,
				  spaWhite = null,
				  roses = null,
				  others = null,
				  liquorId = null,
				  bestLiquors = null,
				  strFullSweet = null,
				  strMidSweet = null,
				  strLightSweet = null,
				  strFullSpicy = null,
				  strMidSpicy = null,
				  strLightSpicy = null,
				  weatherId= null,
				  sexId = null,
				  human_layer = null,
				  tempId = null;

	public int redWine = 0,
			   whiteWine = 0,
			   sparklingWhite = 0,
			   sparklingRed = 0,
			   rose = 0,
			   other = 0,
			   bestLiquor = 0,
			   intFullSweet = 0,
			   intMidSweet = 0,
			   intLightSweet = 0,
			   intFullSpicy = 0,
			   intMidSpicy = 0,
			   intLightSpicy = 0;


	public WineCategory() {
	}
	/**
	 * 売上テーブルの商品群を区分けするメソッド。
	 * このメソッドによって赤～その他まで売上数を計算し、配列に格納する
	 * 中身の順番{redWine,whiteWine,rose,sparklingWhite,sparklingRed,other}
	 * @param saleTbl
	 * @return ArrayList<Integer>
	 */
	public  ArrayList<Integer> saleCate(LinkedList<LinkedList<String>> saleTbl){
		for(int i= 0;i<saleTbl.size();i++){
			liquorId = saleTbl.get(i).get(6);

			if("1".equals(liquorId)){/*赤*/
				red = saleTbl.get(i).get(9);
				redWine = redWine + (Integer.parseInt(red));
			}else if("2".equals(liquorId)){/*白*/
				white = saleTbl.get(i).get(9);
				whiteWine = whiteWine + (Integer.parseInt(white));
			}else if("3".equals(liquorId)){/*ロゼ*/
				roses = saleTbl.get(i).get(9);
				rose = rose + (Integer.parseInt(roses));
			}else if("4".equals(liquorId)){/*スパ白*/
				spaWhite = saleTbl.get(i).get(9);
				sparklingWhite = sparklingWhite + (Integer.parseInt(spaWhite));
			}else if("5".equals(liquorId)){/*スパ赤*/
				spaRed = saleTbl.get(i).get(9);
				sparklingRed = sparklingRed + (Integer.parseInt(spaRed));
			}else if("6".equals(liquorId)){/*その他*/
				others = saleTbl.get(i).get(9);
				other = other + (Integer.parseInt(others));
			}

		}
		ArrayList<Integer> arrayLiquor = new ArrayList<Integer>();
		arrayLiquor.add(redWine);
		arrayLiquor.add(whiteWine);
		arrayLiquor.add(rose);
		arrayLiquor.add(sparklingWhite);
		arrayLiquor.add(sparklingRed);
		arrayLiquor.add(other);
		return arrayLiquor;
	}
	/**
	 * 性別を元に売上テーブルの商品群を区分けするメソッド
	 * このメソッドによって赤～その他まで売上数を計算し、配列に格納する
	 * 中身の順番{redWine,whiteWine,rose,sparklingWhite,sparklingRed,other}
	 * @param saleTbl
	 * @return
	 */
	public  ArrayList<Integer> saleCateOnlySex(LinkedList<LinkedList<String>> saleTbl){
		for(int i= 0;i<saleTbl.size();i++){
			sexId = saleTbl.get(i).get(10);
			liquorId = saleTbl.get(i).get(6);

			if("1".equals(sexId)){
				if("1".equals(liquorId)){/*赤*/
					red = saleTbl.get(i).get(9);
					redWine = redWine + (Integer.parseInt(red));
				}else if("2".equals(liquorId)){/*白*/
					white = saleTbl.get(i).get(9);
					whiteWine = whiteWine + (Integer.parseInt(white));
				}else if("3".equals(liquorId)){/*ロゼ*/
					roses = saleTbl.get(i).get(9);
					rose = rose + (Integer.parseInt(roses));
				}else if("4".equals(liquorId)){/*スパ白*/
					spaWhite = saleTbl.get(i).get(9);
					sparklingWhite = sparklingWhite + (Integer.parseInt(spaWhite));
				}else if("5".equals(liquorId)){/*スパ赤*/
					spaRed = saleTbl.get(i).get(9);
					sparklingRed = sparklingRed + (Integer.parseInt(spaRed));
				}else if("6".equals(liquorId)){/*その他*/
					others = saleTbl.get(i).get(9);
					other = other + (Integer.parseInt(others));
				}
			}else if("2".equals(sexId)){
				if("1".equals(liquorId)){/*赤*/
					red = saleTbl.get(i).get(9);
					redWine = redWine + (Integer.parseInt(red));
				}else if("2".equals(liquorId)){/*白*/
					white = saleTbl.get(i).get(9);
					whiteWine = whiteWine + (Integer.parseInt(white));
				}else if("3".equals(liquorId)){/*ロゼ*/
					roses = saleTbl.get(i).get(9);
					rose = rose + (Integer.parseInt(roses));
				}else if("4".equals(liquorId)){/*スパ白*/
					spaWhite = saleTbl.get(i).get(9);
					sparklingWhite = sparklingWhite + (Integer.parseInt(spaWhite));
				}else if("5".equals(liquorId)){/*スパ赤*/
					spaRed = saleTbl.get(i).get(9);
					sparklingRed = sparklingRed + (Integer.parseInt(spaRed));
				}else if("6".equals(liquorId)){/*その他*/
					others = saleTbl.get(i).get(9);
					other = other + (Integer.parseInt(others));
				}
			}

		}
		ArrayList<Integer> arrayLiquor = new ArrayList<Integer>();
		arrayLiquor.add(redWine);
		arrayLiquor.add(whiteWine);
		arrayLiquor.add(rose);
		arrayLiquor.add(sparklingWhite);
		arrayLiquor.add(sparklingRed);
		arrayLiquor.add(other);
		return arrayLiquor;
	}
	/**
	 * 気温を元に売上テーブルの商品群を区分けするメソッド
	 * このメソッドによって赤～その他まで売上数を計算し、配列に格納する
	 * 中身の順番{redWine,whiteWine,rose,sparklingWhite,sparklingRed,other}
	 * @param saleTbl
	 * @return
	 */
	public  ArrayList<Integer> saleCateOnlyTemp(LinkedList<LinkedList<String>> saleTbl){
		for(int i= 0;i<saleTbl.size();i++){
			tempId = saleTbl.get(i).get(13);
			liquorId = saleTbl.get(i).get(6);

			if("1".equals(tempId)){
				if("1".equals(liquorId)){/*赤*/
					red = saleTbl.get(i).get(9);
					redWine = redWine + (Integer.parseInt(red));
				}else if("2".equals(liquorId)){/*白*/
					white = saleTbl.get(i).get(9);
					whiteWine = whiteWine + (Integer.parseInt(white));
				}else if("3".equals(liquorId)){/*ロゼ*/
					roses = saleTbl.get(i).get(9);
					rose = rose + (Integer.parseInt(roses));
				}else if("4".equals(liquorId)){/*スパ白*/
					spaWhite = saleTbl.get(i).get(9);
					sparklingWhite = sparklingWhite + (Integer.parseInt(spaWhite));
				}else if("5".equals(liquorId)){/*スパ赤*/
					spaRed = saleTbl.get(i).get(9);
					sparklingRed = sparklingRed + (Integer.parseInt(spaRed));
				}else if("6".equals(liquorId)){/*その他*/
					others = saleTbl.get(i).get(9);
					other = other + (Integer.parseInt(others));
				}
			}else if("2".equals(tempId)){
				if("1".equals(liquorId)){/*赤*/
					red = saleTbl.get(i).get(9);
					redWine = redWine + (Integer.parseInt(red));
				}else if("2".equals(liquorId)){/*白*/
					white = saleTbl.get(i).get(9);
					whiteWine = whiteWine + (Integer.parseInt(white));
				}else if("3".equals(liquorId)){/*ロゼ*/
					roses = saleTbl.get(i).get(9);
					rose = rose + (Integer.parseInt(roses));
				}else if("4".equals(liquorId)){/*スパ白*/
					spaWhite = saleTbl.get(i).get(9);
					sparklingWhite = sparklingWhite + (Integer.parseInt(spaWhite));
				}else if("5".equals(liquorId)){/*スパ赤*/
					spaRed = saleTbl.get(i).get(9);
					sparklingRed = sparklingRed + (Integer.parseInt(spaRed));
				}else if("6".equals(liquorId)){/*その他*/
					others = saleTbl.get(i).get(9);
					other = other + (Integer.parseInt(others));
				}
			}else if("3".equals(tempId)){
				if("1".equals(liquorId)){/*赤*/
					red = saleTbl.get(i).get(9);
					redWine = redWine + (Integer.parseInt(red));
				}else if("2".equals(liquorId)){/*白*/
					white = saleTbl.get(i).get(9);
					whiteWine = whiteWine + (Integer.parseInt(white));
				}else if("3".equals(liquorId)){/*ロゼ*/
					roses = saleTbl.get(i).get(9);
					rose = rose + (Integer.parseInt(roses));
				}else if("4".equals(liquorId)){/*スパ白*/
					spaWhite = saleTbl.get(i).get(9);
					sparklingWhite = sparklingWhite + (Integer.parseInt(spaWhite));
				}else if("5".equals(liquorId)){/*スパ赤*/
					spaRed = saleTbl.get(i).get(9);
					sparklingRed = sparklingRed + (Integer.parseInt(spaRed));
				}else if("6".equals(liquorId)){/*その他*/
					others = saleTbl.get(i).get(9);
					other = other + (Integer.parseInt(others));
				}
			}else if("4".equals(tempId)){
				if("1".equals(liquorId)){/*赤*/
					red = saleTbl.get(i).get(9);
					redWine = redWine + (Integer.parseInt(red));
				}else if("2".equals(liquorId)){/*白*/
					white = saleTbl.get(i).get(9);
					whiteWine = whiteWine + (Integer.parseInt(white));
				}else if("3".equals(liquorId)){/*ロゼ*/
					roses = saleTbl.get(i).get(9);
					rose = rose + (Integer.parseInt(roses));
				}else if("4".equals(liquorId)){/*スパ白*/
					spaWhite = saleTbl.get(i).get(9);
					sparklingWhite = sparklingWhite + (Integer.parseInt(spaWhite));
				}else if("5".equals(liquorId)){/*スパ赤*/
					spaRed = saleTbl.get(i).get(9);
					sparklingRed = sparklingRed + (Integer.parseInt(spaRed));
				}else if("6".equals(liquorId)){/*その他*/
					others = saleTbl.get(i).get(9);
					other = other + (Integer.parseInt(others));
				}
			}
		}
		ArrayList<Integer> arrayLiquor = new ArrayList<Integer>();
		arrayLiquor.add(redWine);
		arrayLiquor.add(whiteWine);
		arrayLiquor.add(rose);
		arrayLiquor.add(sparklingWhite);
		arrayLiquor.add(sparklingRed);
		arrayLiquor.add(other);
		return arrayLiquor;
	}
	/**
	 * 天候を元に売上テーブルの商品群を区分けするメソッド
	 * このメソッドによって赤～その他まで売上数を計算し、配列に格納する
	 * 中身の順番{redWine,whiteWine,rose,sparklingWhite,sparklingRed,other}
	 * 1.weatherIdに天候IDを格納
	 * 2.それを比較し、天候に振り分け（①晴れ②曇り③雨④雪）
	 * 3.その後天候別にリキュールIDを比較
	 * 4.それぞれの天候別で配列に格納し返す
	 * @param saleTbl
	 * @return
	 */
	public  ArrayList<Integer> saleCateOnlyWeather(LinkedList<LinkedList<String>> saleTbl){
		for(int i= 0;i<saleTbl.size();i++){
			weatherId = saleTbl.get(i).get(12);
			liquorId = saleTbl.get(i).get(6);

			if("1".equals(weatherId)){
				if("1".equals(liquorId)){/*赤*/
					red = saleTbl.get(i).get(9);
					redWine = redWine + (Integer.parseInt(red));
				}else if("2".equals(liquorId)){/*白*/
					white = saleTbl.get(i).get(9);
					whiteWine = whiteWine + (Integer.parseInt(white));
				}else if("3".equals(liquorId)){/*ロゼ*/
					roses = saleTbl.get(i).get(9);
					rose = rose + (Integer.parseInt(roses));
				}else if("4".equals(liquorId)){/*スパ白*/
					spaWhite = saleTbl.get(i).get(9);
					sparklingWhite = sparklingWhite + (Integer.parseInt(spaWhite));
				}else if("5".equals(liquorId)){/*スパ赤*/
					spaRed = saleTbl.get(i).get(9);
					sparklingRed = sparklingRed + (Integer.parseInt(spaRed));
				}else if("6".equals(liquorId)){/*その他*/
					others = saleTbl.get(i).get(9);
					other = other + (Integer.parseInt(others));
				}
			}else if("2".equals(weatherId)){
				if("1".equals(liquorId)){/*赤*/
					red = saleTbl.get(i).get(9);
					redWine = redWine + (Integer.parseInt(red));
				}else if("2".equals(liquorId)){/*白*/
					white = saleTbl.get(i).get(9);
					whiteWine = whiteWine + (Integer.parseInt(white));
				}else if("3".equals(liquorId)){/*ロゼ*/
					roses = saleTbl.get(i).get(9);
					rose = rose + (Integer.parseInt(roses));
				}else if("4".equals(liquorId)){/*スパ白*/
					spaWhite = saleTbl.get(i).get(9);
					sparklingWhite = sparklingWhite + (Integer.parseInt(spaWhite));
				}else if("5".equals(liquorId)){/*スパ赤*/
					spaRed = saleTbl.get(i).get(9);
					sparklingRed = sparklingRed + (Integer.parseInt(spaRed));
				}else if("6".equals(liquorId)){/*その他*/
					others = saleTbl.get(i).get(9);
					other = other + (Integer.parseInt(others));
				}
			}else if("3".equals(weatherId)){
				if("1".equals(liquorId)){/*赤*/
					red = saleTbl.get(i).get(9);
					redWine = redWine + (Integer.parseInt(red));
				}else if("2".equals(liquorId)){/*白*/
					white = saleTbl.get(i).get(9);
					whiteWine = whiteWine + (Integer.parseInt(white));
				}else if("3".equals(liquorId)){/*ロゼ*/
					roses = saleTbl.get(i).get(9);
					rose = rose + (Integer.parseInt(roses));
				}else if("4".equals(liquorId)){/*スパ白*/
					spaWhite = saleTbl.get(i).get(9);
					sparklingWhite = sparklingWhite + (Integer.parseInt(spaWhite));
				}else if("5".equals(liquorId)){/*スパ赤*/
					spaRed = saleTbl.get(i).get(9);
					sparklingRed = sparklingRed + (Integer.parseInt(spaRed));
				}else if("6".equals(liquorId)){/*その他*/
					others = saleTbl.get(i).get(9);
					other = other + (Integer.parseInt(others));
				}
			}else if("4".equals(weatherId)){
				if("1".equals(liquorId)){/*赤*/
					red = saleTbl.get(i).get(9);
					redWine = redWine + (Integer.parseInt(red));
				}else if("2".equals(liquorId)){/*白*/
					white = saleTbl.get(i).get(9);
					whiteWine = whiteWine + (Integer.parseInt(white));
				}else if("3".equals(liquorId)){/*ロゼ*/
					roses = saleTbl.get(i).get(9);
					rose = rose + (Integer.parseInt(roses));
				}else if("4".equals(liquorId)){/*スパ白*/
					spaWhite = saleTbl.get(i).get(9);
					sparklingWhite = sparklingWhite + (Integer.parseInt(spaWhite));
				}else if("5".equals(liquorId)){/*スパ赤*/
					spaRed = saleTbl.get(i).get(9);
					sparklingRed = sparklingRed + (Integer.parseInt(spaRed));
				}else if("6".equals(liquorId)){/*その他*/
					others = saleTbl.get(i).get(9);
					other = other + (Integer.parseInt(others));
				}
			}
		}
		ArrayList<Integer> arrayLiquor = new ArrayList<Integer>();
		arrayLiquor.add(redWine);
		arrayLiquor.add(whiteWine);
		arrayLiquor.add(rose);
		arrayLiquor.add(sparklingWhite);
		arrayLiquor.add(sparklingRed);
		arrayLiquor.add(other);
		return arrayLiquor;
	}
	/**
	 * 年代層を元に売上テーブルの商品群を区分けするメソッド
	 * このメソッドによって赤～その他まで売上数を計算し、配列に格納する
	 * 中身の順番{redWine,whiteWine,rose,sparklingWhite,sparklingRed,other}
	 * @param saleTbl
	 * @return
	 */
	public  ArrayList<Integer> saleCateOnlyHuman(LinkedList<LinkedList<String>> saleTbl){
		for(int i= 0;i<saleTbl.size();i++){
			liquorId = saleTbl.get(i).get(11);

			if("1".equals(liquorId)){/*赤*/
				red = saleTbl.get(i).get(9);
				redWine = redWine + (Integer.parseInt(red));
			}else if("2".equals(liquorId)){/*白*/
				white = saleTbl.get(i).get(9);
				whiteWine = whiteWine + (Integer.parseInt(white));
			}else if("3".equals(liquorId)){/*ロゼ*/
				roses = saleTbl.get(i).get(9);
				rose = rose + (Integer.parseInt(roses));
			}else if("4".equals(liquorId)){/*スパ白*/
				spaWhite = saleTbl.get(i).get(9);
				sparklingWhite = sparklingWhite + (Integer.parseInt(spaWhite));
			}else if("5".equals(liquorId)){/*スパ赤*/
				spaRed = saleTbl.get(i).get(9);
				sparklingRed = sparklingRed + (Integer.parseInt(spaRed));
			}else if("6".equals(liquorId)){/*その他*/
				others = saleTbl.get(i).get(9);
				other = other + (Integer.parseInt(others));
			}

		}
		ArrayList<Integer> arrayLiquor = new ArrayList<Integer>();
		arrayLiquor.add(redWine);
		arrayLiquor.add(whiteWine);
		arrayLiquor.add(rose);
		arrayLiquor.add(sparklingWhite);
		arrayLiquor.add(sparklingRed);
		arrayLiquor.add(other);
		return arrayLiquor;
	}
	/**
	 * 売上テーブルからワインの重さと味のカテゴリーで区分け
	 * 中身の順番
	 * {intFullSweet,intFullSpicy,intMidSweet,intMidSpicy,intLightSweet,intLightSpicy}
	 * @param saleTbl
	 * @param kindLiquor
	 * @return ArrayList<Integer> arrayLiquor
	 */
	public ArrayList<Integer> maxSaleQuantity(LinkedList<LinkedList<String>> saleTbl, String kindLiquor) {
		for(int i= 0;i<saleTbl.size();i++){
			liquorId = saleTbl.get(i).get(6);
			String flavor = saleTbl.get(i).get(7);
			String weight = saleTbl.get(i).get(8);

			if(kindLiquor.equals(liquorId)){
				if("1".equals(weight)){
					if("1".equals(flavor)){
						strFullSweet = saleTbl.get(i).get(9);
						intFullSweet = intFullSweet + (Integer.parseInt(strFullSweet));
					}else if("2".equals(flavor)){
						strFullSpicy = saleTbl.get(i).get(9);
						intFullSpicy = intFullSpicy + (Integer.parseInt(strFullSpicy));
					}
				}else if("2".equals(weight)){
					if("1".equals(flavor)){
						strMidSweet = saleTbl.get(i).get(9);
						intMidSweet = intMidSweet + (Integer.parseInt(strMidSweet));
					}else if("2".equals(flavor)){
						strMidSpicy = saleTbl.get(i).get(9);
						intMidSpicy = intMidSpicy + (Integer.parseInt(strMidSpicy));
					}
				}else if("3".equals(weight)){
					if("1".equals(flavor)){
						strLightSweet = saleTbl.get(i).get(9);
						intLightSweet = intLightSweet + (Integer.parseInt(strLightSweet));
					}else if("2".equals(flavor)){
						strLightSpicy = saleTbl.get(i).get(9);
						intLightSpicy = intLightSpicy + (Integer.parseInt(strLightSpicy));
					}
				}
			}
		}
		ArrayList<Integer> arrayLiquor = new ArrayList<Integer>();
		arrayLiquor.add(intFullSweet);
		arrayLiquor.add(intFullSpicy);
		arrayLiquor.add(intMidSweet);
		arrayLiquor.add(intMidSpicy);
		arrayLiquor.add(intLightSweet);
		arrayLiquor.add(intLightSpicy);
		return arrayLiquor;
	}
}
