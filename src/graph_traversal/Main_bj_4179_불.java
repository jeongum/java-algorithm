package graph_traversal;

import java.util.*;
import java.io.*;

public class Main_bj_4179_불 {
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,-1,0,1};
	static int N,M, res;
	static List<int[]> fire;
	static char[][] map;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		fire = new ArrayList<int[]>();
		int ji = 0 , jj = 0;
		
		for(int i =0 ; i < N ; i++) {
			String str = br.readLine();
			for(int j =0 ; j < M ; j++) {
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'J') {
					ji = i;
					jj = j;
					map[i][j] = '.';
				}
				if(map[i][j] == 'F') {
					fire.add(new int[] {i, j});
				}
			}
		}
		
		res = -1;
		maze(ji, jj);
		
		System.out.println(res==-1?"IMPOSSIBLE":res);
	}
	
	
	private static void maze(int ji, int jj) {
		Queue<int[]> jihun = new ArrayDeque<>();
		boolean[][] visited = new boolean[N][M];
		jihun.add(new int[] {ji, jj, 1});
		visited[ji][jj] = true;
		int sec = 1;
		while(!jihun.isEmpty()) {
			int[] tmp = jihun.poll();
			int i = tmp[0];
			int j = tmp[1];

			// 불 확산
			if(sec != tmp[2]) {
				sec = tmp[2];
				spreadFire();
			}
			
			// 가려고 하는 길에 불이 확산 되어 있으면
			if(map[i][j] == 'F') continue;
			
			// 종료 조건
			if(i ==0 || i == N-1 || j == 0 || j == M-1) {
				res = sec;
				return;
			}
			
			for(int d = 0 ; d < 4 ; d++) {
				int ni = i + di[d];
				int nj = j + dj[d];
				if(0<=ni&&ni<N && 0<=nj&&nj<M && !visited[ni][nj] && map[ni][nj] == '.') {
					jihun.offer(new int[] {ni, nj, sec+1});
					visited[ni][nj] = true;
				}
			}
		}
	}
	
	
	private static void spreadFire() {
		List<int[]> f = new ArrayList<int[]>();
		for(int[] tmp : fire) {
			for(int d = 0 ; d < 4 ; d++) {
				int ni = tmp[0] + di[d];
				int nj = tmp[1] + dj[d];
				if(0<=ni&&ni<N && 0<=nj&&nj<M && map[ni][nj] == '.') {
					map[ni][nj] = 'F';
					f.add(new int[] {ni, nj});
				}
			}
		}
		fire.clear();
		fire.addAll(f);
	}

}
