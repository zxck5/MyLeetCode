package leetCode;

import java.util.Arrays;

public class RotateImg_48 {
	
//	https://leetcode.com/problems/rotate-image/
	static boolean check[][];
	
	static void input() {
		
	}
	static void pro() {
		
		int arr[][] = new int[3][3];
		int cnt = 1;
		for (int i = 0; i < 3; i ++) {
			for (int k = 0; k < 3; k ++) {
				arr[i][k] = cnt++;
			}
		}
		yAxisReverse(arr);
		yEqualsXReflection(arr);
		for (int i = 0; i < 3; i ++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		
		
		
	}
	
//			[5,1,9,11]
//			[2,4,8,10]
//			[13,3,6,7]
//			[15,14,12,16]
	//yAxisReverse
	
//			[11, 9, 1, 5]
//			[10, 8, 4, 2]
//			[7, 6, 3, 13]
//			[16, 12, 14, 15]
	//yEqualsXReflection
	
//			[15, 13, 1, 5]
//			[14, 3, 4, 2]
//			[7, 6, 8, 9]
//			[16, 12, 10, 11]
	
	
	
	// Expected output
	//[15,13,2,5]
	//[14,3,4,1]
	//[12,6,8,9]
	//[16,7,10,11]

	
	static void yAxisReverse(int [][] arr) {
		check = new boolean[3][3];
		for (int i = 0; i < 3; i ++) {
			for (int k = 0; k < 3; k ++) {
				if (!check[i][k] && !check[i][3-1-k]) {
					int temp = arr[i][k];
					arr[i][k] = arr[i][3-1-k];
					arr[i][3-1-k] = temp;		
					check[i][k] = true;
					check[i][3-1-k] = true;
				}
			}
		}
	}
	static void yEqualsXReflection (int [][] arr) {
		
		check = new boolean[3][3];
		for (int i = 0; i < 3; i ++) {
			for (int k = 0; k < 3; k ++) {
				if (!check[i][k] && !check[i][3-1-k]) {
					int temp = arr[i][k];
					arr[i][k] = arr[3-1-k][3-1-i];
					arr[3-1-k][3-1-i] = temp;		
					check[i][k] = true;
					check[3-1-k][3-1-i] = true;
				}
			}
		}
		
	}
	
	
	
	public static void main(String[] args) {
//		input();
		pro();
	}
}
