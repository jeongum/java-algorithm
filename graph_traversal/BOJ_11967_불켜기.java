package graph_traversal;

import java.io.*;
import java.util.*;

public class BOJ_11967_불켜기 {
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, -1, 0, 1};
    static int N;
    static List<int[]>[][] map; // 연결되어 있는 스위치 정보들을 List로 저장
    static boolean[][] cango;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        map = new List[N][N];
        cango = new boolean[N][N];
        for(int i =0 ; i < N ; i++)
            for(int j =0 ; j < N ; j++)
                map[i][j] = new ArrayList<>();

        for(int i =0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken())-1;
            int y1 = Integer.parseInt(st.nextToken())-1;
            int x2 = Integer.parseInt(st.nextToken())-1;
            int y2 = Integer.parseInt(st.nextToken())-1;
            map[x1][y1].add(new int[]{x2, y2});
        }

        while(turnOn()){}       // 더이상 상태 변경이 없을 때까지 탐색 지속

        int cnt = 0;
        for(int i =0 ; i < N ; i++){
            for(int j =0 ;j < N ; j++){
                if(cango[i][j]) cnt++;
            }
        }
        System.out.println(cnt);
    }

    private static boolean turnOn() {
        boolean[][] cangoTmp = new boolean[N][N];
        for(int i =0 ; i < N ; i++) cangoTmp[i] = Arrays.copyOf(cango[i], cango[i].length);
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[N][N];
        q.offer(new int[]{0,0});
        visited[0][0] = true;
        cango[0][0] = true;
        for(int[] i : map[0][0]) cango[i[0]][i[1]] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();
            for(int d =0 ; d < 4 ; d++){
                int ni = cur[0] + di[d];
                int nj = cur[1] + dj[d];
                if(0<=ni&&ni<N && 0<=nj&&nj<N){
                    if(!visited[ni][nj] && cango[ni][nj]){
                        for(int[] i : map[ni][nj]) cango[i[0]][i[1]] = true;        // 스위치 켜기
                        visited[ni][nj] = true;
                        q.offer(new int[]{ni, nj});
                    }
                }
            }
        }

        // 탐색 전과 다른 상태라면, 한번 더 탐색을 해야함!
        for(int i =0 ; i < N ; i++){
            for(int j = 0 ; j < N ; j++){
                if(cangoTmp[i][j] != cango[i][j]) return true;
            }
        }
        return false;
    }
}
