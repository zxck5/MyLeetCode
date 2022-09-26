package leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MaximumSubarray_53_kadane {
	
	static int n;
	static int arr[];
	static int dp[];
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		
		arr = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
	}
	
	public static int maxSubArray(int[] nums) {
	
		return 0;
	}
	
	
	
	public static void main(String[] args) throws IOException {
		input();
		dp = new int[n];
		dp[0] = arr[0];
		
		for (int i = 0; i < n-1; i++) {
			dp[i+1] = Math.max(dp[i] + arr[i+1], arr[i+1]);
		}
		System.out.println(Arrays.toString(dp));
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < n; i ++) max = Math.max(max, dp[i]);
		System.out.println(max);
		
		
	}
	
}
