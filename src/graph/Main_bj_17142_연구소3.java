package graph;

import java.util.*;
import java.io.*;

public class Main_bj_17142_연구소3 {
	static int[] di = {-1, 0, 1, 0};
	static int[] dj = {0,1,0,-1};
	static int N, M, emptyCnt, time=Integer.MAX_VALUE;
	static int[][] map;
	static boolean[][] visited;
	static List<int[]> virus;
	static int[] select;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		virus = new ArrayList<int[]>();
		for(int i =0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j =0 ; j < N ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 0) emptyCnt++;
				if(map[i][j] == 2) {
					virus.add(new int[] {i, j});
				}
			}
		}
		if(emptyCnt == 0) System.out.println("0");
		else {
			select = new int[M];
			selectVirus(0,0);
			System.out.println((time == Integer.MAX_VALUE)?-1:time);
		}
	}
	private static void selectVirus(int start, int idx) {
		if(idx == M) {
			visited = new boolean[N][N];
			spread(emptyCnt);
			return;
		}
		for(int i = start ; i < virus.size() ; i++) {
			select[idx] = i;
			selectVirus(i+1, idx+1);
		}
	}
	private static void spread(int empty) {
		Queue<int[]> q = new ArrayDeque<int[]>();
		for(int i =0 ; i < M ; i++) {
			int[] tmp = virus.get(select[i]);
			q.offer(new int[] {tmp[0], tmp[1], 0});
			visited[tmp[0]][tmp[1]] = true;
		}
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			for(int d = 0 ; d< 4 ; d++) {
				int ni = cur[0] + di[d];
				int nj = cur[1] + dj[d];
				if(0<=ni&&ni<N && 0<=nj&&nj<N && !visited[ni][nj]) {
					if(map[ni][nj] == 1) continue;
					visited[ni][nj] = true;
					q.offer(new int[] {ni, nj, cur[2]+1});
					if(map[ni][nj] == 0) empty--;
					if(empty == 0) {
						time = Math.min(cur[2]+1, time);
						return;
					}
				}
			}
		}
	}
}
