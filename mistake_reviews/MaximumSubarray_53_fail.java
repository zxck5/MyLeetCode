package mistake_reviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MaximumSubarray_53_fail {
	
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
		partition(nums,0,nums.length-1);
		
		dp[nums.length-1] = Math.max(addAll(nums,0,nums.length-2),addAll(nums,1,nums.length-1));	
		dp[nums.length] = addAll(nums,0,nums.length-1);
		
		System.out.println(Arrays.toString(dp));
		return 0;
	}
	public static void partition(int [] nums, int start, int end) {
		dp[end-start+1] = Math.max(dp[end-start+1], addAll(nums,start,end));
		
		if (start == end) {
			dp[1] = Math.max(dp[1], nums[start]);
//			return new Integer[] {nums[start]};
			return;
		}
		
		if (start < end) {
			int mid = (start+end)/2;
			
			System.out.println(Arrays.toString(dp));
			System.out.println("recur="+(end-start+1));
//			Integer[] left = partition(nums,start,mid);
			partition(nums,start,mid);
			partition(nums,mid+1,end);
			
//			Integer[] right = partition(nums,mid+1,end);
			
		}

	}
	
	public static int addAll(int nums[], int s, int e) {
		if (s == e) return nums[s];
		
		int sum = 0;
		for (int i = s; i <= e; i ++) {
			sum += arr[i];
		}
		System.out.println("sum="+sum);
		return sum;
	}
	
	
	public static void main(String[] args) throws IOException {
		input();
		dp = new int[n+1];
		for (int i = 1; i <= n; i ++) dp[i] = Integer.MIN_VALUE;
		maxSubArray(arr);
	}
	
}
