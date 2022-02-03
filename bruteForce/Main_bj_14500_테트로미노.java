package bruteForce;

import java.util.*;
import java.io.*;

public class Main_bj_14500_테트로미노 {
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,-1,0,1};
	static int[][] oi = {{-1, 0, 1}, {0, -1, 0}, {-1, 0, 1}, {0, 1, 0}};
	static int[][] oj = {{0, 1, 0}, {-1, 0, 1}, {0, -1, 0}, {-1, 0, 1}};
	static int N, M, res;
	static int[][] map;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for(int i =0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0 ; j < M ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[N][M];
		for(int i =0 ; i < N ; i++) {
			for(int j =0 ; j < M ; j++) {
				visited[i][j] = true;
				tetrominoDFS(i, j, 1, map[i][j]);
				tetrominoO(i, j, map[i][j]);
				clearVisited();
			}
		}
		
		System.out.println(res);
	}
	
	private static void clearVisited() {
		for(int i =0 ; i < N ; i++) {
			Arrays.fill(visited[i], false);
		}
	}
	
	private static void tetrominoO(int i, int j, int k) {
		otherD:for(int d = 0 ; d < 4 ; d ++) {
			int sum = k;
			for(int n = 0 ; n < 3 ; n++) {
				int ni = i + oi[d][n];
				int nj = j + oj[d][n];
				if(0<=ni&&ni<N && 0<=nj&&nj<M) {
					sum += map[ni][nj];
				}
				else continue otherD;
			}
			res = Integer.max(res, sum);
		}
	}
	
	private static void tetrominoDFS(int i, int j, int depth, int sum) {
		if(depth == 4) {
			res = Integer.max(res, sum);
			return ; 
		}
		for(int d = 0 ; d < 4 ; d++) {
			int ni = i + di[d];
			int nj = j + dj[d];
			if(0<=ni&&ni<N && 0<=nj&&nj<M && !visited[ni][nj]) {
				visited[ni][nj] = true;
				tetrominoDFS(ni, nj, depth+1, sum+map[ni][nj]);
				visited[ni][nj] = false;
			}
		}
	}
}
