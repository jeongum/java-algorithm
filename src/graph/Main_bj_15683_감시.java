package graph;

import java.io.*;
import java.util.*;

public class Main_bj_15683_감시 {
	static int[] di = {-1,0,1,0};
	static int[] dj = {0,1,0,-1};
	static int N, M, cctv, res;
	static int[][] arr, tmp;
	static int[] dir;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		for(int i =0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j =0 ; j < M ; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] != 0 && arr[i][j] != 6) cctv++;
			}
		}
		dir = new int[cctv];
		res = Integer.MAX_VALUE;
		setDir(0);
		
		System.out.println(res);
	}
	
	private static void setDir(int cnt) {
		if(cnt == cctv) {
			tmp = new int[N][M];
			int cctv_num = 0;
			for(int i = 0 ; i < N ; i++) {
				for(int j =0 ; j < M ; j++) {
					tmp[i][j] = arr[i][j];
				}
			}
			for(int i =0 ; i < N ; i++) {
				for(int j = 0 ; j < M ; j++) {
					if(arr[i][j] != 0 && arr[i][j] != 6) {
						setCCTV(i, j, cctv_num++);
					}
				}
			}
			int hid = 0;
			for(int i =0 ; i < N ; i++) {
				for(int j =0 ; j < M ; j++) {
					if(tmp[i][j] == 0) hid++;
				}
			}
			res = Math.min(hid, res);
			return ;
		}
		for(int i =0 ; i < 4 ; i++) {
			dir[cnt] = i;
			setDir(cnt+1);
		}
	}

	private static void setCCTV(int i, int j, int cctv_num) {
		int ni = i;
		int nj = j;
		int num = arr[i][j];
		
		switch(num) {
		case 1:{
			while(true) {
				ni = ni + di[dir[cctv_num]];
				nj = nj + dj[dir[cctv_num]];
				if(ni<0 || ni>=N || nj<0 || nj>=N || tmp[ni][nj] == 6) break;
				tmp[ni][nj] = -1;
			}
			break;
		}
		case 2:{
			while(true) {
				ni = ni + di[dir[cctv_num]];
				nj = nj + dj[dir[cctv_num]];
				if(ni<0 || ni>=N || nj<0 || nj>=N || tmp[ni][nj] == 6) break;
				tmp[ni][nj] = -1;
			}
			while(true) {
				ni = ni + di[(dir[cctv_num]+2)%4];
				nj = nj + dj[(dir[cctv_num]+2)%4];
				if(ni<0 || ni>=N || nj<0 || nj>=N || tmp[ni][nj] == 6) break;
				tmp[ni][nj] = -1;
			}
			break;
		}
		case 3:{
			while(true) {
				ni = ni + di[dir[cctv_num]];
				nj = nj + dj[dir[cctv_num]];
				if(ni<0 || ni>=N || nj<0 || nj>=N || tmp[ni][nj] == 6) break;
				tmp[ni][nj] = -1;
			}
			while(true) {
				ni = ni + di[(dir[cctv_num]+1)%4];
				nj = nj + dj[(dir[cctv_num]+1)%4];
				if(ni<0 || ni>=N || nj<0 || nj>=N || tmp[ni][nj] == 6) break;
				tmp[ni][nj] = -1;
			}
			break;
		}
		case 4:{
			while(true) {
				ni = ni + di[dir[cctv_num]];
				nj = nj + dj[dir[cctv_num]];
				if(ni<0 || ni>=N || nj<0 || nj>=N || tmp[ni][nj] == 6) break;
				tmp[ni][nj] = -1;
			}
			while(true) {
				ni = ni + di[(dir[cctv_num]+1)%4];
				nj = nj + dj[(dir[cctv_num]+1)%4];
				if(ni<0 || ni>=N || nj<0 || nj>=N || tmp[ni][nj] == 6) break;
				tmp[ni][nj] = -1;
			}
			while(true) {
				ni = ni + di[(dir[cctv_num]+2)%4];
				nj = nj + dj[(dir[cctv_num]+2)%4];
				if(ni<0 || ni>=N || nj<0 || nj>=N || tmp[ni][nj] == 6) break;
				tmp[ni][nj] = -1;
			}
			break;
		}
		case 5:{
			while(true) {
				ni = ni + di[dir[cctv_num]];
				nj = nj + dj[dir[cctv_num]];
				if(ni<0 || ni>=N || nj<0 || nj>=N || tmp[ni][nj] == 6) break;
				tmp[ni][nj] = -1;
			}
			while(true) {
				ni = ni + di[(dir[cctv_num]+1)%4];
				nj = nj + dj[(dir[cctv_num]+1)%4];
				if(ni<0 || ni>=N || nj<0 || nj>=N || tmp[ni][nj] == 6) break;
				tmp[ni][nj] = -1;
			}
			while(true) {
				ni = ni + di[(dir[cctv_num]+2)%4];
				nj = nj + dj[(dir[cctv_num]+2)%4];
				if(ni<0 || ni>=N || nj<0 || nj>=N || tmp[ni][nj] == 6) break;
				tmp[ni][nj] = -1;
			}
			while(true) {
				ni = ni + di[(dir[cctv_num]+3)%4];
				nj = nj + dj[(dir[cctv_num]+3)%4];
				if(ni<0 || ni>=N || nj<0 || nj>=N || tmp[ni][nj] == 6) break;
				tmp[ni][nj] = -1;
			}
			break;
		}
		}
	}
}
