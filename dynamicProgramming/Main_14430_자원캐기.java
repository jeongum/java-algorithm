package dynamicProgramming;

import java.util.*;
import java.io.*;

public class Main_14430_자원캐기 {
    static int[] di = {0,1};
    static int[] dj = {1,0};
    static int N, M, res = Integer.MIN_VALUE;
    static boolean[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        int[][] mine = new int[N][M];
        for(int i =0 ;i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0 ;j < M ; j++){
                map[i][j] = st.nextToken().equals("0")?false:true;
            }
        }
        for(int i = 0 ; i < N ; i++){
            for(int j =0 ; j < M ; j++){
                if(1<=i&&i<N) mine[i][j] = Math.max(mine[i-1][j], mine[i][j]);
                if(1<=j&&j<M) mine[i][j] = Math.max(mine[i][j-1], mine[i][j]);
                if(map[i][j]) mine[i][j] ++;
            }
        }
        System.out.println(mine[N-1][M-1]);
    }
}
