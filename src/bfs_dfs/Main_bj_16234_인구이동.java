package bfs_dfs;

import java.util.*;
import java.io.*;

public class Main_bj_16234_인구이동 {
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	static int N, L, R;
	static int[][] map, move;
	static boolean[][] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		R = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		for(int i =0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		System.out.println(checkBorder());
	}
	public static int checkBorder() {			// 인구이동이 일어날 수 있는지 없는지
		int day = 0;
		boolean keep = false;
		while(true) {
			visited = new boolean[N][N];
			keep = false;	// 인구이동이 일어났는가?
			for(int i =0 ; i < N ; i++) {
				for (int j = 0; j < N; j++) {
					if(visited[i][j]) continue;	
					if(canOpen(i, j)) keep = true;	
				}
			}
			if(!keep) break; // 인구 이동이 한번이라도 일어 났으면 다음날도 지속 되어야 함.
			day++;
		}
		return day;
	}
	private static boolean canOpen(int i, int j) {
		Queue<int[]> q = new ArrayDeque<int[]>();	
		List<int[]> pos = new ArrayList<int[]>();	// 국경을 열 나라의 좌표를 저장해 놓은 list
		int pop = map[i][j];
		q.offer(new int[] {i, j});
		pos.add(new int[] {i, j});	// 현재 자신의 나라 정보 add
		visited[i][j] = true;
		while(!q.isEmpty()) {		// bfs
			int[] cur = q.poll();
			int ci = cur[0];
			int cj = cur[1];
			for(int d = 0 ; d < 4 ; d++) {
				int ni = ci + di[d];
				int nj = cj + dj[d];
				if(0<=ni&&ni<N && 0<=nj&&nj<N && !visited[ni][nj]) {	// 방문하지 않았었고
					if(L<=Math.abs(map[ci][cj] - map[ni][nj])	// 두 인구수의 차가 L 이상이며
						&&Math.abs(map[ci][cj] - map[ni][nj])<=R) {	// R 이하일 경우
						pop += map[ni][nj];	// 총 인구수에 현재 ni,nj의 인구수를 더해줌
						visited[ni][nj] = true;	// 방문처리
						pos.add(new int[] {ni, nj});	// 다음 방문할 좌표로써 q에 offer
						q.offer(new int[] {ni, nj});	// 국경을 열 리스트에 add
					}
				}
			}
		}
		
		if(pos.size() == 1) return false;	// 처음넣은 나라만 존재 한다면, 그 이후에 탐색을 실패하였던 것이므로 false
		
		int newpop = pop/pos.size();	// 새롭게 바뀔 인구 수
		for(int[] tmp : pos) {	// 국경을 연 나라마다
			map[tmp[0]][tmp[1]] = newpop;	// 인구 수 refresh
		}
		return true;
	}
}
