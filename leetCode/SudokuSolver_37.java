package leetCode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SudokuSolver_37 {
	
	
	
	static char board[][];
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		System.out.println("run");
		board = new char[9][9];
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		for (int i = 0; i < 9; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int k = 0; k < 9; k ++) {
				board[i][k] = (char) (Integer.parseInt(st.nextToken())+48);
			}
		}
		
		
		solveSudoku(board);
//		for (char [] array : board) {
//			System.out.println(Arrays.toString(array));
//		}
		
		
	
	}
	public static void solveSudoku(char[][] board) {
		
		sudoku(0,0);
		
        
    }
	public static boolean sudoku(int x, int y) {
	
		if (y == 9) {
			return sudoku(x+1,0);
			
		}
		if (x == 9) {
//			for (char [] array : board) {
//				System.out.println(Arrays.toString(array));
//			}
//			System.exit(0);
			return true;
		}
		
		if (board[x][y] != '0') sudoku(x,y+1);
		else {
			for (int i = 1; i <= 9; i ++) {
				// row // col // 3x3 matrix 
				if (validation(x,y,(char)(i+48))) {
					board[x][y] = (char)(i+48);
					sudoku(x,y+1);
					board[x][y] = '0';
				}
			}
		}
		return false; 
		

	}
	
	public static boolean validation(int x, int y, char value) {
		
		// col
		for (int i = 0; i < 9; i ++ ) {
			if (board[x][i] == value ) {
				return false;
			}
		}
		
		// row
		for (int i = 0; i < 9; i ++) {
			if (board[i][y] == value) {
				return false;
			}
		}
		
		// 3x3
		
		int rowRange = (x/3) * 3;
		int colRange = (y/3) * 3;
		
		for (int i = rowRange; i < rowRange+3; i++) {
			for (int k = colRange; k < colRange+3; k++) {
				if (board[i][k] == value) return false;
			}
		}
		
		return true;
	}

}
