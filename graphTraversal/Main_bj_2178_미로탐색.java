package graphTraversal;

import java.util.*;
import java.io.*;

public class Main_bj_2178_미로탐색 {
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,-1,0,1};
	static int N, M, res;
	static char[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		
		for(int i =0 ; i < N ; i++) {
			map[i] = br.readLine().toCharArray();
		}
		
		search();
		System.out.println(res);
	}
	
	private static void search() {
		Queue<int[]> q = new ArrayDeque<int[]>();
		boolean[][] visited = new boolean[N][M];
		q.add(new int[] {0,0,1});
		visited[0][0] = true;
		while(!q.isEmpty()) {
			int[] tmp = q.poll();
			int i = tmp[0];
			int j = tmp[1];
			int dep = tmp[2];
			for(int d = 0 ; d < 4 ; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(0<=ni&&ni<N && 0<=nj&&nj<M ) {
					if(!visited[ni][nj] && map[ni][nj] == '1') {
						if(ni == N-1 && nj == M-1) {
							res = dep+1;
							return;
						}
						q.offer(new int[] {ni, nj, dep+1});
						visited[ni][nj] = true;
					}
				}
			}
		}
	}

}
