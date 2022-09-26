package mistake_reviews;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;




public class MaximumLengthOfRepeatedSubArray_718_fail {
	
//	static class Bridge {
//		int idx; // num1 idx
//		int idx2; // num2 idx
//		public Bridge() {}
//		public Bridge (int idx, int idx2) {
//			this.idx = idx;
//			this.idx2 = idx2;
//		}
//		public String toString() {
//			return "idx = " + idx + ", " + "idx2=" + idx2;
//		}
//	}
	
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int n,m;
	static int num1[],num2[];
	static int [] temp;
	
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
		temp = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			num2[i] = Integer.parseInt(st.nextToken());
			temp[i] = num2[i];

		}
		
		
	}
	static void pro() {
		int ans = findLength(num1,num2);
		System.out.println(ans);
		
	}
	
	
	
	public static int findLength(int[] nums1, int[] nums2) {
		
		
//		 idx search, binary
		Arrays.sort(num2);
		List<Integer> candiates = new ArrayList<>();
		for (int i = 0; i < n; i ++) {
			binarySearch(candiates,0,nums2.length-1,num1[i]);
		}
//		System.out.println(candiates);
		
		
		return 0;
		
		// pick candiates.
		
		// collect indexes.
		
		// compare the numbers 
		
		// get the length
        
    }
	
	
	

	private static void binarySearch(List<Integer> candiates, int l, int r, int value) {
		// TODO Auto-generated method stub
		
		int cand = r;
		while (l <= r) {
			int mid = (l+r)/2;
			if (num2[mid] < value) {
				l = mid+1;
			} else {
				r = mid-1;
				cand = mid;
			}
		}
		if (cand != r) {
			System.out.println(num2[cand]);
			System.out.println(Arrays.binarySearch(temp, num2[cand]));
//			int startidx = Arrays.binarySearch(temp, num2[cand]);
//			if (startidx > 0) System.out.println(startidx);
//			System.out.println("hello");
//			System.out.println(Arrays.toString(temp));
//			while (cand < num2.length && num2[cand++] == value) {
//				
//				
//				candiates.add(Arrays.binarySearch(num2, temp[cand]));
//			}
		}
//		
		
	}
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}

}
