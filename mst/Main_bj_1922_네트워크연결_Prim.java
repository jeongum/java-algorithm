package mst;

import java.util.*;
import java.io.*;

public class Main_bj_1922_네트워크연결_Prim {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[][] network = new int[N][N];
        int[] minEdge = new int[N];
        boolean[] visited = new boolean[N];

        for(int i = 0 ; i < M ; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken())-1;
            int y = Integer.parseInt(st.nextToken())-1;
            int c = Integer.parseInt(st.nextToken());
            network[x][y] = c;
            network[y][x] = c;
        }

        Arrays.fill(minEdge, Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        int result = 0 ; int cnt = 0;
        minEdge[0] = 0;
        pq.offer(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            if(visited[cur[0]]) continue;
            visited[cur[0]] = true;
            result += cur[1];

            if(cnt++ == N-1) break;
            for(int i =0 ; i < N ; i++){
                if(!visited[i] && network[cur[0]][i] != 0){
                    if(minEdge[i] > network[cur[0]][i]){
                        minEdge[i] = network[cur[0]][i];
                        pq.offer(new int[]{i, network[cur[0]][i]});
                    }
                }
            }
        }

        System.out.println(result);


    }
}
