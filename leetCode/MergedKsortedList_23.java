package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MergedKsortedList_23 {
	
	static int size;
	static ListNode[] lists;
	
	public static class ListNode {
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { this.val = val; }
		ListNode(int val, ListNode next) { this.val = val; this.next = next; }
		
		public String toString () {
			return "val = " + val + ", \n next :" + next;
		}
	}
	
	static void input() {
		List<List<Integer>> list = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		size = scan.nextInt();
	
		// 1 4 5
		// 1 3 4
		// 2 6
		
		for (int i = 0; i < size; i++) {
			System.out.println("list size:");
			int listSize = scan.nextInt();
			List<Integer> temp = new ArrayList<>();
			for (int k = 0; k < listSize; k ++) temp.add(scan.nextInt());
			list.add(temp);
		}
		ListNode node;
		
		lists = new ListNode[size];
		
		
		for (int i = 0; i < size; i ++) {
			lists[i] = listNodeConverter(list.get(i));
		}
		
		System.out.println(Arrays.toString(lists));
		
		
		
	}
	
	static ListNode listNodeConverter(List<Integer> p) {
		ListNode n = new ListNode(p.get(0));
		ListNode temp = n;
		for (int i = 1; i < p.size(); i++) {
			temp.next = new ListNode(p.get(i));
			temp = temp.next;
			
		}
		return n;
	}
	static void pro() {
//		PriorityQueue<ListNode> pq = new PriorityQueue<>(new Comparator<ListNode>() {
//			@Override
//			public int compare(ListNode o1, ListNode o2) {
//				// TODO Auto-generated method stub
//				return o1.val - o2.val;
//			}
//			
//		});
//		ListNode dummy = new ListNode();
//		ListNode tail = dummy;
//		for (ListNode node : lists) {
//			if (node != null) pq.add(node);
//		}
//		System.out.println("  =====pq====  "+pq);
//		
//		while (!pq.isEmpty()) {
//			tail.next = pq.poll();
//			tail = tail.next;
//			if (tail.next != null) {
//				pq.add(tail.next);
//			}
//			
//		}
//		System.out.println(dummy.next);
		
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i = 0; i < lists.length; i ++) {
//			lists[i+1] = mergeNode(lists[i], lists[i+1]);
			pq.addAll(listNodeToIntegerArray(lists[i]));
		}
		
		if (lists.length != 0) System.out.println(pq);
		else System.out.println("empty");
		
		ListNode head = new ListNode(pq.poll());
		ListNode temp = head;
		while (!pq.isEmpty()) {
			temp.next = new ListNode(pq.poll());
			temp = temp.next;
			
		}
		System.out.println(head);
		
		
		
		
		
		
	}
	static ArrayList<Integer> listNodeToIntegerArray(ListNode node) {
//		ListNode head = node;
		ArrayList<Integer> collect = new ArrayList<>();
		while (node != null) {
			collect.add(node.val);
			node = node.next;
		}
		
		
		
		return collect;
	}
	
	
	
//	static ListNode mergeNode(ListNode p1, ListNode p2) {
//		PriorityQueue<Integer> pq = new PriorityQueue<>();
//		while (p1 != null || p2 != null) {
//			if (p1 != null) {
//				pq.add(p1.val);
//				p1 = p1.next;				
//			}
//			if (p2 != null) {
//				pq.add(p2.val);
//				p2 = p2.next;
//			} 
//		}
//		
//		ListNode head = new ListNode(pq.poll());
//		ListNode temp = head;
//		while (!pq.isEmpty()) {
//			temp.next = new ListNode(pq.poll());
//			temp = temp.next;
//			
//		}
//		return head;
//	}
	
	
	
	public static void main(String[] args) {
		input();
		pro();
	}

}
