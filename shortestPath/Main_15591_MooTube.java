package shortestPath;

import java.util.*;
import java.io.*;

public class Main_15591_MooTube {
    static List<int[]>[] usado;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        usado = new List[N];
        for(int i =0 ; i < N ; i++) usado[i] = new ArrayList<>();
        for(int i =0 ; i < N-1 ; i++){
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken())-1;
            int from = Integer.parseInt(st.nextToken())-1;
            int usa = Integer.parseInt(st.nextToken());
            usado[to].add(new int[]{from, usa});
            usado[from].add(new int[]{to, usa});
        }

        StringBuilder sb = new StringBuilder();
        for(int i =0 ; i < Q ; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken())-1;
            sb.append(recommend(N, k, v)+"\n");
        }
        System.out.println(sb);
    }

    private static int recommend(int N, int k, int v) {
        int res = 0;
        Queue<int[]> q = new ArrayDeque<>();
        boolean[] visited = new boolean[N];
        q.offer(new int[]{v, Integer.MAX_VALUE});
        visited[v] = true;
        while(!q.isEmpty()){
            int[] node = q.poll();
            for(int[] tmp:usado[node[0]]) {
                if(visited[tmp[0]]) continue;
                int usd = Math.min(tmp[1], node[1]);
                q.add(new int[]{tmp[0], usd});
                visited[tmp[0]] = true;
                if(usd >= k) res++;
            }
        }
        return res;
    }
}
