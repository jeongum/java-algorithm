package mst;

import java.io.*;
import java.util.*;
public class Main_14621_나만안되는연애_Kruskal {
    static class Edge implements Comparable<Edge>{
        int x, y, cost;
        public Edge(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    static int N, M;
    static boolean[] gender;
    static Edge[] network;
    static int[] parent;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        gender = new boolean[N];
        network = new Edge[M];
        parent = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i =0 ; i < N ; i++){
            char g = st.nextToken().charAt(0);
            gender[i] = g=='W'?true:false;
        }

        for(int i =0 ; i < M ; i++){
            st = new StringTokenizer(br.readLine());
            network[i] = new Edge(Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken())-1,Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(network);

        makeSet();

        int result = 0, cnt = 0, tcnt = 0;
        for(Edge e : network){
            if(unionSet(e.x, e.y)){
                result += e.cost;
                if(++cnt == N-1) break;
            }
            tcnt++;
        }

        System.out.println(tcnt == M? -1:result);
    }

    private static boolean unionSet(int x, int y) {
        if(gender[x] == gender[y]) return false;
        int px = findP(x);
        int py = findP(y);
        if(px == py) return false;
        parent[py] = px;
        return true;
    }

    private static int findP(int x) {
        if(parent[x] == x) return x;
        return parent[x] = findP(parent[x]);
    }

    private static void makeSet() {
        for(int i =0 ; i < N ; i++) parent[i] = i;
    }
}
