package simulation;

import java.util.*;
import java.io.*;

public class Main_bj_23289_온풍기안녕 {
	static int[] di = {0,0,-1,1};
	static int[] dj = {1,-1,0,0};
	static int[][] sdi = {{-1,0,1},{-1,0,1},{-1,-1,-1},{1,1,1}};
	static int[][] sdj = {{1,1,1},{-1,-1,-1},{-1,0,1},{-1,0,1}};
	static int R,C,K,W;
	static int[][] map;
	static HashSet<Integer> wall;
	static List<int[]> inspect;
	static List<int[]> heater;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[R][C];
		inspect = new ArrayList<int[]>();
		heater = new ArrayList<int[]>();
		for(int i =0 ; i < R ; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j =0 ; j < C ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 5) {
					inspect.add(new int[] {i, j});
				}
				if(0<map[i][j] && map[i][j]<5) {
					heater.add(new int[] {i, j, map[i][j]-1});
				}
			}
		}
		
		W = Integer.parseInt(br.readLine());
		wall = new HashSet<>();
		for(int i =0 ; i < W ; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			if(d == 0) {
				wall.add(wallHash(x, y, x-1, y));
				wall.add(wallHash(x-1, y, x, y));
			}else {
				wall.add(wallHash(x,y,x,y+1));
				wall.add(wallHash(x,y+1,x,y));
			}
		}
		
		int choco = 0;
		
		while(choco<=100) {
			heat();
			adjustTemp();
			outlineTemp();
			choco++;
			if(canEnd()) break;
		}
		
		System.out.println(choco);
	}

	private static boolean canEnd() {
		for(int[] tmp : inspect) {
			if(map[tmp[0]][tmp[1]]<K) return false;
		}
		return true;
	}

	private static Integer wallHash(int x, int y, int x2, int y2) {
		return x*1000000 + y*10000 + x2*100 + y2;
	}

	private static void heat() {
		int[][] tmpMap = new int[R][C];
		for(int[] h : heater) {
			boolean[][] visited = new boolean[R][C];
			Queue<int[]> q = new ArrayDeque<int[]>();
			int power = 5;
			int ci = h[0] + sdi[h[2]][1];
			int cj = h[1] + sdj[h[2]][1];
			q.add(new int[] {ci, cj});
			while(!q.isEmpty()) {
				int size = q.size();
				while(size-- != 0) {
					int[] now = q.poll();
					tmpMap[now[0]][now[1]] += power;
					for(int d =0 ; d < 3; d++) {
						int ni = now[0] + sdi[h[2]][d];
						int nj = now[1] + sdj[h[2]][d];
						int ti = now[0];
						int tj = now[1];
						if(h[2] < 2) ti += sdi[h[2]][d];
						else tj += sdj[h[2]][d];
						if(inRange(ni,nj) && !visited[ni][nj]) {
							if(wall.contains(wallHash(ti, tj, ni, nj)) || wall.contains(wallHash(ti,tj,h[0],h[1]))) continue;
							visited[ni][nj] = true;
							q.add(new int[] {ni, nj});
						}
					}
				}
				if(--power == 0) break;
			
			}
			for(int i =0 ; i < R ; i++) {
				for(int j =0 ; j < C; j++) {
					map[i][j] += tmpMap[i][j];
				}
			}
		}
	}

	private static void adjustTemp() {
		int tmpMap[][] = new int[R][C];
		for(int i =0 ; i < R; i++) {
			for(int j =0 ; j < R ; j++) {
				for(int d = 0 ; d < 4 ; d++) {
					int ni = i + di[d];
					int nj = j + dj[d];
					if(inRange(ni, nj)) {
						if(wall.contains(wallHash(i, j, ni, nj))) continue;
						if(map[i][j] < map[ni][nj]) continue; 
						int ded = (map[i][j] - map[ni][nj])/4;
						tmpMap[i][j] -= ded;
						tmpMap[ni][nj] += ded;
					}
				}
			}
		}
		for(int i =0 ; i < R ; i++) {
			for(int j =0 ; j < C; j++) {
				map[i][j] += tmpMap[i][j];
			}
		}
	}
	
	private static void outlineTemp() {
		for(int i = 0 ; i < R ; i++) {
			map[i][0] = map[i][0]>0?map[i][0]--:0;
			map[i][C-1] = map[i][C-1]>0?map[i][C-1]--:0;
		}
		for(int i = 0 ; i < C-1 ; i++) {
			map[0][i] = map[0][i]>0?map[0][i]--:0;
			map[R-1][i] = map[R-1][i]>0?map[R-1][i]--:0;
		}
	}
	
	private static boolean inRange(int i, int j) {
		if(0<=i&&i<R && 0<=j&&j<C) 
			return true;
		return false;
	}

}
