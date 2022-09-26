package leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class NumberOfIslands_200 {
	
	static int N,M;
	static char grid[][];
	static boolean visit[][];
	static int direction[][] = new int[][] {{0,1},{0,-1},{1,0},{-1,0}};
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		grid = new char[N][M];
		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < M; k++) {
				grid[i][k] = (char)(Integer.parseInt(st.nextToken()) + 48);
			}
		}
		
		for (char [] temp : grid) {
			System.out.println(Arrays.toString(temp));
		}
	}
	
	static void pro() {
		visit = new boolean[N][M];
		
		int ans = 0;
		for (int i = 0; i < N; i ++) {
			for (int k = 0; k < M; k ++) {
				if (grid[i][k] == '1' && !visit[i][k]) {
					bfs(i,k);
					ans ++;
				}
			}
		}
		System.out.println(ans);
		
		
	}
	static void bfs(int x, int y) {
		Queue<Integer> que = new LinkedList<>();
		que.add(x);
		que.add(y);
		
		while (!que.isEmpty()) {
			int tempX = que.poll();
			int tempY = que.poll();
			
			for (int i = 0; i < 4; i ++) {
				int candX = direction[i][0] + tempX;
				int candY = direction[i][1] + tempY;
				if (candX < 0 || candX >= N || candY < 0 || candY >= M) continue;
				if (visit[candX][candY]) continue;
				if (grid[candX][candY] == '0') continue;
				visit[candX][candY] = true;
				que.add(candX);
				que.add(candY);
				
			}
			
		}
		
		
	}
	
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
	}
}
