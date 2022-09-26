package leetCode;

import java.util.Arrays;
import java.util.Scanner;

public class MedianOfTwoNumbers_4 {
	static int N,M;
	
	
	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int mergedArray [] = new int[N+M];
		
        int index = 0;
        int p1 = 0;
        int p2 = 0;
        
        while (p1 < nums1.length && p2 < nums2.length) {
        	if (nums1[p1] < nums2[p2]) {
        		mergedArray[index] = nums1[p1];
        		p1 ++;
        	} else {
        		mergedArray[index] = nums2[p2];
        		p2 ++;
        	}
        	index ++;
        	
        }
        
        if (p1 >= nums1.length && p2 < nums2.length) {
        	for (int i = index; i < mergedArray.length; i ++,p2++) {
        		mergedArray[i] = nums2[p2];
        		
        	}
        	
        } else if (p2 >= nums2.length && p1 < nums1.length) {
        	for (int i = index; i < mergedArray.length; i ++,p1++) {
        		mergedArray[i] = nums1[p1];
        		
        	}
        }
        
        
//        System.out.println(Arrays.toString(mergedArray));
        double median = 0;
       
        if ((mergedArray.length) % 2 == 0) {
 
        	median = (mergedArray[mergedArray.length/2-1] + mergedArray[mergedArray.length/2])/2.0;
        } else {
        	median = mergedArray[mergedArray.length/2];
        }
        
        
        
		return median;
    }
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		M = scan.nextInt();
		int nums1 [] = new int[N];
		int nums2 [] = new int[M];
		
		for (int i = 0; i < N; i++) {
			nums1[i] = scan.nextInt();
		}
		for (int i = 0; i < M; i++) {
			nums2[i] = scan.nextInt();
		}
		
		System.out.println(findMedianSortedArrays(nums1,nums2));
		
		
	}
}
