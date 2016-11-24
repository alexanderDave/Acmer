package 数据结构;

import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

public class findin_sortCount {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int[] arr = new int[5];
		for (int i = 0; i < arr.length; i++){ 
			arr[i] = in.nextInt();
		}
		System.out.println(getCount(arr, arr.length, 0, 18)+"-----times!");
	}
	
	/**
	 * @author daiw  
	 * @param arr aim count
	 * @param l arr.length
	 * @param r start position
	 * @param key
	 * @return -1 no solution; m position of key
	 */
	public static int getCount(int[] arr, int l, int r, int key){
		int m ;
		while (r <= l) {
			m = (r + l -1)/2 + 1;
			if (arr[m] == key) 
				return m;
			
			if (arr[m] < key) {
				r = m; 
			}else {
				l = m;
			}
			
		}
		return -1;
	}
}
