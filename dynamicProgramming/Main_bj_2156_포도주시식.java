package dynamicProgramming;

import java.io.*;

public class Main_bj_2156_포도주시식 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] grape = new int[N];
		for(int i =0 ; i < N ; i++) {
			grape[i] = Integer.parseInt(br.readLine());
		}
		
		int[] dp = new int[N];
		for(int i =0 ; i < N ; i++) {
			if(i == 0) dp[i] = grape[0];
			else if(i == 1) dp[i] = grape[0] + grape[1];
			else if(i == 2) dp[i] = Integer.max(dp[1], Integer.max(dp[0]+grape[i], grape[i-1]+grape[i]));
			else {
				dp[i] = Integer.max(dp[i-1], Integer.max(dp[i-2]+grape[i], dp[i-3]+grape[i-1]+grape[i]));
			}
		}
		
		System.out.println(dp[N-1]);
	}

}
