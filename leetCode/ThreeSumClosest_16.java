package leetCode;

import java.util.Arrays;
import java.util.Scanner;

public class ThreeSumClosest_16 {
	
	static int N,target;
	static int nums[];
	
	static void input() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		target = scan.nextInt();
		
		
		nums = new int[N];
		for (int i = 0; i < N; i++) {
			nums[i] = scan.nextInt();
		}
		
	}
	
	static int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		
		
		int min = Integer.MAX_VALUE;
		int ans = 0;
		
		for (int p = 0; p < nums.length; p ++) {
			int left = p+1;
			int right = nums.length-1;
			
			if (p != 0 &&nums[p-1] == nums[p]) continue;
			
			while (left < right) {
				
				if (Math.abs(target - (nums[p] + nums[left] + nums[right])) <= min ) {
					min = Math.abs(target - (nums[p] + nums[left] + nums[right]));
					ans = nums[p] + nums[left] + nums[right];
//					left ++;
//					right --;
				}
				if ((nums[p] + nums[left] + nums[right]) > target) {
					right --;
				} else {
					left ++;
				}
				
			}
			
		}
		
		System.out.println(ans);
		
        return ans;
    }
	
	public static void main(String[] args) {
		input();
		
		threeSumClosest(nums,target);
		
	}
}
