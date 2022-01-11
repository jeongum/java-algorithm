package graph_traversal;

import java.util.*;
import java.io.*;

public class Main_bj_17144_미세먼지안녕 {
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	static int R,C,T;
	static int[][] map;
	static int[][] spreaded;
	static List<Integer> cleaner;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		spreaded = new int[R][C];
		cleaner = new ArrayList<Integer>();
		for(int i =0 ; i < R ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j =0 ; j < C ; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) cleaner.add(i);
			}
		}
		for(int i =0 ; i < T ; i++) {
			spreadDust();
			cleanAir();
			for(int k =0 ; k < R ; k++) {
				for(int j =0 ; j < C ; j++) {
					map[k][j] = spreaded[k][j];
					spreaded[k][j] = 0;
				}
			}
		}
		int res = 0;
		for(int i =0 ; i < R; i++) {
			for(int j =0 ; j <C ; j++) {
				if(map[i][j] != -1) res += map[i][j];
			}
		}
		System.out.println(res);
	}
	
	private static void cleanAir() {
		int top = cleaner.get(0);
		int bottom = cleaner.get(1);
		
		//상향순환
		for(int i = top-1 ; i > 0 ; i--) {
			spreaded[i][0] = spreaded[i-1][0];
		}
		for(int i = 0 ; i < C-1; i++) {
			spreaded[0][i] = spreaded[0][i+1];
		}
		for(int i = 0 ; i < top; i++) {
			spreaded[i][C-1] = spreaded[i+1][C-1];
		}
		for(int i = C-1 ; i > 1; i--) {
			spreaded[top][i] = spreaded[top][i-1];
		}
		spreaded[top][1] = 0;
		
		
		//하향순환
		for(int i = bottom+1 ; i < R-1 ; i++) {
			spreaded[i][0] = spreaded[i+1][0];
		}
		for(int i = 0 ; i < C-1; i++) {
			spreaded[R-1][i] = spreaded[R-1][i+1];
		}
		for(int i = R-1 ; i > bottom; i--) {
			spreaded[i][C-1] = spreaded[i-1][C-1];
		}
		for(int i = C-1 ; i > 1; i--) {
			spreaded[bottom][i] = spreaded[bottom][i-1];
		}
	
		spreaded[bottom][1] = 0;
	}

	private static void spreadDust() {
		for(int i =0 ; i < R ; i++) {
			for(int j = 0 ; j < C ; j++) {
				if(map[i][j] == 0 ) continue;
				if(map[i][j] == -1) {
					spreaded[i][j] = -1;
					continue;
				}
				spreaded[i][j] += map[i][j];
				for(int d = 0 ; d< 4 ; d++) {
					int ni = i+di[d];
					int nj = j+dj[d];
					if(0<=ni&&ni<R && 0<=nj&&nj<C && map[ni][nj]!=-1 ) {
						spreaded[ni][nj] += (int)Math.floor((map[i][j])/5.0);
						spreaded[i][j] -= (int)Math.floor((map[i][j])/5.0);
					}
				}
			}
		}
	}
}
