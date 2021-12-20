package backtracking;

import java.util.*;
import java.io.*;

public class Main_2580_스도쿠 {
	static int[][] map;
	static final int N = 9;
	static Queue<int[]> blank;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		blank = new ArrayDeque<int[]>();
		map = new int[N][N];
		for(int i =0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j =0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		sudoku(0,0);
	}
	private static void sudoku(int r, int c) {
		if(c == 9) {
			sudoku(r+1, 0);
			return;
		}
		if(r == 9) {
			for(int i =0 ; i < N ; i++) {
				for(int j =0 ; j < N ; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			System.exit(0);
		}
		if(map[r][c] == 0) {
			for(int d = 1; d <= 9 ; d++) {
				if(possible(r,c,d)) {
					map[r][c] = d;
					sudoku(r,c+1);
				}
			}
			map[r][c] = 0;
			return ;
		}
		
		sudoku(r, c+1);
	}
	private static boolean possible(int r, int c, int d) {
		for(int i =0 ; i < N ; i++) {
			if(map[i][c] == d) return false;
			if(map[r][i] == d) return false;
		}
		
		int ti = (r/3)*3;
		int tj = (c/3)*3;
		
		for(int i = 0 ; i < 3 ; i++) {
			for(int j =0 ; j < 3 ; j++) {
				if(map[ti+i][tj+j] == d) return false;
			}
		}
		return true;
	}
}
