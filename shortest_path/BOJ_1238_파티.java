package shortest_path;

import java.util.*;
import java.io.*;

public class BOJ_1238_파티 {
    static int N,X;
    static List<int[]>[] road;
    static List<int[]>[] road_back;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken())-1;
        road = new List[N];      // X에서 N 마을로 가는 경로 판별할 때
        road_back = new List[N]; // N 마을들에서 X로 가는 경로 판별할 때
        for(int i =0 ; i < N ; i++){
            road[i] = new ArrayList<>();
            road_back[i] = new ArrayList<>();
        }
        for(int i =0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken())-1;
            int from = Integer.parseInt(st.nextToken())-1;
            int time = Integer.parseInt(st.nextToken());
            road[to].add(new int[]{from, time});
            road_back[from].add(new int[]{to, time});
        }

        int[] XToN = getDist(road);
        int[] NToX = getDist(road_back);

        int max = 0;
        for(int i =0 ; i < N ; i++){
            max = Math.max(max, XToN[i]+NToX[i]);
        }
        System.out.println(max);
    }

    private static int[] getDist(List<int[]>[] road) {
        int[] dist = new int[N];
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1[1], o2[1])));
        boolean[] visited = new boolean[N];

        pq.offer(new int[]{X, 0});
        dist[X] = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();

            if(visited[cur[0]]) continue;   // 이미 경로 탐색이 되어있으면 확인할 필요 없음
            visited[cur[0]] = true;

            for(int[] r:road[cur[0]]){
                if(dist[r[0]] > dist[cur[0]] + r[1]){   // 현재 노드를 들렸다 갈 때가 더 빠를 경우
                    dist[r[0]] = dist[cur[0]] + r[1];
                    pq.add(new int[]{r[0], dist[r[0]]});
                }
            }
        }

        return dist;
    }
}
