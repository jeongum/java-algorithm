package shortest_path;

import java.util.*;
import java.io.*;

public class BOJ_1916_최소비용구하기 {
    static int N, M, A, B;
    static List<int[]>[] bus;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());
        bus = new List[N];
        for(int i =0 ; i < N ; i++) bus[i] = new ArrayList<>();
        for(int i =0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken())-1;
            int from = Integer.parseInt(st.nextToken())-1;
            int cost = Integer.parseInt(st.nextToken());
            bus[to].add(new int[]{from, cost});
        }
        st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken())-1;
        B = Integer.parseInt(st.nextToken())-1;

        System.out.println(dijkstra());
    }

    private static int dijkstra() {
        PriorityQueue<int[]> pq = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1[1], o2[1])));
        int[] dist = new int[N];

        pq.add(new int[]{A, 0});
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[A] = 0;

        while(!pq.isEmpty()){
            int[] cur = pq.poll();
            int cur_node = cur[0];
            int cur_cost = cur[1];

            if(dist[cur_node] < cur_cost) continue;

            for(int[] next: bus[cur_node]){
                int next_node = next[0];
                int next_cost = next[1];
                if(dist[next_node] > dist[cur_node] + next_cost){
                    dist[next_node] = dist[cur_node] + next_cost;
                    pq.add(new int[]{next_node, dist[next_node]});
                }
            }
        }

        return dist[B];
    }
}
