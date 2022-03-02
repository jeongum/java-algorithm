package dynamicProgramming;

import java.util.*;
import java.io.*;

public class Main_11060_점프점프 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] jump = new int[N];
        int[] dp = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0 ; i < N ; i++){
            jump[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for(int i =0 ; i < N-1 ; i++){
          for(int j = 1 ; j <= jump[i] ; j++){
              if(dp[i] != Integer.MAX_VALUE && i + j < N) dp[i+j] = Math.min(dp[i]+1, dp[i+j]);
          }
        }

        System.out.println(dp[N-1]==Integer.MAX_VALUE?-1:dp[N-1]);
    }
}
