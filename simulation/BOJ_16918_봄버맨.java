package simulation;

import java.io.*;
import java.util.*;

public class BOJ_16918_봄버맨 {
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, -1, 0, 1};
    static int R,C,N;
    static int[][] map;
    static boolean[][] visited;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        /* 초기상태와 1초 후가 같으니, 바로 폭탄을 바로 2초로 설정 */
        for(int i =0 ; i < R ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < C ; j++){
                map[i][j] = str.charAt(j)=='.'?0:2;
            }
        }

        /* 1부터 시작! N=3이면 2초 후, 3초 후만 봄! 위에서 1초 후 설정 해줬으니까 */
        for(int k = 1 ; k <N ; k++){
            visited = new boolean[R][C];
            for(int i = 0 ; i < R ; i++){
                for(int j =0 ; j < C ; j++){
                    if(visited[i][j]) continue;     // Bomb 할 때 지나간 곳이라면 넘어감
                    if(++map[i][j] == 4){   // 3초가 지난 폭탄이면
                        map[i][j] = 0;  // 0초로 설정하고
                        bomb(i, j); // 폭발!
                    }
                    visited[i][j] = true;
                }
            }
        }

        for (int i =0 ; i < R ; i++){
            for(int j =0 ; j < C ; j++){
                System.out.print(map[i][j]==0?'.':'O');
            }
            System.out.println();
        }
    }

    private static void bomb(int i, int j) {
        for(int d = 0 ; d < 4 ; d++){
            int ni = i + di[d];
            int nj = j + dj[d];
            if(0<=ni&&ni<R && 0<=nj&&nj<C){
                if(!visited[ni][nj] && map[ni][nj] == 3) continue;  // 동시에 폭발될 곳이면, 남겨둠
                map[ni][nj] = 0;
                visited[ni][nj] = true;
            }
        }
    }
}
