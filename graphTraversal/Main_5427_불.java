package graphTraversal;

import java.io.*;
import java.util.*;

public class Main_5427_불 {
    static int[] di = {-1,0,1,0};   // 상 좌 하 우
    static int[] dj = {0,-1,0,1};
    static int N, M, res;
    static char[][] map;
    static List<int[]> fire;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int tc = 0 ; tc < T ; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            map = new char[N][M];
            fire = new ArrayList<>();

            int[] cur = new int[2];

            for(int i =0 ; i < N ; i++){
                String str = br.readLine();
                for(int j =0 ; j < M ; j++){
                    map[i][j] = str.charAt(j);
                    if(map[i][j] == '*'){
                        fire.add(new int[]{i, j});
                    }
                    else if(map[i][j] == '@'){
                        cur[0] = i; cur[1] = j;
                        map[i][j] = '.';
                    }
                }
            }

            res = -1;
            findWay(cur[0], cur[1]);

            System.out.println((res==-1)?"IMPOSSIBLE":res);
        }

    }

    private static void findWay(int i, int j) {
        Queue<int[]> q = new ArrayDeque<>();
        int time = 0;
        boolean[][] visited = new boolean[N][M];
        q.offer(new int[]{i, j, 0});
        visited[i][j] = true;
        while(!q.isEmpty()){
            int[] cur = q.poll();

            if(time != cur[2]){     // depth 늘어날 때마다 불 확산
                spreadFire();
                time = cur[2];
            }

            if(map[cur[0]][cur[1]] == '*') continue;       // 가려는 길에 불이 확산되어 있으면

            if(cur[0] == 0 || cur[0] == N-1 || cur[1] == 0 || cur[1] == M-1){       // 종료조건: 모서리에 있을 경우
                res = cur[2]+1; // 건물 밖으로 나가는 시간까지 +1
                return;
            }

            for(int d = 0; d < 4 ; d ++){
                int ni = cur[0] + di[d];
                int nj = cur[1] + dj[d];
                if(0<=ni&&ni<N && 0<=nj&&nj<M){
                    if(!visited[ni][nj] && map[ni][nj] == '.'){
                        visited[ni][nj] = true;
                        q.offer(new int[]{ni, nj, cur[2]+1});
                    }
                }
            }
        }

    }

    private static void spreadFire() {
        List<int[]> tmp = new ArrayList<>();
        for(int[] f: fire){
            for(int d = 0 ; d < 4 ; d++){
                int ni = f[0] + di[d];
                int nj = f[1] + dj[d];
                if(0<=ni&&ni<N && 0<=nj&&nj<M){
                    if(map[ni][nj] == '.'){
                        map[ni][nj] = '*';
                        tmp.add(new int[]{ni, nj});
                    }
                }
            }
        }
        fire.clear();
        fire.addAll(tmp);
    }
}
