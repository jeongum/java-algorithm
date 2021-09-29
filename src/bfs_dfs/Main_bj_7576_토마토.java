package bfs_dfs;

import java.util.*;
import java.io.*;

class Elem{
	int i, j, depth;
	public Elem(int i, int j , int depth) {
		this.i = i;
		this.j = j;
		this.depth = depth;
	}
}

public class Main_bj_7576_토마토 {
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	static int N,M;
	static int[][] box;
	static boolean[][] visited;
	static Queue<Elem> tomato;
	static int res = Integer.MIN_VALUE;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomato = new ArrayDeque<Elem>();
		visited = new boolean[N][M];
		box = new int[N][M];
		for(int i =0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j =0 ; j <M ;j++) {
				box[i][j] = Integer.parseInt(st.nextToken());
				if(box[i][j] == 1) {
					tomato.offer(new Elem(i, j, 0));
					visited[i][j] = true;
				}
			}
		}
		calc();
		for(int i =0 ; i < N ; i++) {
			for(int j =0 ; j < M ; j++) {
				if(box[i][j] == 0) {
					System.out.println("-1");
					return;
				}
			}
		}
		System.out.println(res);
	}

	private static void calc() {
		while(!tomato.isEmpty()) {
			Elem tmp = tomato.poll();
			int i = tmp.i;
			int j = tmp.j;
			res = Math.max(res, tmp.depth);
			for(int d = 0 ; d < 4 ; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(0<=ni&&ni<N && 0<=nj&&nj<M && !visited[ni][nj] && box[ni][nj] == 0) {
					visited[ni][nj] = true;
					box[ni][nj] = 1;
					tomato.offer(new Elem(ni, nj, tmp.depth+1));
				}
			}
		}
	}
}
