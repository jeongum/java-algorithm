package graphTraversal;

import java.io.*;
import java.util.*;

public class Main_2194_유닛이동시키기 {
    static int[] di = {-1,0,1,0};
    static int[] dj = {0,-1,0,1};
    static int N, M, A, B;
    static boolean[][] map;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new boolean[N][M];

        for(int i =0 ; i < K ; i++){
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1] = true;
        }

        st = new StringTokenizer(br.readLine());
        int[] start = {Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1};

        st = new StringTokenizer(br.readLine());
        int[] end = {Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1};

        System.out.println(moveUnit(start, end));
    }

    private static int moveUnit(int[] start, int[] end) {
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][M];
        q.add(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()){
            int[] cur = q.poll();
            if(cur[0]==end[0] && cur[1]==end[1]) return cur[2];

            for(int d = 0 ; d < 4 ; d ++){
                int ni = cur[0] + di[d];
                int nj = cur[1] + dj[d];
                if(isValid(ni, nj) && !visited[ni][nj]){
                    q.offer(new int[]{ni, nj, cur[2]+1});
                    visited[ni][nj] = true;
                }
            }
        }
        return -1;
    }

    private static boolean isValid(int i, int j) {
        for(int x = 0 ; x <A ; x++){
            for(int y = 0 ; y < B ; y++){
                int ni = i + x;
                int nj = j + y;
                if(0>ni || ni>=N || 0>nj || nj>=M ) return false;
                else if(map[ni][nj]) return false;
            }
        }
        return true;
    }
}
