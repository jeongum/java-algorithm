package shortest_path;

import java.util.*;
import java.io.*;

public class BOJ_1976_여행가자 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        boolean[][] can_go = new boolean[N][N];

        for(int i = 0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0 ; j < N ; j++){
                can_go[i][j] = can_go[j][i] = (Integer.parseInt(st.nextToken())==1)?true:false;
            }
            can_go[i][i] = true;
        }

        for(int k = 0 ; k < N ; k++){
            for(int i = 0 ; i < N ; i++){
                for(int j = 0 ; j < N ; j++){
                    if(can_go[i][k] && can_go[k][j]){
                        can_go[i][j] = true;
                    }
                }
            }
        }
        boolean go = true;
        st = new StringTokenizer(br.readLine());
        int to = Integer.parseInt(st.nextToken())-1;
        for(int i = 0 ; i < M-1 ; i++){
            int from = Integer.parseInt(st.nextToken())-1;
            if(!can_go[to][from]){
                go = false; break;
            }
            to = from;
        }
        System.out.println((go)?"YES":"NO");
    }
}
