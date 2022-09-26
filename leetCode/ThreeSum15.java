package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ThreeSum15 {
	
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
	static void pro() {
		// initialization
		// two pointers
		int left = 1;
		int right = N;
		int param = 0;
		ans = new ArrayList<>();
//		System.out.println(Arrays.toString(arr));
		
		while (left < right) {
			param = arr[left] + arr[right];
			// binary search.
//			System.out.println("XXXXXXXparamXXXXXX="+param);
//			System.out.println("right="+right);
//			System.out.println("left="+left);
			if (right - left > 1) {
//				System.out.println("pass");
				binarySearch(left+1, right-1, param);				
			} else {
				break;
			}
			if (arr[left] + arr[right] < 0) {
				// left absoulte is the largest
				left ++;
			} else {
				// right absoulte is the largest or same
				right --;
			}
		}
		
		
		for (int i = 0; i < ans.size(); i++) {
			System.out.println((ans.get(i)));
		}
		
	}
	
	static void binarySearch(int l, int r, int param) {
		int pick = l-1;
		int left = l-1;
		int right = r+1;
//		System.out.println("binary search");
//		System.out.println("--------");
//		System.out.println("left="+left);
//		System.out.println("right="+right);
		
		while (l <= r) {
			int mid = (l+r)/2;
			if (arr[mid] + param <= 0) {
//				System.out.println(arr[mid] + param);
				pick = arr[mid] + param;
				boolean flag = true;
				if (pick == 0 ) {
					List<Integer> temp = Arrays.asList(arr[left],arr[right],arr[mid]);
					for (List<Integer> list : ans) {
						if (list.containsAll(temp)) {
							flag = false;
							break;
						}
					}
					if (flag) ans.add(temp);
				}
				
				l = mid+1;
			} else {
				r = mid-1;
			}
		}
		
		
		
		
	}
	
	
	public static void main(String[] args) {
		input();
		pro();
	}
	

}
