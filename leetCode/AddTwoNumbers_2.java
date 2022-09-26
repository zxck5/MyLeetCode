package leetCode;

import java.util.Scanner;

public class AddTwoNumbers_2 {
	
	static int N,N2;
	
	static class MyLinkedList {
//		int val;
//		MyLinkedList next;
		Node head;
		Node tail;
		
		static class Node {
			int val;
			Node next;
			Node (int val, Node next) {
				this.val = val;
				this.next = next;
			}
			
			public String toString() {
				return "value: "+ val;
			}
		}
		
		// constructors
		MyLinkedList () {
			
		}
		
		void merge (MyLinkedList list) {
			int s = checkSize();
			int s2 = list.checkSize();
			MyLinkedList mll1;
			MyLinkedList mll2;
			if (s > s2) {
				mll1 = this;
				mll2 = list;
			} else {
				mll1 = list;
				mll2 = this;
			
			}
			
			Node temp = mll1.head;
			Node temp2 = mll2.head;
			MyLinkedList ans = new MyLinkedList();
			while (temp != null) {
				int sum = 0;
				
				if (temp2 == null) {
					sum = temp.val;
					
				} else {
					sum = temp.val + temp2.val;
				}
				
				int digit = 0;
				if (sum >= 10 && temp.next != null) {
					temp.next.val += 1;	
					digit = sum % 10;
					ans.addNode(digit);
				} else if (sum >= 10 && temp.next == null) {
					digit = sum % 10;
					ans.addNode(digit);
					ans.addNode(sum / 10);
				}
				
				
				
				temp = temp.next;
				if (temp2 != null) temp2 = temp2.next;
			}
			ans.printAll();
			
		}
		
		void addNode(int v) {
			if (head == null) {
				head = new Node(v, null);
			} else {
				Node temp = head;
				while (temp.next != null) {
					temp = temp.next;
				}
				temp.next = new Node(v,null);
				
			}
		}
		int checkSize() {
			Node temp = head;
			int cnt = 1;
			while (temp.next != null) {
				temp = temp.next;
				cnt ++;
			}
			return cnt;
			
		}
		
		
		void printAll() {
			if (head == null) {
				return;
			}
			
			Node temp = head;
			while (temp.next != null) {
				System.out.println(temp);
				temp = temp.next;
			}
			System.out.println(temp);
			
		}
		
		
		
	}
	
	static void input() {
		Scanner scan = new Scanner(System.in);
		N = scan.nextInt();
		N2 = scan.nextInt();
		MyLinkedList st = new MyLinkedList();
		
		for (int i = 0; i < N; i++) {
			int numElement = scan.nextInt();
			st.addNode(numElement);
		}
		MyLinkedList st2 = new MyLinkedList();
		for (int i = 0; i < N2; i++) {
			int numElement = scan.nextInt();
			st2.addNode(numElement);
		}
		st.printAll();
		st2.printAll();
		
		st.merge(st2);
		
		
		
	}
	
	public static void main(String[] args) {
		input();
		
	}

}
