package simulation;

import java.io.*;
import java.util.*;

public class Main_bj_20057_마법사상어와토네이도 {
	static int[] di = {0,1,0,-1};
	static int[] dj = {-1,0,1,0};
	
	static int[][] mi = {
			{-1,1,-2,2,0,-1,1,-1,1,0}, 
			{0,0,1,1,3,1,1,2,2,2}, 
			{-1,1,-2,2,0,-1,1,-1,1,0}, 
			{0,0,-1,-1,-3,-1,-1,-2,-2,-2} 
	};
	
	static int[][] mj = {
			{0,0,-1,-1,-3,-1,-1,-2,-2,-2}, 
			{-1,1,-2,2,0,-1,1,-1,1,0}, 
			{0,0,1,1,3,1,1,2,2,2}, 
			{-1,1,-2,2,0,-1,1,-1,1,0} 
	};
	
	static int[] rate =  {1,1,2,2,5,7,7,10,10};
	static int[][] map ;
	static int N, result;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		for(int i =0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j =0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result = 0;
		tornado(N/2,N/2, 0, 0, 0, 1);
		System.out.println(result);
	}

	private static void tornado(int i, int j, int dir, int cnt, int move_cnt, int limit) {
		if(i == 0 && j == 0) return;
		if(cnt == limit) {
			cnt = 0;
			move_cnt ++;
			dir = (dir+1)%4;
		}
		if(move_cnt == 2) {
			move_cnt = 0;
			limit++;
		}
		int ni = i + di[dir];
		int nj = j + dj[dir];
		moveSand(i, j, map[ni][nj], dir);
		map[ni][nj] = 0;
		tornado(ni, nj, dir, cnt+1, move_cnt, limit);
		
	}

	private static void moveSand(int i, int j, int sand, int dir) {
		int y = sand;
		int alpha = 0;
		
		for(int d =0 ; d < 9 ; d++) {
			int ni = i + mi[dir][d];
			int nj = j + mj[dir][d];
			int r = (int) (y * rate[d] * 0.01);
			alpha += r;
			if(0<=ni&&ni<N && 0<=nj&&nj<N) {
				map[ni][nj] += r; 
			}else {
				result += r;
			}
		}
		int ni = i + mi[dir][9];
		int nj = j + mj[dir][9];
		if(0<=ni&&ni<N && 0<=nj&&nj<N) {
			map[ni][nj] += (y-alpha);
		}else {
			result += (y-alpha);
		}
	}

}
