//package leetCode;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//public class LongestPalindromicSubstring_5 {
//	
//	
//	public static String longestPalindrome(String s) {
//		if (s.length() == 1) return s;
//		
//		int max = Integer.MIN_VALUE;
//		String max_string = "";
//		
//		
//		int start = 0;
//		int end = s.length()-1;
//		
//		while (start < end) {
//			if (s.charAt(start) == s.charAt(end)) {
//				start ++;
//				end --;
//				String temp = s.substring(start,end+1)
//				if (max < temp.length()) {
//					max = temp.length();
//					max_string = temp;
//				}
//				
//			} else {
//				
//			}
//			
//			
//		}
//		
//		
////		for (int i = 0; i < s.length()-1; i ++) {
////			for (int k = i+1; k < s.length(); k ++) {
////				
////				String temp = s.substring(i,k+1);
////				System.out.println("temp="+temp);
////				if(isPalindrome(temp)) {
////					if (max < temp.length()) {
////						max_string = temp;
////						max = temp.length();
////						
////					} 
////				}			
////			}
////		}
//		if (max_string == "") return String.valueOf(s.charAt(0));
//		
//        return max_string;
//    }
//	
//	
//	
//	
//	
//	
//	
////	static boolean isPalindrome(String s) {
////		if (s.length() == 1) return true;
////		
////		List<Character> list = new ArrayList<>();
////		for (char let : s.toCharArray()) {
////			list.add(let);
////		}
////		int start = 0;
////		int end = list.size()-1;
////		while (start < end) {
////			if (list.get(start) == list.get(end)) {
////				start ++;
////				end --;				
////			} else {
////				return false;
////			}
////		}
////		
////		
////		return true;
////	}
////	
//	
//	public static void main(String[] args) {
//		Scanner scan = new Scanner(System.in);
//
//		String ans = longestPalindrome(scan.next());
//		System.out.println(ans);
//	}
//}
