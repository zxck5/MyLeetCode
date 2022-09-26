package topological_sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
//http://acmgnyr.org/year2013/c.pdf

public class StrahlerOrder {
	
	static int K,M,P;
	static int strahler[], maxCnt[], indegree[];
	static ArrayList<Integer> [] adjacent;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	static void input() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		P = Integer.parseInt(st.nextToken());
		adjacent = new ArrayList[M+1];
		indegree = new int[M+1];
		
		for (int i = 1; i <= M; i++) adjacent[i] = new ArrayList<>();
		
		for (int i = 0; i < P; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			adjacent[x].add(y);
			indegree[y] ++;
		}
		
	}
	
	static void pro() {
		strahler = new int[M+1];
		maxCnt = new int[M+1];
		
		for (int i = 1; i <= M; i++) {
			strahler[i] = -1;
		}
		
		Deque<Integer> que = new LinkedList<>();
		for (int i = 1; i <= M; i++) {
			if (indegree[i] == 0) {
				que.add(i);
				strahler[i] = 1;
			}
			
		}
		
		while (!que.isEmpty()) {
			int x = que.poll();
			
			if (maxCnt[x] >= 2) strahler[x] ++;
			for (int y : adjacent[x]) {
				if (strahler[x] > strahler[y]) {
					strahler[y] = strahler[x];
					maxCnt[y] = 1;
				} else if (strahler[x] == strahler[y]) {
					maxCnt[y] ++;
				}
				
				
				indegree[y]--;
				if (indegree[y] == 0) que.add(y);
			}
			
		}
		StringBuilder sb = new StringBuilder();
		sb.append(K).append(' ').append(strahler[M]);
		System.out.println(sb);
		
		
		
		
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			input();
			pro();			
		}
		
		
	}

}
