package graphTraversal;

import java.util.*;
import java.io.*;

public class Main_13460_구슬탈출2 {
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, -1, 0, 1};
    static int N,M;
    static boolean[][] map;
    static int res = -1;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];
        int[] red = new int[2];
        int[] blue = new int[2];
        int[] hole = new int[2];

        for(int i =0 ; i < N ; i++){
            String str = br.readLine();
            for(int j =0 ; j < M ; j++){
                if(str.charAt(j) != '#') map[i][j] = true;
                if(str.charAt(j) == 'R'){
                    red[0] = i; red[1] = j;
                }
                if(str.charAt(j) == 'B'){
                    blue[0] = i; blue[1] = j;
                }
                if(str.charAt(j) == 'O'){
                    hole[0] = i; hole[1] = j;
                }
            }
        }

        outBiz(red, blue, hole);

        System.out.println(res);
    }

    private static void outBiz(int[] red, int[] blue, int[] hole) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        q.add(new int[]{red[0], red[1], blue[0], blue[1], -1, 0});
        visited[red[0]][red[1]] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            int i = cur[0];
            int j = cur[1];
            int bi = cur[2];
            int bj = cur[3];
            int dir = cur[4];
            int dircnt = cur[5];
            if(dircnt > 10) return;
            if(i == hole[0] && j == hole[1]){
                if(checkBlue(bi, bj, dir, hole)) return;
                res = dircnt ; return;
            }
            for(int d=0 ; d<4 ; d++){
                int ni = i + di[d];
                int nj = j + dj[d];
                if(inBound(ni, nj) && !visited[ni][nj] && map[ni][nj]){
                    int nbi = bi + di[d];
                    int nbj = bj + dj[d];
                    if(inBound(nbi, nbj) ){
                        if((ni == nbi && nj == nbj) || (nbi == hole[0] && nbj == hole[1])) continue;
                        if(map[nbi][nbj]){
                            if(dir != d) q.offer(new int[]{ni, nj, nbi, nbj, d, dircnt+1});
                            else q.offer(new int[]{ni, nj, nbi, nbj, d, dircnt});
                        }
                        else{
                            if(dir != d) q.offer(new int[]{ni, nj, bi, bj, d, dircnt+1});
                            else q.offer(new int[]{ni, nj, bi, bj, d, dircnt});
                        }
                        visited[ni][nj] = true;
                    }
                }
            }
        }
    }

    private static boolean checkBlue(int bi, int bj, int dir, int[] hole) {
        boolean flag = false;
        while(true){
            int nbi = bi + di[dir];
            int nbj = bj + dj[dir];
            if(!inBound(nbi, nbj)) break;
            if(!map[nbi][nbj]) break;
            if(nbi == hole[0] && nbj == hole[1]){
                flag = true;
                break;
            }
            bi = nbi;
            bj = nbj;
        }
        return flag;
    }

    private static boolean inBound(int i, int j) {
        if(0<=i && i<N && 0<=j && j<M) return true;
        return false;
    }
}
