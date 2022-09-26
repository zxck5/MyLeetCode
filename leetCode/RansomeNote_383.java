package leetCode;

import java.util.Arrays;
import java.util.Scanner;

public class RansomeNote_383 {
	
	static String ransomeNote, str1;
	static boolean [] alphabet; 
	static int [] count;
	
	
	
	static void input() {
		Scanner scan = new Scanner(System.in);
		  ransomeNote = scan.next();
		  str1 = scan.next();
		
	}
	
	public static boolean canConstruct(String ransomNote, String magazine) {
		

		
		
		alphabet = new boolean[26];
		count = new int[26];
		

//		magazine.chars().forEach(c -> count[c-97] ++);
//		ransomeNote.chars().forEach(c -> count[c-97]--);
		
//		System.out.println(Arrays.toString(alphabet));
		System.out.println(Arrays.toString(count));
//		return !ransomeNote.chars().filter(c -> count[c-97] < 0).findFirst().isPresent();

		
		for (int i = 0; i < magazine.length(); i ++) {
			count[magazine.charAt(i)-97] ++;
		}
		for (int i = 0; i < ransomeNote.length(); i ++) {
			count[ransomeNote.charAt(i)-97]--;
			if (count[ransomeNote.charAt(i)-97] < 0) {
				return false;
			}
		}
		return true;
		
    }
	
	
	public static void main(String[] args) {
		input();
		System.out.println("output : " + canConstruct(ransomeNote, str1));
	}

}
