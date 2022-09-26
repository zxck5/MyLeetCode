package leetCode;

import java.util.Arrays;
import java.util.Scanner;

public class FairDistributionOfCookies_2305 {
	
	static int N,k;
	static int [] arr, count;
	static int [] back;
	
	
	static void input() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		k = scan.nextInt();
		arr = new int[N];
		
		for (int i = 0; i < N; i ++) {
			arr[i] = scan.nextInt();
			
		}
		
		
	}
	
	
	public static void main(String[] args) {
		input();

//		recur(0,Integer.MAX_VALUE, Arrays.stream(arr).sum(), 0);
		back = new int[N];
		int min = Integer.MAX_VALUE;
		int total = Arrays.stream(arr).sum();
		for (int i = 0; i < N; i++) {
			total -= arr[i];
			System.out.println("start===== total"+total);
			min = recur(i,Math.min(min, Math.abs(total)),total,arr[i],0);
			System.out.println("min="+min);
		}
		System.out.println(min);
	}
	
	static int recur(int idx,int min, int remainder, int pick, int cnt) {
		System.out.println("idx="+idx);
		if (idx > N) return min;
		
//		if (idx == 2) return min;
		System.out.println("cnt="+cnt);
		
		for (int i = idx+1; i < N; i++) {
			remainder -= arr[i];
			pick += arr[i];
			System.out.println("remainder = " + remainder);
			System.out.println("pick = " + pick);
			System.out.println("min=" + min);
//			back
			min = recur(i,Math.min(min, Math.abs(remainder-pick)), remainder, pick,cnt+1);
	
			
			
		}
		
		return min;
	}
}
