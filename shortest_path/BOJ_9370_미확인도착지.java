package shortest_path;

import java.util.*;
import java.io.*;

public class BOJ_9370_미확인도착지 {
    static int n, m, t, s, g, h;
    static List<int[]>[] path;
    static int[] dist;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc =0 ; tc < T ; tc++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken())-1;
            g = Integer.parseInt(st.nextToken())-1;
            h = Integer.parseInt(st.nextToken())-1;
            path = new List[n];
            for(int i = 0 ; i < n ; i++) path[i] = new ArrayList<>();
            for(int i = 0 ; i < m ; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                int d = Integer.parseInt(st.nextToken());
                if ((a == g && b == h) || (b == g && a == h)) {
                    path[a].add(new int[]{b, d*2 - 1});
                    path[b].add(new int[]{a, d*2 - 1});
                }
                else {
                    path[a].add(new int[]{b, d*2});
                    path[b].add(new int[]{a, d*2});
                }
            }
            // 목적지까지 최단거리를 가는데, 중간에 g,h를 건넌다면 OK
            dijkstra();

            int[] dest = new int[t];
            for(int i =0 ; i < t ; i++){
                dest[i] = Integer.parseInt(br.readLine())-1;
            }
            Arrays.sort(dest);
            for(int i =0 ; i < t ; i++){
                if(dist[dest[i]] % 2 == 1) sb.append(dest[i]+1+" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    private static void dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[1], o2[1]));
        pq.offer(new int[]{s, 0});
        dist = new int[n];
        Arrays.fill(dist, 1_000_000_000);
        dist[s] = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int cur_node = cur[0];
            int cur_cost = cur[1];

            if(dist[cur_node] < cur_cost) continue;

            for(int[] next: path[cur_node]){
                int next_node = next[0];
                int next_cost = next[1];
                if(dist[next_node] > dist[cur_node] + next_cost){
                    dist[next_node] = dist[cur_node] + next_cost;
                    pq.offer(new int[]{next_node, dist[next_node]});
                }
            }
        }
    }
}
