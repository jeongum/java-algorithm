package bruteForce;

import java.util.*;
import java.io.*;

public class Main_bj_15686_치킨배달_0111 {
	static int N, M, res = Integer.MAX_VALUE;
	static List<int[]> house, chick;
	static int[] selected;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		house = new ArrayList<int[]>();
		chick = new ArrayList<int[]>();
		selected = new int[M];
		
		for(int i = 0 ; i < N ; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0 ; j < N ; j++) {
				int n = Integer.parseInt(st.nextToken());
				if(n == 1) {
					house.add(new int[] {i, j});
				}
				else if(n == 2) {
					chick.add(new int[] {i, j});
				}
			}
		}
		
		chooseChick(0,0);
		
		System.out.println(res);
		
	}
	private static void chooseChick(int idx, int num) {
		if(idx == M) {
			res = Math.min(chickDist(), res);
			return;
		}
		for(int i = num ; i < chick.size() ; i++) {
			selected[idx] = i;
			chooseChick(idx+1, i+1);
		}
	}
	private static int chickDist() {
		int tDis = 0;
		for(int[] h : house) {
			int minDis = Integer.MAX_VALUE;
			for(int i =0 ; i < M ; i++) {
				minDis = Integer.min(minDis, Math.abs(h[0]-chick.get(selected[i])[0]) + Math.abs(h[1]-chick.get(selected[i])[1]));
			}
			tDis += minDis;
		}
		return tDis;
	}

}
