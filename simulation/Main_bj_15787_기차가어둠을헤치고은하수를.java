package simulation;

import java.util.*;
import java.io.*;

public class Main_bj_15787_기차가어둠을헤치고은하수를 {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		boolean[][] train = new boolean[N][20];
		
		for(int i =0 ; i < M ; i++) {
			st = new StringTokenizer(br.readLine());
			int inst = Integer.parseInt(st.nextToken());	
			int num = Integer.parseInt(st.nextToken())-1;
			switch(inst) {
				case 1:{
					int x = Integer.parseInt(st.nextToken())-1;
					train[num][x] = true;
					break;
				}	
				case 2:{
					int x = Integer.parseInt(st.nextToken())-1;
					train[num][x] = false;
					break;
				}
				case 3:{
					for(int k = 18 ; k >= 0 ; k--) {
						train[num][k+1] = train[num][k];
					}
					train[num][0] = false;
					break;
				}
				case 4:{
					for(int k = 1 ; k < 20 ; k++) {
						train[num][k-1] = train[num][k];
					}
					train[num][19] = false;
					break;
				}
			}
		}
		
		List<String> passStat = new ArrayList<String>();
		next:for(int i =0 ; i < N ; i++) {
			StringBuilder sb =  new StringBuilder();
			for(int j =0 ; j < 20 ; j ++) {
				sb.append(train[i][j]?1:0);
			}
			for(String str: passStat) {
				if(str.equals(sb.toString())) continue next;
			}
			passStat.add(sb.toString());
		}
		System.out.println(passStat.size());
	}

}
