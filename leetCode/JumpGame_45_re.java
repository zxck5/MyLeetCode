package leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JumpGame_45_re {
	static int nums[];
	
	static Integer dp[];
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[n];
		for (int i = 0; i < n; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp = new Integer[arr.length];
//		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[arr.length-1] = 0;
		System.out.println(Arrays.toString(dp));
		int ans = topDownRecur(arr, 0, arr.length-1);
		
		
//		int ans = jump(arr);
		System.out.println(Arrays.toString(dp));
		System.out.println(ans);
		
//		int ans = bottomUp(arr);
//		System.out.println(ans);
		
		
	}
	public static int jump(int[] nums) {
		return 0;
	}
	public static int topDownRecur(int nums[], int idx, int n) {
		if (idx >= n) return 0;
		
		if (dp[idx] != null) return dp[idx];
		
		dp[idx] = Integer.MAX_VALUE-1;
		for (int i = 1; i <= nums[idx]; i ++) {
			System.out.println("i = " + i);
			System.out.println("dp[idx] = " + dp[idx]);
			dp[idx] = Math.min(dp[idx], topDownRecur(nums,idx + i,n));
			System.out.println("after = ");
			System.out.println("dp[idx] = " + dp[idx]);
		}
//		if (nums[idx] == 0) return dp[idx]=Integer.MAX_VALUE;
		dp[idx] += 1;
		
		return dp[idx];
	}
	public static int bottomUp(int nums[]) {
		
		return 0;
	}
	
	
	

}
