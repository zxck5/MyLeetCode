package dummy;

import java.util.Scanner;

public class Dummy {
	static int dp[];
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		

		StringBuilder sb = new StringBuilder();
		dp = new int[11];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for (int k = 4; k <= 10; k ++) {
			dp[k] = dp[k-3] + dp[k-2] + dp[k-1];
		}
		
		int T = scan.nextInt();
		
		for (int i = 0; i < T; i++ ) {
			int n = scan.nextInt();
			sb.append(dp[n]).append('\n');
		}
		System.out.println(sb);

	
		
	}
}
