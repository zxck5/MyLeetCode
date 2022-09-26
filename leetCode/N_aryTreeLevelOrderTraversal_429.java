package leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;



public class N_aryTreeLevelOrderTraversal_429 {	
	
	static int N;
	static List<Integer>[] level;
	static Node root;
	
	static ArrayList<Integer> adjacent[];
	
	static class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val) {
	        val = _val;
	    }

	    public Node(int _val, List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	};
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		N = Integer.parseInt(br.readLine());
		adjacent = new ArrayList[N];
		for (int i = 0; i < N; i++) {
			adjacent[i] = new ArrayList<>();
		}
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			List<Integer> tokens = null;
			if (st.hasMoreTokens()) tokens = new ArrayList<>();
			while (st.hasMoreTokens()) {
				tokens.add(Integer.parseInt(st.nextToken()));
			}
			adjacent[i].addAll(tokens);
		}
		
	}
	
	static void pro() throws IOException {
		input();
		levelOrder(root);
		
	}
	public static List<List<Integer>> levelOrder(Node root) {
		 if (root == null) return new ArrayList<>();
	        
		 level = new ArrayList[1000];
		 
		 for (int i = 0; i < 1000; i ++) {
			 level[i] = new ArrayList<>();
		 }
		 recur(root,0);
		 
//		 for (int i = 0; i < level.length; i++) {
//			 if (level[i].size() != 0) System.out.println(level[i]);
//		 }
		 
		 List<List<Integer>> result = new ArrayList<>();
		 for (int i = 0; i < level.length; i ++) {
			 if (level[i].size()!=0) result.add(level[i]);
		 }
		 return result;

    }
	
	public static void recur(Node root, int len) {
		
		if (!level[len].contains(root.val)) level[len].add(root.val);
		
		if (root.children.size() == 0) return;
		
		
		for (Node child : root.children) {
			level[len+1].add(child.val);
			recur(child,len+1);
			
		}
	}
	
	public static void main(String[] args) throws IOException {

		
		//https://leetcode.com/problems/n-ary-tree-level-order-traversal/
	
	}
}
