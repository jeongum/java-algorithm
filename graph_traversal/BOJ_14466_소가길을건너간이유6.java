package graph_traversal;

import java.io.*;
import java.util.*;

public class BOJ_14466_소가길을건너간이유6 {
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, -1, 0, 1};
    static int N,K,R;
    static List<int[]> bridge;  // 다리의 정보를 저장
    static List<int[]> cowPos;  // 소의 위치의 정보를 저장
    static int[][] map; // 영역을 저장
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        bridge = new ArrayList<>();
        cowPos = new ArrayList<>();
        map = new int[N][N];
        for(int i =0 ; i < N ; i++) Arrays.fill(map[i], -1);
        for(int i =0 ; i < R ; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            int r1 = Integer.parseInt(st.nextToken())-1;
            int c1 = Integer.parseInt(st.nextToken())-1;
            bridge.add(new int[]{r, c, r1, c1});
        }

        for(int i =0 ; i < K ; i++){
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken())-1;
            cowPos.add(new int[]{r, c});
        }

        for(int i = 0 ; i < K ; i++){ // 소가 있는 위치를 기준으로 탐색 시작
            if(map[cowPos.get(i)[0]][cowPos.get(i)[1]] == -1){  // 이미 탐색이 된 곳이라면 pass
                findWay(cowPos.get(i), i);
            }
        }

        int cnt = 0;
        for(int i =0 ; i < K-1 ; i++){
            for(int j = i+1 ; j < K ; j++){
                if(map[cowPos.get(i)[0]][cowPos.get(i)[1]] != map[cowPos.get(j)[0]][cowPos.get(j)[1]]) cnt ++;  // 영역이 다른 곳에 있으면 길을 건너야 하므로 cnt++
            }
        }

        System.out.println(cnt);
    }

    private static void findWay(int[] c, int area) {
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{c[0], c[1]});
        visited[c[0]][c[1]] = true;
        map[c[0]][c[1]] = area;
        while(!q.isEmpty()){
            int i = q.peek()[0];
            int j = q.poll()[1];
            next:for(int d = 0 ; d < 4 ; d++){
                int ni = i+di[d];
                int nj = j+dj[d];
                if(0<=ni&&ni<N && 0<=nj&&nj<N && !visited[ni][nj]){
                    for(int[] b: bridge){       // 둘 사이에 다리가 있는지 확인
                        if(b[0]==i&&b[1]==j && b[2]==ni&&b[3]==nj) continue next;
                        if(b[2]==i&&b[3]==j && b[0]==ni&&b[1]==nj) continue next;
                    }
                    q.offer(new int[]{ni, nj});
                    visited[ni][nj] = true;
                    map[ni][nj] = area; // 탐색한 자리의 영역을 표시
                }
            }
        }
    }
}
