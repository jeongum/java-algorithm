package graph_traversal;

import java.util.*;
import java.io.*;

public class BOJ_2206_벽부수고이동하기 {
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,-1,0,1};
    static int N, M;
    static boolean[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];

        for(int i =0 ;i < N ; i++){
            String str = br.readLine();
            for(int j = 0 ; j < M ; j++){
                map[i][j] = str.charAt(j)=='1'?true:false;
            }
        }

        System.out.println(findPath());

    }

    private static int findPath() {
        int result = -1;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[2][N][M];
        q.offer(new int[]{0,0,1,0});
        visited[0][0][0] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int i = cur[0];
            int j = cur[1];
            int depth = cur[2];
            int isBreak = cur[3];
            if(i == N-1 && j == M-1){
                result = depth;
                break;
            }
            for(int d = 0 ; d < 4 ; d++){
                int ni = i + di[d];
                int nj = j + dj[d];
                if(0<=ni&&ni<N && 0<=nj&&nj<M){
                    if(map[ni][nj] && isBreak == 0){  // 벽이고 지금까지 부순적이 없다면
                        visited[1][ni][nj] = true;
                        q.offer(new int[]{ni, nj, depth+1, 1});
                    } else if(!map[ni][nj] && !visited[isBreak][ni][nj]) {   // 벽이 아니면
                        visited[isBreak][ni][nj] = true;
                        q.offer(new int[]{ni, nj, depth+1, isBreak});
                    }
                }
            }

        }
        return result;
    }
}
