package leetCode;

import java.util.Arrays;
import java.util.Scanner;

public class UniquePaths_63 {
	
	static int grid[][],dp[][];

	static int m;
	static int n;
//	
	static void input() {
		Scanner scan = new Scanner(System.in);
		m = scan.nextInt();
		n = scan.nextInt();
		grid = new int[m][n];
		grid[0][1] = 1;
		
	}
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
		}
		
		
		dp[0][0] = 0;
		
		for (int i = 1; i < m; i ++) {
			for (int k = 1; k < n; k ++) {
				
				if (grid[i][k] == 0) {
					dp[i][k] = dp[i-1][k] + dp[i][k-1];					
				} else {
					continue;
				}
				if (grid[i][k] == 0) {
					if (grid[i-1][k] == 1) dp[i][k] = dp[i][k-1];
					
					else if (grid[i][k-1] == 1) dp[i][k] = dp[i-1][k];
					
				}
			}
		}
		for (int i = 0; i < m; i ++) {
			System.out.println(Arrays.toString(grid[i]));
		}
		for (int i = 0; i < m; i ++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		
		
		
        return 0;
    }
	
	
	
	static void pro() {
		
		
		uniquePathsWithObstacles(grid);
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		input();
		pro();
	}

}
