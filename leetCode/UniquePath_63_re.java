package leetCode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class UniquePath_63_re {
	static int grid[][],dp[][];
	static int m;
	static int n;
	static int[][] distance  = new int[][] {{1,0},{0,1}};
	
	static void input() {
		Scanner scan = new Scanner(System.in);
		m = scan.nextInt();
		n = scan.nextInt();
		grid = new int[m][n];
		grid[0][2] = 1;
		
	}
	public static boolean findObstacle() {
		for (int i = 0; i < m; i++) {
			if (grid[i][0] == 1) return true;
		}
		for (int i = 0; i < n; i++) {
			if (grid[0][i] == 1) return true;
		}
		return false;
	}
	
	
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (grid[0][0] == 1) return 0;
		
		if ((m == 1 || n == 1)&& findObstacle()) return 0;
		
		if (m == 1 || n == 1) return 1;
		
		
		
		dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
		}
		
		Queue<Integer> que = new LinkedList<>();
		que.add(0); // x = 1
		que.add(0); // y = 1
		
		while (!que.isEmpty()) {
			int x = que.poll();
			int y = que.poll();
			
			for (int i = 0; i < 2; i ++) {
				int nx = distance[i][0]+x;
				int ny = distance[i][1]+y;
				if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
				if (grid[nx][ny] == 1) continue;
//				
				
				if (nx > 0 && ny > 0) {
					if (grid[nx][ny-1] == 1) {
				
						dp[nx][ny] = dp[nx-1][ny];
					} else if (grid[nx-1][ny] == 1) {
						dp[nx][ny] = dp[nx][ny-1];
					} else {
						dp[nx][ny] = dp[nx-1][ny] + dp[nx][ny-1];					
					}
					
				}
				que.add(nx);
				que.add(ny);
			}
			
			
		}
		
		for (int i = 0; i < m; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		
        return dp[m-1][n-1];
    }
	
	
	
	static void pro() {
		
		
		uniquePathsWithObstacles(grid);
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {
		input();
		pro();
	}

}
