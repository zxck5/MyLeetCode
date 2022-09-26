package leetCode;

import java.util.Scanner;

public class JumpGame_55 {
	static int nums[];
	
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();
		nums = new int[N];
		for (int i = 0; i < N; i ++) {
			nums[i] = scan.nextInt();
		}
		System.out.println(canJump(nums));
		
		
		
	}
	
	public static boolean canJump(int[] nums) {
		int highestNum = 0;
		for (int i = 0; i < nums.length; i ++) {
			if (highestNum <= nums[i] ) {
				highestNum = nums[i];
			} else {
				highestNum --;
			}
			
			if (highestNum <= 0 && i != nums.length-1) {
				return false;
			} 
		}
        return true;
	}
}
