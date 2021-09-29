package graph;

import java.io.*;
import java.util.*;

public class Main_bj_4485_녹색옷입은애가젤다지 {
	static final int INF = Integer.MAX_VALUE/2;
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	static int N, res;
	static int[][] map, dis;
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = 0;
		while(true) {
			N = Integer.parseInt(br.readLine());
			if(N == 0) break;
			map = new int[N][N];
			dis = new int[N][N];
			for(int i = 0 ; i < N ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine()," ");
				for(int j =0 ; j < N ; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					dis[i][j] = INF;
				}
			}
			res = Integer.MAX_VALUE;
			visited = new boolean[N][N];
			findWay();
			sb.append("Problem ").append(++tc).append(": ").append(dis[N-1][N-1]).append("\n");
		}
		System.out.println(sb.toString());
	}

	private static void findWay() {
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return Integer.compare(o1[2], o2[2]);
			}
		});
 		dis[0][0] = map[0][0];
		pq.offer(new int[] {0,0,dis[0][0]});
		while(!pq.isEmpty()) {
			int[] cur = pq.poll();
			for(int d = 0 ; d< 4 ; d++) {
				int ni = cur[0] + di[d];
				int nj = cur[1] + dj[d];
				if(0<=ni&&ni<N && 0<=nj&&nj<N && !visited[ni][nj]) {
					if(dis[ni][nj] > dis[cur[0]][cur[1]]+map[ni][nj]) {
						dis[ni][nj] = dis[cur[0]][cur[1]]+map[ni][nj];
						pq.offer(new int[] {ni, nj, dis[ni][nj]});
					}
				}
			}
		}
	}

	/* DFS: 시간초과 */
	/*
	private static void findWay(int i, int j, int cost) {
		if(i==N-1 && j==N-1) {
			res = Math.min(res, cost);
			return;
		}
		for(int d = 0; d < 4 ; d++) {
			int ni = i+di[d];
			int nj = j+dj[d];
			if(0<=ni&&ni<N && 0<=nj&&nj<N && !visited[ni][nj] && res > cost+map[ni][nj]) {
				visited[ni][nj] = true;
				findWay(ni, nj, cost+map[ni][nj]);
				visited[ni][nj] = false;
			}
		}
	} */
}
