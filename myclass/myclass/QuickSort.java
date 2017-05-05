package myclass;

import java.util.ArrayList;

public class QuickSort {

	public QuickSort() {
	}
	/**
	 * クイックソートをしてくれるメソッド
	 * @param arrayLiquor
	 * @param left
	 * @param right
	 * @return ArrayList<Integer> arrayLiquor
	 */
	public ArrayList<Integer> quickSortMethod(ArrayList<Integer> arrayLiquor, int left, int right) {
        int curleft = left;
        int curright = right;
        int pivot = arrayLiquor.get((curleft + curright) / 2);

        do {
        	/*基準値より大きい場合、右に移動*/
            while (arrayLiquor.get(curleft) < pivot) {
                curleft++;
            }
            /*基準値より小さい場合、左に移動*/
            while (arrayLiquor.get(curright) > pivot) {
                curright--;
            }
            if (curleft <= curright) {
                swap (arrayLiquor, curleft++, curright--);//swapで２個ずつ足されている
            }
        } while (curleft <= curright);

        if (left < curright) {
        	quickSortMethod(arrayLiquor, left, curright);
        }

        if (curleft < right) {
        	quickSortMethod(arrayLiquor, curleft, right);
        }
        return arrayLiquor;
    }

    private static void swap (ArrayList<Integer> array, int idx1, int idx2) {
        int tmp = array.get(idx1);
        array.add(array.get(idx2));
        array.add(tmp);
    }
	public void print_data(ArrayList<Integer> array) {
        for(int i = 0; i < array.size(); i++){
        	System.out.print(array.get(i) + " ");
        };
    }
}
