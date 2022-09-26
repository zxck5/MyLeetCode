package leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;




public class MaximumLengthOfRepeatedSubArray_718 {
	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m;
	static int num1[],num2[],dp[][];

	
	static void input() throws IOException {
		st = new StringTokenizer(br.readLine());
	
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		num1 = new int[n];
		num2 = new int[m];
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			num1[i] = Integer.parseInt(st.nextToken());
			
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			num2[i] = Integer.parseInt(st.nextToken());
		}
	}
	
	static void pro() {
//		int ans = findLength(num1,num2);
		int ans = findLength2(num1,num2);
		System.out.println(ans);
		
	}
	
	public static int findLength2(int[] nums1, int[] nums2) {
//		dp = new int[m+1][n+1];
		
		
		return recursion(1,num1,num2,0,new int[2][n+1]);
		
        
    }
	public static int recursion(int start, int[] nums1, int[] nums2, int max, int[][] dp) {
		if (start > nums1.length) {
			for (int i = 0; i < dp.length; i ++) {
				System.out.println(Arrays.toString(dp[i]));					
			}
			return max;
		}
		if (max == 3) {
			System.out.println("start="+start);
		}
		
		
		for (int i = 1; i <= n; i ++) {
			if (nums1[start-1] == nums2[i-1]) {
				dp[start%2][i] = dp[(start-1)%2][i-1] + 1;
				max = Math.max(dp[start%2][i], max);
			} else {
				dp[start%2][i] = 0;
			}
		}
		
		
		return recursion(start+1,nums1,nums2,max,dp);
	}
	
	
	public static int findLength(int[] nums1, int[] nums2) {
		dp = new int[m+1][n+1];
		int max = Integer.MIN_VALUE;
		
		for (int i = 1; i <= m; i ++) {
			for (int j = 1; j <= n; j ++) {
				if (nums1[i] == nums2[j]) {
					dp[i][j] = dp[i-1][j-1] + 1;
					max = Math.max(max, dp[i][j]);
				}
			}
		}
		
		
		return max;
        
    }
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
