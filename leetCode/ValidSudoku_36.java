package leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ValidSudoku_36 {
	static int [][] board;
	static boolean flag;
	static boolean checkNum[];
	
	
	public static void main(String[] args) throws IOException {
		System.out.println("run");
		board = new int[9][9];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int k = 0; k < 9; k ++) {
				board[i][k] = (Integer.parseInt(st.nextToken()));
			}
		}
		checkNum = new boolean[10];
		flag = true;
		isValidSudoku(board);
		
	}
	public static boolean isValidSudoku(int[][] board) {
		
		
		boolean flag = sudoku(0,0,board);
		System.out.println("Pass");
		System.out.println("flag="+flag);
		if(flag) {
			for (int [] array : board) {
				System.out.println(Arrays.toString(array));
			}
		}
		
		return flag;
		
        
    }
	static boolean sudoku(int x, int y, int board [][]) {
		
		if (x == 9) {
			for (int [] array : board) {
				System.out.println(Arrays.toString(array));
			}
			System.exit(0);
			return true;
		}
		if (y == 9) {
			checkNum = new boolean[10];
			sudoku(x+1,0,board);
		}
		
		if (board[x][y] != 0 && checkNum[board[x][y]]) flag = false;
		if (!flag) return false;
			
		checkNum[board[x][y]] = true;
		
		if (board[x][y] != 0) return sudoku(x,y+1,board);
		else {
			for (int cand = 1; cand <= 9; cand++) {
				
				if (validation(board,x,y,cand)) {
					board[x][y] = cand;
					if(sudoku(x,y+1,board))return true;
					board[x][y] = 0;
				}
			}
		}	
		return false;
	}
		
	
	
	static boolean validation(int board[][], int x, int y, int value) {
		// col validation
		for (int col = 0; col < 9; col ++) {
			if (board[x][col] == value) return false;
		}
		// row validation
		for (int row = 0; row < 9; row ++) {
			if (board[x][row] == value) return false;
		}
		// 3 x 3 matrix
		int r = (x/3) * 3;
		int c = (y/3) * 3;
		for (int row = r; row < r+3; row ++) {
			for(int col = c; col < c+3; col ++) {
				if (board[row][col] == value) return false;
			}
		}
		
		
		return true;
		
	}
	
	
}
