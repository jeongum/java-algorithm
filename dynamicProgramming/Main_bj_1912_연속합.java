package dynamicProgramming;

import java.util.*;
import java.io.*;
public class Main_bj_1912_연속합 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] dp = new int[N];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N ; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[0] = arr[0];
		int max = Integer.MIN_VALUE;
		for(int i =1 ; i < N ; i++) {
			max = Integer.max(max, dp[i]);
		}
		
	}

}
