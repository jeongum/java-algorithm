package graph_traversal;

import java.util.*;
import java.io.*;

public class Main_6118_숨바꼭질 {
    static int N, M;
    static List<Integer>[] farm;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        farm = new List[N];
        for(int i =0 ; i < N ; i++) farm[i] = new ArrayList<>();

        for(int i =0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            int to = Integer.parseInt(st.nextToken())-1;
            int from = Integer.parseInt(st.nextToken())-1;
            farm[to].add(from);
            farm[from].add(to);
        }

        int num = 0, dis = 0, cnt = 0;

        boolean[] visited = new boolean[N];
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[] {0,0});
        visited[0] = true;
        while(!q.isEmpty()){
            int[] c = q.poll();
            int pos = c[0];
            int depth = c[1];

            if(depth == dis){
                if(pos < num) num = pos;
                cnt++;
            }
            else if(depth > dis){
                num = pos;
                dis = depth;
                cnt = 1;
            }

            for(int i : farm[pos]){
                if(!visited[i]){
                    q.offer(new int[]{i, depth+1});
                    visited[i] = true;
                }
            }
        }

        System.out.println(num+1+" "+dis+" "+cnt);

    }
}
