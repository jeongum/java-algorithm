package backtracking;

import java.io.*;

public class Main_9663_NQueen {
	
	static int N, res;
	static int[] col;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		col = new int[N];
		res = 0;
		
		nQueen(0);
		
		System.out.println(res);
	}
	
	private static void nQueen(int row) {
		if(row == N) {
			res ++; return;
		}
		
		for(int c = 0 ; c < N ; c ++) {
			col[row] = c;
			if(isPossible(row)) nQueen(row+1);
		}
	}

	private static boolean isPossible(int row) {
		for(int i =0 ; i < row ; i++) {
			if((col[i] == col[row]) || (Math.abs(col[i] - col[row]) == row-i)) return false;
		}
		return true;
	}

}
