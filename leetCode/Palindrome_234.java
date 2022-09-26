package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Palindrome_234 {
	
	static int size;
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		 
	}
	public static void input() {
		Scanner scan = new Scanner(System.in);
		size = scan.nextInt();
		
		
	}
	public boolean isPalindrome(ListNode head) {
		List<Integer> list = new ArrayList<>();
		
		while (head != null) {
			int v = head.val;
			list.add(v);
			head = head.next;
		}
		
		int left = 0;
		int right = list.size()-1;
		
		for (int i = 0; i < list.size()/2; i ++) {
			if (list.get(left) == list.get(right)) {
				left ++;
				right --;
			} else {
				return false;
			}
		}
		return true;
		
		
	}
	
	
	public static void main(String[] args) {
		
	}

}
