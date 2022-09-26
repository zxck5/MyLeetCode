package leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//https://leetcode.com/problems/unique-paths/
public class UniquePaths {
	
	static int grid[][];

	static int m;
	static int n;
//	
	static void input() {
		Scanner scan = new Scanner(System.in);
		m = scan.nextInt();
		n = scan.nextInt();
		grid = new int[m][n];
		
	}

	public static int uniquePaths(int m, int n) {
		
		grid = new int[m][n];
		for (int i = 0; i < m; i ++) {
			grid[i][0] = i;
			if (n > 1) grid[i][1] = i+1;
		}
		for (int i = 0; i < n; i ++) {
			grid[0][i] = i;
			if (m > 1) grid[1][i] = i+1;
			
		}
//		
//		for (int i = 0; i < m; i ++) {
//			System.out.println(Arrays.toString(grid[i]));
//		}
		for (int i = 2; i < m; i ++) {
			for (int k = 2; k < n; k ++) {
				grid[i][k] = grid[i-1][k] + grid[i][k-1];
			}
		}
//		for (int i = 0; i < m; i ++) {
//			System.out.println(Arrays.toString(grid[i]));
//		}
		
		System.out.println(grid[m-1][n-1]);
        return 0;
    }

	
	
	public static void main(String[] args) {
		input();
		uniquePaths(m,n);
	}
}
