package leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JumpGame_45 {
	
	public static int jump(int[] nums) {
		int len = nums.length;
		int pointer = nums[0];
		int jumpCount = 1;
		for (int i = 1; i < len; i ++) {
			
			if (i == len-1 && nums[i] >= pointer) {
				System.out.println("check");
				break; 
			}
			
			if (nums[i] >= pointer) {
				pointer = nums[i];
				jumpCount ++;
				
				System.out.println("hello " + nums[i]);
				System.out.println("pointer " + pointer);
			}
			pointer --;
			// 2 3 1 1 4
			/*
			 *  nums[0] = 2 --> 1
			 * i = 1 --> nums[1] = 3 <= pointer = 1 pointer = nums[1] jump = 1 -> 2
			 * i = 2 --> nums[2] = 1 <= pointer = 3 pointer -- jump = 2
			 * i = 3 --> nums[3] = 1 <= pointer = 2 pointer -- jump = 2
			 * i = 4 --> nums[4] = 4 <= pointer = 1 pointer = 4 jump = 2 -> 3
			 * 
			 * 
			 * */	
//			if (i == len-1 && pointer < nums[len-1]) {
//				jumpCount --;
//			}
			
		}
		
		
		return(jumpCount);
    }
	
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); 
		StringTokenizer st = new StringTokenizer(br.readLine());
		int arr[] = new int[n];
		for (int i = 0; i < n; i ++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int ans = jump(arr);
		System.out.println(ans);
	}

}
