package shortestPath;

import java.util.*;
import java.io.*;

public class Main_13549_숨바꼭질3{
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] map = new int[200000];
        boolean[] visited = new boolean[200000];

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[2]);
            }
        });

        Arrays.fill(map, Integer.MAX_VALUE);

        pq.offer(new int[]{N, 0});
        map[N] = 0;
        visited[N] = true;
        int res = 0;
        while (!pq.isEmpty()){
            int[] cur = pq.poll();
            if(cur[0] == K){
                res = cur[1];
                break;
            }

            if(cur[0]+1 < 200000 && !visited[cur[0]+1]){
                pq.offer(new int[]{cur[0]+1, cur[1]+1});
                visited[cur[0]+1] = true;
            }
            if(cur[0]-1 >= 0){
                pq.offer(new int[]{cur[0]-1, cur[1]+1});
                visited[cur[0]+1] = true;
            }
            if(cur[0]*2 < 200000 && !visited[cur[0]*2]){
                pq.offer(new int[]{cur[0]*2, cur[1]+1});
                visited[cur[0]*2] = true;
            }

        }
    }
}
