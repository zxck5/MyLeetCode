package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ThreeSum15_re {
	
	static int N;
	static int arr[];
	static ArrayList<List<Integer>> ans;
	
	
	static void input() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		arr = new int[N+1];
		for (int i = 1; i <= N; i++) {
			arr[i] = scan.nextInt();
		}
		Arrays.sort(arr,1,N+1);
		
		
	}
	
	public static void pro() {
		int left = 0;
		int right = N;
		ans = new ArrayList<>();
		
		for (int i = 1; i <= N-2; i++) {
			left = i+1;
			right = N;
			if (i != 0 && arr[i] == arr[i-1]) {
				continue;
			}
			
			while (left < right) {
				
				if (arr[i] +arr[left] + arr[right] == 0) {
					ans.add(Arrays.asList(arr[i],arr[left],arr[right]));
					
					// duplicate?
					while (left < right && arr[left] == arr[left-1]) left ++;
					
					while (left < right && arr[right] == arr[right+1]) right --; 
					
					left ++;
					right --;
					
				} else if (arr[i] +arr[left] + arr[right] > 0) {
					right --;
					
				} else if (arr[i] +arr[left] + arr[right] < 0) {
					left ++;
				}
				
			}
					
			
		}
		for (int i = 0; i < ans.size(); i++) {
			System.out.println(ans.get(i));
		}
		
	}
	
	public static void main(String[] args) {
		input();
		pro();
	}
}
