package graph_traversal;

import java.io.*;
import java.util.*;

public class Solution_1767_프로세서연결하기 {
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	static int N, maxCore, minLen;
	static int[][] maxi;
	static List<int[]> core;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc<=T ; tc++) {
			N = Integer.parseInt(br.readLine());
			maxi = new int[N][N];
			core = new ArrayList<int[]>();
			for(int i =0 ; i < N ; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine(), " ");
				for(int j = 0 ; j < N ; j++) {
					maxi[i][j] = Integer.parseInt(st.nextToken());
					if(maxi[i][j] == 1 && i!=0&&i!=N-1 && j!=0&&j!=N-1) {
						core.add(new int[] {i, j});
					}
				}
			}
			maxCore = Integer.MIN_VALUE;
			minLen = Integer.MAX_VALUE;
			
			setLink(0,0,0);
			
			sb.append("#").append(tc).append(" ").append(minLen).append("\n");
		}
		System.out.println(sb);
	}
	private static void setLink(int idx, int cnt, int len) {
		if(idx == core.size()) {
			if(maxCore < cnt) {
				maxCore = cnt;
				minLen = len;
			} else if(maxCore == cnt) {
				minLen = Math.min(minLen, len);
			}
			return ;
		}
		
		int ci = core.get(idx)[0];
		int cj = core.get(idx)[1];
		
		for(int d = 0 ; d < 4; d++) {
			int ni = ci, nj = cj;
			int count = 0 ;
			while(true) {
				ni += di[d];
				nj += dj[d];
				if(ni<0||ni>=N || nj<0||nj>=N) break;
				if(maxi[ni][nj] == 1) {
					count = 0;
					break;
				}
				count ++;
			}
			
			if(count == 0) setLink(idx+1, cnt, len);
			else {
				ni = ci;
				nj = cj;
				for(int i = 0 ; i < count ; i++) {
					ni += di[d];
					nj += dj[d];
					maxi[ni][nj] = 1;
				}
				
				setLink(idx+1, cnt+1, len+count);
				
				ni = ci;
				nj = cj;
				for(int i = 0 ; i < count ; i++) {
					ni += di[d];
					nj += dj[d];
					maxi[ni][nj] = 0;
				}
			}
			
		}
	}

}
