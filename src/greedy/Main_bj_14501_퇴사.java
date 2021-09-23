package greedy;

import java.io.*;
import java.util.*;

public class Main_bj_14501_퇴사 {
	static int N;
	static int[] T, P;
	static boolean[] isSelected;
	static int profit = 0;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		T = new int[N];
		P= new int[N];
		for(int i =0 ; i < N ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine()," ");
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}
		
		isSelected = new boolean[N];
		schedule(0);
		System.out.println(profit);
	}
	
	private static void schedule(int i) {
		if(i > N) return;
		if(i == N) {
			int tmp = 0;
			for(int j = 0 ; j < N; j++) {
				if(isSelected[j]) {
					tmp += P[j];
				}
			}
			profit = Math.max(tmp, profit);
			return;
		}
		isSelected[i] = true;
		schedule(i + T[i]);
		isSelected[i] = false;
		schedule(i+1);
	}
}
