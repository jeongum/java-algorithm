package shortest_path;

import java.util.*;
import java.io.*;

public class BOJ_1446_지름길 {
    static int N, D;
    static List<int[]>[] path;
    static int[] dist;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        dist = new int[D+1];
        path = new List[D+1];

        for(int i =0 ; i <= D ; i++){
            dist[i] = Integer.MAX_VALUE;
            path[i] = new ArrayList<>();
        }

        for(int i =0 ; i < N ; i++){
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            if(from > D || to > D) continue;
            path[from].add(new int[]{to, dis});
        }
        dist[0] = 0;
        findPath(0);

        System.out.println(dist[D]);
    }

    private static void findPath(int idx) {
        if(idx >= D) return;

        if(dist[idx] != Integer.MAX_VALUE && dist[idx + 1] > dist[idx] + 1){  // 일단 기본 셋팅
            dist[idx + 1] = dist[idx] + 1;
        }

        for(int i =0 ; i < path[idx].size() ; i++){
            dist[path[idx].get(i)[0]] = Math.min(dist[idx] + path[idx].get(i)[1], dist[path[idx].get(i)[0]]);
        }

        findPath(idx+1);
    }
}
