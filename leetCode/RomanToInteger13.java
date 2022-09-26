package leetCode;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class RomanToInteger13 {
	
	
	static String s;
	static Map<Character, Integer> map;
	static Character [] symbols = new Character[] {'I','V','X','L','C','D','M'};
	static Integer values[] = new Integer[] {1,5,10,50,100,500,1000};
	
	static int romanToInt(String s) {
		int ans = 0;
		char c;
		
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			int numC = map.get(c);
			
			if (i+1 == s.length()) {
				ans += map.get(c);
				continue;
			}
			
			char c2 = s.charAt(i+1);
			int numC2 = map.get(c2);
			
			if (numC < numC2) {
				ans -= numC;
			} else {
				ans += numC;
			}
			
			
		}
		
		return ans;
	}
	
	
	
	
	static void input() {
		Scanner scan = new Scanner(System.in);
		s = scan.next();
	}
	static void pro () {
		map = new HashMap<>();
		for (int i = 0; i < symbols.length; i++) {
			map.put(symbols[i], values[i]);
		}
		
		System.out.println(romanToInt(s));
		
	}
	
	
	public static void main(String[] args) {
		input();
		pro();
	}
}
