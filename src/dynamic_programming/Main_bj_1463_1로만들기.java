package dynamic_programming;

import java.util.*;
import java.io.*;

public class Main_bj_1463_1로만들기 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] dp = new int[N+1];
		
		Arrays.fill(dp, Integer.MAX_VALUE);
		
		for(int i = 0 ; i <= N ; i++) {
			if(i == 0 || i == 1) dp[i] = 0;
			else if(i == 2 || i == 3) dp[i] = 1;
			else {
				if(i % 2 == 0) dp[i] = Integer.min(dp[i], dp[i/2]+1);
				if(i%3 == 0) dp[i] = Integer.min(dp[i], dp[i/3]+1);
				dp[i] = Integer.min(dp[i], dp[i-1]+1);
			}
		}
		
		System.out.println(dp[N]);
	}	
}
