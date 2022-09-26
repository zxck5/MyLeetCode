package mistake_reviews;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

//https://leetcode.com/problems/unique-paths/
public class UniquePathsObstacles63_re {
	
	static Integer dp[][];
	static int grid[][];

	static int m;
	static int n;
//	
	static void input() {
		Scanner scan = new Scanner(System.in);
		m = scan.nextInt();
		n = scan.nextInt();
		grid = new int[m][n];
		
	    dp = new Integer[m][n];
//	    grid[1][1] = 1;
//	    grid[0][1] = 1;
//	    grid[1][0] = 1;
	    grid[1][1] = 1;
	}
	static void init(int [][]obstacleGrid) {
		grid = obstacleGrid;
		m = grid.length;
	    n = grid[0].length;
	    dp = new Integer[m][n];
	}
	

	public static int uniquePathsWithObstacles(int [][]obstacleGrid) {
//		init(obstacleGrid);
		return find(m-1,n-1);
    }

	public static int find(int i, int j) {
		
		if (i < 0 || j < 0 || i >= m || j >= n || grid[i][j] == 1) return 0;
		else if (i == 0 && j == 0) return dp[i][j] = 1;
		
		if (dp[i][j] != null) return dp[i][j];

		int left = find(i,j-1);
		int up = find(i-1,j);
		
		return dp[i][j] = left + up;
	}
	
	
	public static void main(String[] args) {
		input();
		uniquePathsWithObstacles(grid);
		for (int i = 0; i < m; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
	}
}
