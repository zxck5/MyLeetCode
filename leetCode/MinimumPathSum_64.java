package leetCode;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumPathSum_64 {
	static int grid[][];
	static Integer dp[][];
	static int m,n;
	
	static void input() {
		Scanner scan = new Scanner(System.in);
		m = scan.nextInt();
		n = scan.nextInt();
		grid = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int k = 0; k < n; k ++) {
				grid[i][k] = scan.nextInt();
			}
		}
	    dp = new Integer[m][n];
	    dp[0][0] = grid[0][0];
	}
	
	
	static int recur(int i, int j) {
		
		if (i < 0 || j < 0 || i >= m || j >= n) return Integer.MAX_VALUE; 
		
		
		if (dp[i][j] != null) return dp[i][j];
		
		
		return dp[i][j] = Math.min(recur(i-1,j), recur(i,j-1)) + grid[i][j];
		
	}
	
	public static void main(String[] args) {
		input();
		recur(m-1,n-1);
		for (int i = 0; i < m; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
	}
}
