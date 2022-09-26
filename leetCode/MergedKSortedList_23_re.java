package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;



public class MergedKSortedList_23_re {
	
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
	
	public static ListNode listNodeConverter(List<Integer> list) {
		ListNode head = new ListNode(list.get(0));
		ListNode temp = head;
		for (int i = 1; i < list.size(); i ++) {
			temp.next = new ListNode(list.get(i));
			temp = temp.next;
		}
		
		return head;
		
	}
	
	
	
	
	public static void pro() {
		ListNode l = mergeKLists(lists);
		System.out.println(l);
	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
		return partition(0,lists.length-1, lists);

	}
	
	public static ListNode partition(int start, int end, ListNode[] lists) {
		
		if (start == end) return lists[start];
		
		else if (start < end) {
			
			int mid = (start+end)/2;
			
			ListNode leftPartition = partition(start,mid,lists);
			
			ListNode rightPartition = partition(mid+1,end,lists);
			
//			if (mid == 1) {
//				System.out.println("xxxxxxxleftxxxxxxxx "+leftPartition);
//			System.out.println("xxxxxxxrightxxxxxxx" + rightPartition);
//			}
			
			ListNode mergedPartition = merge(leftPartition, rightPartition);
			
			
			
			return mergedPartition;
		}
		
		return null;
		
	}
	
//	public static ListNode merge(ListNode l, ListNode r) {
//		System.out.println("l===="+l);
//		System.out.println("r===="+r);
//		
//		ListNode lTemp = l;
//		ListNode rTemp = r;
//		
//		ListNode dummy = new ListNode(0);
//		ListNode dummyHead = dummy;
//		
//		while (lTemp != null && rTemp != null) {
//			if (lTemp.val > rTemp.val) {
//				dummy.next = rTemp;
//				rTemp = rTemp.next;
//			} else {
//				dummy.next = lTemp;
//				lTemp = lTemp.next;
//			}
//			dummy = dummy.next;
//		}
//		
////		System.out.println("dummy head First check============"+ dummyHead);
////		System.out.println("CHECK L first====" + lTemp);
////		System.out.println("CHECK R first====" + rTemp);
////		System.out.println("CHECK dummy first====" + dummy);
//		
//			while (lTemp != null) {
//				dummy.next = lTemp;
//				dummy = dummy.next;
//				lTemp = lTemp.next;
//			} 
//		
//		
//		
//			while (rTemp != null) {
//				dummy.next = rTemp;
//				dummy = dummy.next;
//				rTemp = rTemp.next;
//			} 
//			
//		
////		System.out.println("dummy head SECOND check============"+ dummyHead);
//		
//		
//		return dummyHead.next;
//		
//	}
	
	public static ListNode merge(ListNode l1, ListNode l2) {
		if (l1 == null) return l2;
		if (l2 == null) return l1;
		
		if (l1.val < l2.val) {
			l1.next = merge(l1.next, l2);
			return l1;
		} else {
			l2.next = merge(l2.next,l1);
			return l2;
		}
		
		
	}
	
	
	public static void main(String[] args) {
		input();
		pro();
	}
	
	
}
