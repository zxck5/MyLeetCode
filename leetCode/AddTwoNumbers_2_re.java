package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class AddTwoNumbers_2_re {
	
	static int N,N2;
	static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		
		public String toString () {
			return "value : "+ val + "\n next : " + next;
		}
		
		public void addNode(int num) {
			
			ListNode temp = this;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = new ListNode(num);
		}
		
		
	}
	
	 public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	     List<Integer> ans = new ArrayList<>();
	     boolean flag = false;
	     while (l1 != null || l2 != null || flag) {
	    	 System.out.println("loop");
	    	 int v1 = l1 == null ? 0 : l1.val;
	    	 int v2 = l2 == null ? 0 : l2.val;
	    	 Integer sum = flag? v1 +v2 + 1 : v1 + v2;
	    	 
	    	 int digit = sum%10;
	    	 
	    	 ans.add(digit);
	    	 
	    	 if (sum >= 10) {
	    		flag = true;
	    		
	    	 } else {
	    		flag = false;
	    	 }
	    	 
	    	 l1 = l1 != null ? l1.next : null;
	    	 l2 = l2 != null ? l2.next : null;
	    	 
	     }
	     
	     ListNode list = new ListNode(ans.get(0));
	     ListNode temp = list;
	     for (int i = 1; i < ans.size(); i ++) {
	    	 temp.next = new ListNode(ans.get(i));
	    	 temp = temp.next;
	     }
	    
	     
	     return list;
		 
	 }
	 
	
	 static void input() {
			Scanner scan = new Scanner(System.in);
			N = scan.nextInt();
			N2 = scan.nextInt();
			ListNode st = new ListNode();
			
			for (int i = 0; i < N; i++) {
				int numElement = scan.nextInt();
				st.addNode(numElement);
			}
			ListNode st2 = new ListNode();
			for (int i = 0; i < N2; i++) {
				int numElement = scan.nextInt();
				st2.addNode(numElement);
			}
			System.out.println(st);
			System.out.println(st2);
			
			AddTwoNumbers_2_re instance = new AddTwoNumbers_2_re();
			ListNode l = instance.addTwoNumbers(st, st2);
			System.out.println(l);
			
			
			
		}
	
	
	public static void main(String[] args) {
		input();
		
		
	}

}
