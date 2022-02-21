package tree;

import java.io.*;
import java.util.*;

public class Main_3584_가장가까운공통조상 {
    static int N, res;
    static int[] parent;
    static boolean[] visited;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int tc = 0 ; tc < T ; tc++){
            N = Integer.parseInt(br.readLine());
            parent = new int[N+1];
            for(int i =0 ; i < N+1 ; i++) parent[i] = i;
            visited = new boolean[N+1];
            StringTokenizer st = null;
            for(int i =0 ; i < N-1 ; i++){
                st = new StringTokenizer(br.readLine());
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                parent[c] = p;
            }
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            res = 0;
            nearestAnc(n1, n2);
            sb.append(res+"\n");
        }
        System.out.println(sb.toString());
    }

    private static void nearestAnc(int n1, int n2) {
        if(visited[n1] && parent[n1] != n1){
            res = n1; return;
        }
        if(visited[n2] && parent[n2] != n2){
            res = n2; return;
        }
        if(parent[n1] == parent[n2]){
            res = parent[n1]; return;
        }
        visited[n1] = visited[n2] = true;
        nearestAnc(parent[n1], parent[n2]);
    }
}
