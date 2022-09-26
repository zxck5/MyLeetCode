package leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;


public class MaxSumOfRectangleNoLargerThanK_363 {
	
	
	static int [][] matrix;
	
	
	static int m,n,k;
	
	
	static void input() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		matrix = new int[m][n];
		
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			for (int k = 0; k < n; k ++) {
				matrix[i][k] = Integer.parseInt(st.nextToken());
			}
		}
	}
	
	static void pro() {
		
		System.out.println(maxSumSubmatrix(matrix,k));
		
	}
	
	public static int maxSumSubmatrix(int[][] matrix, int k) {
		int max = Integer.MIN_VALUE;
		for (int row = 0; row < m; row ++) {
			
			// max sum for whole rectangle if row is 0,.. when row is k, it is k~m... (k < m)
			int colSum[] = new int[n];
			for (int r = row; r < m; r ++) {
				for (int c = 0; c < n; c ++) {
					colSum[c] += matrix[r][c];
				}
				System.out.println("rowSum="+ Arrays.toString(colSum));
				max = Math.max(max, getSum(colSum, k));
				System.out.println("each row :"+row + " , " + getSum(colSum,k));
			}
			
		}
		return max;
    }
	
	public static int getSum(int [] colSum, int k) {
		TreeSet<Integer> treeSet = new TreeSet<>();
		treeSet.add(0);
		int prefixSum = 0;
		int max = Integer.MIN_VALUE;
		
		for (int i = 0; i < colSum.length; i ++) {
			
			prefixSum += colSum[i];
			
			Integer target = treeSet.ceiling(prefixSum - k);
			if (target != null) {
				max = Math.max(max, prefixSum-target);
			}
			treeSet.add(prefixSum);
		}
		
		return max;
	}
	
	
		
	
	public static void main(String[] args) throws IOException {
		input();
		pro();
		
		
	}

}
