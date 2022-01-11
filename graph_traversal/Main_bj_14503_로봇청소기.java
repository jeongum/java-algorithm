package graph_traversal;

import java.io.*;
import java.util.*;

public class Main_bj_14503_로봇청소기 {
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	static int N, M;
	static int[][] map;
	static int res;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		st = new StringTokenizer(br.readLine(), " ");
		int r = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());
		int dir = Integer.parseInt(st.nextToken());
		
		for(int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j = 0 ; j < M ; j++) {
				map[i][j] =Integer.parseInt(st.nextToken());
			}
		}
		res = 0;
		clean(r, c, dir);
		
		System.out.println(res);
	}
	private static void clean(int r, int c, int dir) {
		if(map[r][c] == 0) {
			map[r][c] = -1;
			res ++;
		}
		boolean flag = false;
		int nd = dir;
		for(int d=0 ; d<4 ; d++) {
			nd = (nd - 1 <0)? 3 : nd -1;
			int ni = r + di[nd];
			int nj = c + dj[nd];
			if(0<=ni&&ni<N && 0<=nj&&nj<M && map[ni][nj] == 0) {
				clean(ni, nj, nd);
				flag = true;
				break;
			}
		}
		if(!flag) {
			int ni = r - di[dir];
			int nj = c - dj[dir];
			if(ni<0||ni>=N || nj<0||nj>=M || map[ni][nj] == 1) return;
			clean(ni, nj, dir);
		}
	}
}
