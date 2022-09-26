package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PascalsTriangle_118 {
	
	static int numRows;
	
	public static void input() {
		Scanner scan = new Scanner(System.in);
		numRows = scan.nextInt();
	}
	
	/*
	 * 						1
	 * 					1		1
	 * 				1		2		1
	 * 			1		3		3		1
	 * 		1		4		6		4		1
	 * 	1		5		10		10		5		1
	 * .......
	 * 
	 * */
	public static List<List<Integer>> generate(int numRows) {
		List<List<Integer>> list = new ArrayList<>();
		
		if (numRows == 0) {
			list.add(new ArrayList<>());
			return list;
		}
        
		if (numRows == 1) {
			list.add(new ArrayList<>(Arrays.asList(1))); 
			return list;
		}
			
		
		list.add(new ArrayList<>(Arrays.asList(1)));
		list.add(new ArrayList<>(Arrays.asList(1,1)));

		
		for (int i = 2; i < numRows; i ++) {
			list.add(new ArrayList<>());
			List<Integer> temp = list.get(i-1); // if i = 2, list.get(1) = [1,1]
			List<Integer> dummy = list.get(i);  // dummy = list.get(2) = []
			dummy.add(1); // [1]
			for (int k = 0; k <= i-1; k ++ ) {
				if (k+1 < i) dummy.add(temp.get(k) + temp.get(k+1)); 
				/* 
				 * k = 0 --> temp = [1,1]  temp.get(0) = 1 + temp.get(1) = 1 =  dummy = [1, 2]
				 * k = 1 --> temp = [1,1]
				 * */
			}
			dummy.add(1);
			
		}
		
		for (int i = 0; i < numRows; i ++) {
			System.out.println(list.get(i));
		}
		
		
		
		return null;
	}
	
	
	
	public static void main(String[] args) {
		input();
		generate(numRows);
	}

}
