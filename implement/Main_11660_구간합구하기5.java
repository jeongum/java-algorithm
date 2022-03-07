package implement;

import java.util.*;
import java.io.*;

public class Main_11660_구간합구하기5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        int[][] sum = new int[N][N];
        for(int i =0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j =0 ; j < N ; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(i == 0 && j == 0){
                    sum[i][j] = map[i][j];
                }
                else if(j == 0){
                    sum[i][j] = sum[i-1][N-1]+map[i][j];
                } else{
                    sum[i][j] = sum[i][j-1] + map[i][j];
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken())-1;
            int y1 = Integer.parseInt(st.nextToken())-1;
            int x2 = Integer.parseInt(st.nextToken())-1;
            int y2 = Integer.parseInt(st.nextToken())-1;

            int partial = 0;
            for(int j = x1 ; j <= x2 ; j++){
                if(y1 == 0 && j == 0) partial += sum[j][y2];
                else if(y1 == 0) partial += (sum[j][y2] - sum[j-1][N-1]);
                else partial += (sum[j][y2]-sum[j][y1-1]);
            }
            sb.append(partial+"\n");
        }
        System.out.println(sb.toString());
    }
}
