package leetCode;

import java.util.Scanner;

public class ClimbingStairs_70 {
	static int N;
	static int dp[];
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		
		dp = new int[N+1];
		dp[1] = 1;
		dp[2] = 2;
		
		for (int i = 3; i <= N; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(dp[N]);
		
	}

}
