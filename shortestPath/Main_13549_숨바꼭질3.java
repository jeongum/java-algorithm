package shortestPath;

import java.util.*;
import java.io.*;

public class Main_13549_숨바꼭질3{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        System.out.println(dijkstra(N, K));;

    }

    private static int dijkstra(int n, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>(((o1, o2) -> Integer.compare(o1[1], o2[1])));
        int[] dist = new int[100001];
        Arrays.fill(dist, Integer.MAX_VALUE);

        q.offer(new int[]{n, 0});
        dist[n] = 0;
        while (!q.isEmpty()){
            int[] cur = q.poll();
            if(dist[cur[0]] < cur[1]) continue;
            if(cur[0] == k){
                break;
            }
            int[] ni = new int[]{cur[0]-1, cur[0]+1, cur[0]*2};     // 갈 수 있는 인덱스
            for(int i =0 ; i < 3; i++){
                if(0<=ni[i]&&ni[i]<100001){
                    int sec = (i == 0 || i == 1)? 1:0;  // *2 는 순간이동이므로 시간이 추가되지 않음
                    if(dist[ni[i]] > dist[cur[0]] + sec){
                        q.offer(new int[]{ni[i], dist[cur[0]] + sec});
                        dist[ni[i]] = dist[cur[0]] + sec;
                    }
                }
            }
        }

        return dist[k];
    }
}
